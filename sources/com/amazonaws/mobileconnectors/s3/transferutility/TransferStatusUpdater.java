package com.amazonaws.mobileconnectors.s3.transferutility;

import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TransferStatusUpdater {
    private static final int UPDATE_THRESHOLD_MS = 1000;
    private final TransferDBUtil dbUtil;
    private static final Log LOGGER = LogFactory.getLog(TransferStatusUpdater.class);
    private static final HashSet<TransferState> STATES_NOT_TO_NOTIFY = new HashSet<>(Arrays.asList(TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT));
    static final Map<Integer, List<TransferListener>> LISTENERS = new HashMap();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map<Integer, TransferRecord> transfers = new HashMap();
    private final Map<Integer, Long> lastUpdateTime = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransferStatusUpdater(TransferDBUtil transferDBUtil) {
        this.dbUtil = transferDBUtil;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<Integer, TransferRecord> getTransfers() {
        return Collections.unmodifiableMap(this.transfers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTransfer(TransferRecord transferRecord) {
        this.transfers.put(Integer.valueOf(transferRecord.id), transferRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransferRecord getTransfer(int i) {
        return this.transfers.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeTransfer(int i) {
        this.transfers.remove(Integer.valueOf(i));
        LISTENERS.remove(Integer.valueOf(i));
        this.lastUpdateTime.remove(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateState(final int i, final TransferState transferState) {
        final List<TransferListener> list;
        boolean contains = STATES_NOT_TO_NOTIFY.contains(transferState);
        TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i));
        if (transferRecord == null) {
            if (this.dbUtil.updateState(i, transferState) == 0) {
                LOGGER.warn("Failed to update the status of transfer " + i);
            }
        } else {
            contains |= transferState.equals(transferRecord.state);
            transferRecord.state = transferState;
            if (this.dbUtil.updateTransferRecord(transferRecord) == 0) {
                LOGGER.warn("Failed to update the status of transfer " + i);
            }
        }
        if (contains || (list = LISTENERS.get(Integer.valueOf(i))) == null || list.isEmpty()) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TransferListener) it.next()).onStateChanged(i, transferState);
                }
                if (TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState)) {
                    list.clear();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateProgress(final int i, final long j, final long j2) {
        TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i));
        if (transferRecord != null) {
            transferRecord.bytesCurrent = j;
            transferRecord.bytesTotal = j2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.dbUtil.updateBytesTransferred(i, j);
        final List<TransferListener> list = LISTENERS.get(Integer.valueOf(i));
        if (list == null || list.isEmpty()) {
            return;
        }
        if (!this.lastUpdateTime.containsKey(Integer.valueOf(i)) || currentTimeMillis - this.lastUpdateTime.get(Integer.valueOf(i)).longValue() > 1000 || j == j2) {
            this.lastUpdateTime.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
            this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((TransferListener) it.next()).onProgressChanged(i, j, j2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void throwError(final int i, final Exception exc) {
        final List<TransferListener> list = LISTENERS.get(Integer.valueOf(i));
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TransferListener) it.next()).onError(i, exc);
                }
            }
        });
    }

    void clear() {
        LISTENERS.clear();
        this.transfers.clear();
        this.lastUpdateTime.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerListener(int i, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        synchronized (LISTENERS) {
            List<TransferListener> list = LISTENERS.get(Integer.valueOf(i));
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(transferListener);
                LISTENERS.put(Integer.valueOf(i), copyOnWriteArrayList);
            } else if (!list.contains(transferListener)) {
                list.add(transferListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unregisterListener(int i, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        List<TransferListener> list = LISTENERS.get(Integer.valueOf(i));
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(transferListener);
    }

    /* loaded from: classes.dex */
    private class TransferProgressListener implements ProgressListener {
        private long bytesCurrent;
        private final TransferRecord transfer;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.transfer = transferRecord;
        }

        @Override // com.amazonaws.event.ProgressListener
        public synchronized void progressChanged(ProgressEvent progressEvent) {
            if (progressEvent.getEventCode() == 32) {
                this.transfer.bytesCurrent -= this.bytesCurrent;
                this.bytesCurrent = 0L;
            } else {
                this.bytesCurrent += progressEvent.getBytesTransferred();
                this.transfer.bytesCurrent += progressEvent.getBytesTransferred();
            }
            TransferStatusUpdater.this.updateProgress(this.transfer.id, this.transfer.bytesCurrent, this.transfer.bytesTotal);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgressListener newProgressListener(int i) {
        TransferRecord transfer = getTransfer(i);
        if (transfer == null) {
            throw new IllegalArgumentException("transfer " + i + " doesn't exist");
        }
        return new TransferProgressListener(transfer);
    }
}
