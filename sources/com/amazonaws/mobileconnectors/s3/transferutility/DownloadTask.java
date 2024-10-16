package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DownloadTask implements Callable<Boolean> {
    private static final Log LOGGER = LogFactory.getLog(DownloadTask.class);
    private static final int SIXTEEN_KB = 16384;
    private final TransferRecord download;
    private final TransferService.NetworkInfoReceiver networkInfo;
    private final AmazonS3 s3;
    private final TransferStatusUpdater updater;

    public DownloadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater, TransferService.NetworkInfoReceiver networkInfoReceiver) {
        this.download = transferRecord;
        this.s3 = amazonS3;
        this.updater = transferStatusUpdater;
        this.networkInfo = networkInfoReceiver;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        if (!this.networkInfo.isNetworkConnected()) {
            this.updater.updateState(this.download.id, TransferState.WAITING_FOR_NETWORK);
            return false;
        }
        this.updater.updateState(this.download.id, TransferState.IN_PROGRESS);
        GetObjectRequest getObjectRequest = new GetObjectRequest(this.download.bucketName, this.download.key);
        TransferUtility.appendTransferServiceUserAgentString(getObjectRequest);
        File file = new File(this.download.file);
        long length = file.length();
        if (length > 0) {
            LOGGER.debug(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.download.id), Long.valueOf(length)));
            getObjectRequest.setRange(length, -1L);
        }
        getObjectRequest.setGeneralProgressListener(this.updater.newProgressListener(this.download.id));
        try {
            S3Object object = this.s3.getObject(getObjectRequest);
            if (object == null) {
                this.updater.throwError(this.download.id, new IllegalStateException("AmazonS3.getObject returns null"));
                this.updater.updateState(this.download.id, TransferState.FAILED);
                return false;
            }
            long instanceLength = object.getObjectMetadata().getInstanceLength();
            this.updater.updateProgress(this.download.id, length, instanceLength);
            saveToFile(object.getObjectContent(), file);
            this.updater.updateProgress(this.download.id, instanceLength, instanceLength);
            this.updater.updateState(this.download.id, TransferState.COMPLETED);
            return true;
        } catch (Exception e) {
            if (RetryUtils.isInterrupted(e)) {
                LOGGER.debug("Transfer " + this.download.id + " is interrupted by user");
            } else if (e.getCause() != null && (((e.getCause() instanceof IOException) || (e.getCause() instanceof AmazonClientException)) && !this.networkInfo.isNetworkConnected())) {
                LOGGER.debug("Transfer " + this.download.id + " waits for network");
                this.updater.updateState(this.download.id, TransferState.WAITING_FOR_NETWORK);
            } else {
                LOGGER.debug("Failed to download: " + this.download.id + " due to " + e.getMessage());
                this.updater.throwError(this.download.id, e);
                this.updater.updateState(this.download.id, TransferState.FAILED);
            }
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void saveToFile(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, file.length() > 0));
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[SIXTEEN_KB];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            LOGGER.warn("got exception", e);
                        }
                    }
                }
                bufferedOutputStream.close();
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    LOGGER.warn("got exception", e2);
                }
            } catch (SocketTimeoutException e3) {
                e = e3;
                String str = "SocketTimeoutException: Unable to retrieve contents over network: " + e.getMessage();
                LOGGER.error(str);
                throw new AmazonClientException(str, e);
            } catch (IOException e4) {
                e = e4;
                throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e5) {
                        LOGGER.warn("got exception", e5);
                    }
                }
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException e6) {
                    LOGGER.warn("got exception", e6);
                    throw th;
                }
            }
        } catch (SocketTimeoutException e7) {
            e = e7;
        } catch (IOException e8) {
            e = e8;
        }
    }
}
