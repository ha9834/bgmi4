package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferProgress;
import com.amazonaws.services.s3.model.LegacyS3ProgressListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public abstract class AbstractTransfer implements Transfer {
    private final String description;
    protected TransferMonitor monitor;
    protected final ProgressListenerChain progressListenerChain;
    protected volatile Transfer.TransferState state;
    protected final Collection<TransferStateChangeListener> stateChangeListeners;
    private final TransferProgress transferProgress;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractTransfer(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain) {
        this(str, transferProgress, progressListenerChain, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractTransfer(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, TransferStateChangeListener transferStateChangeListener) {
        this.state = Transfer.TransferState.Waiting;
        this.stateChangeListeners = new LinkedList();
        this.description = str;
        this.progressListenerChain = progressListenerChain;
        this.transferProgress = transferProgress;
        addStateChangeListener(transferStateChangeListener);
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public synchronized boolean isDone() {
        boolean z;
        if (this.state != Transfer.TransferState.Failed && this.state != Transfer.TransferState.Completed) {
            z = this.state == Transfer.TransferState.Canceled;
        }
        return z;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public void waitForCompletion() throws AmazonClientException, AmazonServiceException, InterruptedException {
        Object obj = null;
        while (true) {
            try {
                if (this.monitor.isDone() && obj != null) {
                    return;
                } else {
                    obj = this.monitor.getFuture().get();
                }
            } catch (ExecutionException e) {
                rethrowExecutionException(e);
                return;
            }
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public AmazonClientException waitForException() throws InterruptedException {
        while (!this.monitor.isDone()) {
            try {
                this.monitor.getFuture().get();
            } catch (ExecutionException e) {
                return unwrapExecutionException(e);
            }
        }
        this.monitor.getFuture().get();
        return null;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public String getDescription() {
        return this.description;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public synchronized Transfer.TransferState getState() {
        return this.state;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setState(Transfer.TransferState transferState) {
        synchronized (this) {
            this.state = transferState;
        }
        Iterator<TransferStateChangeListener> it = this.stateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().transferStateChanged(this, transferState);
        }
    }

    public void notifyStateChangeListeners(Transfer.TransferState transferState) {
        Iterator<TransferStateChangeListener> it = this.stateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().transferStateChanged(this, transferState);
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public synchronized void addProgressListener(ProgressListener progressListener) {
        this.progressListenerChain.addProgressListener(progressListener);
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public synchronized void removeProgressListener(ProgressListener progressListener) {
        this.progressListenerChain.removeProgressListener(progressListener);
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    @Deprecated
    public synchronized void addProgressListener(com.amazonaws.services.s3.model.ProgressListener progressListener) {
        this.progressListenerChain.addProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    @Deprecated
    public synchronized void removeProgressListener(com.amazonaws.services.s3.model.ProgressListener progressListener) {
        this.progressListenerChain.removeProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    public synchronized void addStateChangeListener(TransferStateChangeListener transferStateChangeListener) {
        if (transferStateChangeListener != null) {
            this.stateChangeListeners.add(transferStateChangeListener);
        }
    }

    public synchronized void removeStateChangeListener(TransferStateChangeListener transferStateChangeListener) {
        if (transferStateChangeListener != null) {
            this.stateChangeListeners.remove(transferStateChangeListener);
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public TransferProgress getProgress() {
        return this.transferProgress;
    }

    public void setMonitor(TransferMonitor transferMonitor) {
        this.monitor = transferMonitor;
    }

    public TransferMonitor getMonitor() {
        return this.monitor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fireProgressEvent(int i) {
        ProgressListenerCallbackExecutor.progressChanged(this.progressListenerChain, new ProgressEvent(i, 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rethrowExecutionException(ExecutionException executionException) {
        throw unwrapExecutionException(executionException);
    }

    protected AmazonClientException unwrapExecutionException(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        if (cause instanceof AmazonClientException) {
            return (AmazonClientException) cause;
        }
        return new AmazonClientException("Unable to complete transfer: " + cause.getMessage(), cause);
    }
}
