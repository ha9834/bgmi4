package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Deprecated
/* loaded from: classes.dex */
public final class TransferProgress {
    private static final Log log = LogFactory.getLog(TransferProgress.class);
    protected volatile long bytesTransferred = 0;
    protected volatile long totalBytesToTransfer = -1;

    @Deprecated
    public long getBytesTransfered() {
        return getBytesTransferred();
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public long getTotalBytesToTransfer() {
        return this.totalBytesToTransfer;
    }

    @Deprecated
    public synchronized double getPercentTransfered() {
        return getPercentTransferred();
    }

    public synchronized double getPercentTransferred() {
        double d;
        if (getBytesTransferred() < 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (this.totalBytesToTransfer < 0) {
            d = -1.0d;
        } else {
            double d2 = this.bytesTransferred;
            double d3 = this.totalBytesToTransfer;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d = (d2 / d3) * 100.0d;
        }
        return d;
    }

    public synchronized void updateProgress(long j) {
        this.bytesTransferred += j;
        if (this.totalBytesToTransfer > -1 && this.bytesTransferred > this.totalBytesToTransfer) {
            this.bytesTransferred = this.totalBytesToTransfer;
            if (log.isDebugEnabled()) {
                log.debug("Number of bytes transfered is more than the actual total bytes to transfer. Total number of bytes to Transfer : " + this.totalBytesToTransfer + ". Bytes Transferred : " + (this.bytesTransferred + j));
            }
        }
    }

    public void setTotalBytesToTransfer(long j) {
        this.totalBytesToTransfer = j;
    }
}
