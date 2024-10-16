package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferProgress;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class MultipleFileTransfer<T extends Transfer> extends AbstractTransfer {
    private AtomicBoolean subTransferStarted;
    protected final Collection<? extends T> subTransfers;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultipleFileTransfer(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, Collection<? extends T> collection) {
        super(str, transferProgress, progressListenerChain);
        this.subTransferStarted = new AtomicBoolean(false);
        this.subTransfers = collection;
    }

    public void collateFinalState() {
        boolean z = false;
        for (T t : this.subTransfers) {
            if (t.getState() == Transfer.TransferState.Failed) {
                setState(Transfer.TransferState.Failed);
                return;
            } else if (t.getState() == Transfer.TransferState.Canceled) {
                z = true;
            }
        }
        if (z) {
            setState(Transfer.TransferState.Canceled);
        } else {
            setState(Transfer.TransferState.Completed);
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.AbstractTransfer
    public void setState(Transfer.TransferState transferState) {
        super.setState(transferState);
        switch (transferState) {
            case Waiting:
                fireProgressEvent(1);
                return;
            case InProgress:
                if (this.subTransferStarted.compareAndSet(false, true)) {
                    fireProgressEvent(2);
                    return;
                }
                return;
            case Completed:
                fireProgressEvent(4);
                return;
            case Canceled:
                fireProgressEvent(16);
                return;
            case Failed:
                fireProgressEvent(8);
                return;
            default:
                return;
        }
    }
}
