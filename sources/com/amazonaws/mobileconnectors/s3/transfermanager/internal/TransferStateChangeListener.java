package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;

/* loaded from: classes.dex */
public interface TransferStateChangeListener {
    void transferStateChanged(Transfer transfer, Transfer.TransferState transferState);
}
