package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.util.concurrent.Callable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
class UploadPartTask implements Callable<Boolean> {
    private static final Log LOGGER = LogFactory.getLog(UploadPartTask.class);
    private final TransferDBUtil dbUtil;
    private final TransferService.NetworkInfoReceiver networkInfoReceiver;
    private final UploadPartRequest request;
    private final AmazonS3 s3;

    public UploadPartTask(UploadPartRequest uploadPartRequest, AmazonS3 amazonS3, TransferDBUtil transferDBUtil) {
        this.request = uploadPartRequest;
        this.s3 = amazonS3;
        this.dbUtil = transferDBUtil;
        this.networkInfoReceiver = null;
    }

    public UploadPartTask(UploadPartRequest uploadPartRequest, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferService.NetworkInfoReceiver networkInfoReceiver) {
        this.request = uploadPartRequest;
        this.s3 = amazonS3;
        this.dbUtil = transferDBUtil;
        this.networkInfoReceiver = networkInfoReceiver;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        try {
            UploadPartResult uploadPart = this.s3.uploadPart(this.request);
            this.dbUtil.updateState(this.request.getId(), TransferState.PART_COMPLETED);
            this.dbUtil.updateETag(this.request.getId(), uploadPart.getETag());
            return true;
        } catch (Exception e) {
            if (RetryUtils.isInterrupted(e)) {
                return false;
            }
            TransferService.NetworkInfoReceiver networkInfoReceiver = this.networkInfoReceiver;
            if (networkInfoReceiver != null && !networkInfoReceiver.isNetworkConnected()) {
                this.dbUtil.updateState(this.request.getId(), TransferState.WAITING_FOR_NETWORK);
                LOGGER.debug("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
            } else {
                this.dbUtil.updateState(this.request.getId(), TransferState.FAILED);
                LOGGER.error("Encountered error uploading part ", e);
            }
            throw e;
        }
    }
}
