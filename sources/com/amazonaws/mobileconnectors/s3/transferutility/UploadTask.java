package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class UploadTask implements Callable<Boolean> {
    private final TransferDBUtil dbUtil;
    private final TransferService.NetworkInfoReceiver networkInfo;
    private final AmazonS3 s3;
    private final TransferStatusUpdater updater;
    private final TransferRecord upload;
    private static final Log LOGGER = LogFactory.getLog(UploadTask.class);
    private static final Map<String, CannedAccessControlList> CANNED_ACL_MAP = new HashMap();

    static {
        for (CannedAccessControlList cannedAccessControlList : CannedAccessControlList.values()) {
            CANNED_ACL_MAP.put(cannedAccessControlList.toString(), cannedAccessControlList);
        }
    }

    public UploadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater, TransferService.NetworkInfoReceiver networkInfoReceiver) {
        this.upload = transferRecord;
        this.s3 = amazonS3;
        this.dbUtil = transferDBUtil;
        this.updater = transferStatusUpdater;
        this.networkInfo = networkInfoReceiver;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        if (!this.networkInfo.isNetworkConnected()) {
            this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
            return false;
        }
        this.updater.updateState(this.upload.id, TransferState.IN_PROGRESS);
        if (this.upload.isMultipart == 1 && this.upload.partNumber == 0) {
            return uploadMultipartAndWaitForCompletion();
        }
        if (this.upload.isMultipart == 0) {
            return uploadSinglePartAndWaitForCompletion();
        }
        return false;
    }

    private Boolean uploadMultipartAndWaitForCompletion() throws ExecutionException {
        long j;
        if (this.upload.multipartId == null || this.upload.multipartId.isEmpty()) {
            PutObjectRequest createPutObjectRequest = createPutObjectRequest(this.upload);
            TransferUtility.appendMultipartTransferServiceUserAgentString(createPutObjectRequest);
            try {
                this.upload.multipartId = initiateMultipartUpload(createPutObjectRequest);
                this.dbUtil.updateMultipartId(this.upload.id, this.upload.multipartId);
                j = 0;
            } catch (AmazonClientException e) {
                LOGGER.error("Error initiating multipart upload: " + this.upload.id + " due to " + e.getMessage(), e);
                this.updater.throwError(this.upload.id, e);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
        } else {
            long queryBytesTransferredByMainUploadId = this.dbUtil.queryBytesTransferredByMainUploadId(this.upload.id);
            if (queryBytesTransferredByMainUploadId > 0) {
                LOGGER.debug(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.upload.id), Long.valueOf(queryBytesTransferredByMainUploadId)));
            }
            j = queryBytesTransferredByMainUploadId;
        }
        this.updater.updateProgress(this.upload.id, j, this.upload.bytesTotal);
        List<UploadPartRequest> nonCompletedPartRequestsFromDB = this.dbUtil.getNonCompletedPartRequestsFromDB(this.upload.id, this.upload.multipartId);
        LOGGER.debug("multipart upload " + this.upload.id + " in " + nonCompletedPartRequestsFromDB.size() + " parts.");
        ArrayList arrayList = new ArrayList();
        for (UploadPartRequest uploadPartRequest : nonCompletedPartRequestsFromDB) {
            TransferUtility.appendMultipartTransferServiceUserAgentString(uploadPartRequest);
            uploadPartRequest.setGeneralProgressListener(this.updater.newProgressListener(this.upload.id));
            arrayList.add(TransferThreadPool.submitTask(new UploadPartTask(uploadPartRequest, this.s3, this.dbUtil, this.networkInfo)));
        }
        try {
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                z &= ((Boolean) ((Future) it.next()).get()).booleanValue();
            }
            if (!z) {
                return false;
            }
            try {
                completeMultiPartUpload(this.upload.id, this.upload.bucketName, this.upload.key, this.upload.multipartId);
                this.updater.updateProgress(this.upload.id, this.upload.bytesTotal, this.upload.bytesTotal);
                this.updater.updateState(this.upload.id, TransferState.COMPLETED);
                return true;
            } catch (AmazonClientException e2) {
                LOGGER.error("Failed to complete multipart: " + this.upload.id + " due to " + e2.getMessage(), e2);
                this.updater.throwError(this.upload.id, e2);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
        } catch (InterruptedException unused) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Future) it2.next()).cancel(true);
            }
            LOGGER.debug("Transfer " + this.upload.id + " is interrupted by user");
            return false;
        } catch (ExecutionException e3) {
            if (e3.getCause() != null && (e3.getCause() instanceof Exception)) {
                if (this.dbUtil.checkWaitingForNetworkPartRequestsFromDB(this.upload.id)) {
                    LOGGER.debug("Network Connection Interrupted: Transfer " + this.upload.id + " waits for network");
                    this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                    return false;
                }
                Exception exc = (Exception) e3.getCause();
                if (RetryUtils.isInterrupted(exc)) {
                    LOGGER.debug("Transfer " + this.upload.id + " is interrupted by user");
                    return false;
                }
                if (exc.getCause() != null && (exc.getCause() instanceof IOException) && !this.networkInfo.isNetworkConnected()) {
                    LOGGER.debug("Transfer " + this.upload.id + " waits for network");
                    this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                }
                this.updater.throwError(this.upload.id, exc);
            }
            this.updater.updateState(this.upload.id, TransferState.FAILED);
            return false;
        }
    }

    private Boolean uploadSinglePartAndWaitForCompletion() {
        PutObjectRequest createPutObjectRequest = createPutObjectRequest(this.upload);
        long length = createPutObjectRequest.getFile().length();
        TransferUtility.appendTransferServiceUserAgentString(createPutObjectRequest);
        this.updater.updateProgress(this.upload.id, 0L, length);
        createPutObjectRequest.setGeneralProgressListener(this.updater.newProgressListener(this.upload.id));
        try {
            this.s3.putObject(createPutObjectRequest);
            this.updater.updateProgress(this.upload.id, length, length);
            this.updater.updateState(this.upload.id, TransferState.COMPLETED);
            return true;
        } catch (Exception e) {
            if (RetryUtils.isInterrupted(e)) {
                LOGGER.debug("Transfer " + this.upload.id + " is interrupted by user");
                return false;
            }
            if (e.getCause() != null && (e.getCause() instanceof AmazonClientException) && !this.networkInfo.isNetworkConnected()) {
                LOGGER.debug("Network Connection Interrupted: Transfer " + this.upload.id + " waits for network");
                this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                return false;
            }
            if (e.getCause() != null && (e.getCause() instanceof IOException) && !this.networkInfo.isNetworkConnected()) {
                LOGGER.debug("Transfer " + this.upload.id + " waits for network");
                this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
            }
            LOGGER.debug("Failed to upload: " + this.upload.id + " due to " + e.getMessage(), e);
            this.updater.throwError(this.upload.id, e);
            this.updater.updateState(this.upload.id, TransferState.FAILED);
            return false;
        }
    }

    private void completeMultiPartUpload(int i, String str, String str2, String str3) {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, this.dbUtil.queryPartETagsOfUpload(i));
        TransferUtility.appendMultipartTransferServiceUserAgentString(completeMultipartUploadRequest);
        this.s3.completeMultipartUpload(completeMultipartUploadRequest);
    }

    private String initiateMultipartUpload(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest withSSEAwsKeyManagementParams = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata()).withSSEAwsKeyManagementParams(putObjectRequest.getSSEAwsKeyManagementParams());
        TransferUtility.appendMultipartTransferServiceUserAgentString(withSSEAwsKeyManagementParams);
        return this.s3.initiateMultipartUpload(withSSEAwsKeyManagementParams).getUploadId();
    }

    private PutObjectRequest createPutObjectRequest(TransferRecord transferRecord) {
        File file = new File(transferRecord.file);
        PutObjectRequest putObjectRequest = new PutObjectRequest(transferRecord.bucketName, transferRecord.key, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.length());
        if (transferRecord.headerCacheControl != null) {
            objectMetadata.setCacheControl(transferRecord.headerCacheControl);
        }
        if (transferRecord.headerContentDisposition != null) {
            objectMetadata.setContentDisposition(transferRecord.headerContentDisposition);
        }
        if (transferRecord.headerContentEncoding != null) {
            objectMetadata.setContentEncoding(transferRecord.headerContentEncoding);
        }
        if (transferRecord.headerContentType != null) {
            objectMetadata.setContentType(transferRecord.headerContentType);
        } else {
            objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
        }
        if (transferRecord.expirationTimeRuleId != null) {
            objectMetadata.setExpirationTimeRuleId(transferRecord.expirationTimeRuleId);
        }
        if (transferRecord.httpExpires != null) {
            objectMetadata.setHttpExpiresDate(new Date(Long.valueOf(transferRecord.httpExpires).longValue()));
        }
        if (transferRecord.sseAlgorithm != null) {
            objectMetadata.setSSEAlgorithm(transferRecord.sseAlgorithm);
        }
        if (transferRecord.userMetadata != null) {
            objectMetadata.setUserMetadata(transferRecord.userMetadata);
        }
        if (transferRecord.md5 != null) {
            objectMetadata.setContentMD5(transferRecord.md5);
        }
        if (transferRecord.sseKMSKey != null) {
            putObjectRequest.setSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(transferRecord.sseKMSKey));
        }
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setCannedAcl(getCannedAclFromString(transferRecord.cannedAcl));
        return putObjectRequest;
    }

    private static CannedAccessControlList getCannedAclFromString(String str) {
        if (str == null) {
            return null;
        }
        return CANNED_ACL_MAP.get(str);
    }
}
