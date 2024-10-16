package com.tencent.hawk.streamevent;

import android.content.Context;
import com.tencent.hawk.bridge.Constant;
import com.tencent.hawk.bridge.HawkLogger;
import com.tencent.hawk.bridge.HawkNative;
import com.tencent.hawk.db.DMLProcessor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class StreamEventCommitter implements Runnable {
    private Semaphore mCommittingSemaphore;
    private Context mContext;
    private DMLProcessor mDMLProcessor;
    private StepInfoQueue mStepEventQueue;
    private Ticker mTickThread;
    private Thread mCommittingThread = null;
    private String mServerIp = null;
    private boolean isSendSuccessed = true;
    private int failedTime = 0;
    private List<ByteWrapper> pendingByteList = new ArrayList();
    private volatile boolean isCommitterThreadFinished = false;

    public StreamEventCommitter(StepInfoQueue stepInfoQueue, Semaphore semaphore, Context context, DMLProcessor dMLProcessor, Ticker ticker) {
        this.mContext = null;
        this.mTickThread = null;
        this.mCommittingSemaphore = semaphore;
        this.mStepEventQueue = stepInfoQueue;
        this.mContext = context;
        this.mDMLProcessor = dMLProcessor;
        loadLocalStepEvent();
        this.mTickThread = ticker;
    }

    public void startCommitting() {
        Ticker ticker = this.mTickThread;
        if (ticker != null) {
            ticker.startTick();
        }
        if (this.mCommittingThread == null) {
            this.mCommittingThread = new Thread(this);
            this.mCommittingThread.setName("StreamEvent Committing thread");
            this.mCommittingThread.start();
        }
    }

    public void loadLocalStepEvent() {
        List<StepInfo> localPendingEvents = this.mDMLProcessor.getLocalPendingEvents();
        HawkLogger.i("Get Pending stepInfo: " + localPendingEvents.size());
        if (localPendingEvents.size() != 0) {
            Iterator<StepInfo> it = localPendingEvents.iterator();
            while (it.hasNext()) {
                this.mStepEventQueue.pushStepInfo(it.next());
            }
        }
    }

    private void finishCommittingThread() {
        this.isCommitterThreadFinished = true;
    }

    private byte[] packStepEvent(StepInfo stepInfo) {
        return HawkNative.nativePackStepEventInfo(stepInfo.eventCategory, stepInfo.stepId, stepInfo.stepStatus, stepInfo.stepCode, stepInfo.stepMsg, stepInfo.networkType, stepInfo.stepTime, (int) stepInfo.stepSpanTime, stepInfo.stepRandom, stepInfo.sessionId, stepInfo.uniqueSessionId, stepInfo.linkedSessionId, stepInfo.extDefinedKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ByteWrapper {
        public byte[] buffer;
        public StepInfo matchedEvent;

        public ByteWrapper(byte[] bArr, StepInfo stepInfo) {
            this.buffer = bArr;
            this.matchedEvent = stepInfo;
        }
    }

    private synchronized String getServerIp() {
        if (this.mServerIp == null) {
            try {
                this.mServerIp = InetAddress.getByName(Constant.STEPEVENT_DOMAIN).getHostAddress();
            } catch (UnknownHostException e) {
                HawkLogger.e("DNS parse error: " + e.getMessage());
            }
        }
        return this.mServerIp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c1, code lost:
    
        r6.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[Catch: Exception -> 0x0174, SYNTHETIC, TRY_LEAVE, TryCatch #6 {Exception -> 0x0174, blocks: (B:5:0x0008, B:7:0x000e, B:10:0x0015, B:15:0x001b, B:17:0x0020, B:38:0x00c1, B:40:0x00c9, B:45:0x00ce, B:48:0x00c6, B:97:0x0108, B:93:0x0112, B:76:0x014c, B:80:0x0158, B:74:0x0117, B:100:0x010d, B:83:0x013c, B:71:0x0146, B:86:0x0141, B:62:0x0161, B:54:0x016b, B:59:0x0173, B:58:0x0170, B:65:0x0166), top: B:4:0x0008, inners: #4, #5, #7, #12, #13, #16, #17, #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean sendMsg(java.util.List<com.tencent.hawk.streamevent.StreamEventCommitter.ByteWrapper> r11) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.streamevent.StreamEventCommitter.sendMsg(java.util.List):boolean");
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            if (this.mStepEventQueue.isQueueEmpty() && this.isCommitterThreadFinished && this.isSendSuccessed) {
                DMLProcessor dMLProcessor = this.mDMLProcessor;
                if (dMLProcessor != null) {
                    dMLProcessor.closeDB();
                }
                Ticker ticker = this.mTickThread;
                if (ticker != null) {
                    ticker.finish();
                }
                HawkLogger.w("completed all committing events, committing thread demise");
                return;
            }
            try {
                this.mCommittingSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.mStepEventQueue.isQueueEmpty() && this.pendingByteList.size() == 0) {
                HawkLogger.d("Current Pending queue is empty");
            } else {
                int headIdx = this.mStepEventQueue.getHeadIdx();
                int tailIdx = this.mStepEventQueue.getTailIdx();
                HawkLogger.i(String.format(Locale.ENGLISH, "Committing idx : %d %d, size: %d", Integer.valueOf(headIdx), Integer.valueOf(tailIdx), Integer.valueOf(headIdx - tailIdx)));
                while (tailIdx < headIdx) {
                    StepInfo consumeStepEvent = this.mStepEventQueue.consumeStepEvent();
                    if (consumeStepEvent == null) {
                        HawkLogger.e("StepEvent queue, read null objects");
                    } else if (consumeStepEvent.isFinishedEvent) {
                        HawkLogger.i("receive completed event: " + tailIdx + " " + headIdx);
                        finishCommittingThread();
                    } else {
                        byte[] packStepEvent = packStepEvent(consumeStepEvent);
                        if (packStepEvent == null) {
                            HawkLogger.e("packed error, delete event : " + consumeStepEvent.autoId);
                            this.mDMLProcessor.deleteStepInfo(consumeStepEvent.autoId);
                        } else {
                            this.pendingByteList.add(new ByteWrapper(packStepEvent, consumeStepEvent));
                        }
                    }
                    tailIdx++;
                }
                this.isSendSuccessed = true;
                if (this.pendingByteList.size() != 0) {
                    sendMsg(this.pendingByteList);
                    for (ByteWrapper byteWrapper : this.pendingByteList) {
                        if (byteWrapper.matchedEvent.isCommitted) {
                            HawkLogger.d("send successed, delete local status: " + byteWrapper.matchedEvent.eventCategory + " " + byteWrapper.matchedEvent.stepId + "  " + byteWrapper.matchedEvent.autoId);
                            this.mDMLProcessor.deleteStepInfo(byteWrapper.matchedEvent.autoId);
                        } else {
                            HawkLogger.e(String.format(Locale.getDefault(), "send failed: %s %d", byteWrapper.matchedEvent.eventCategory, Integer.valueOf(byteWrapper.matchedEvent.stepId)));
                            this.isSendSuccessed = false;
                        }
                    }
                }
                Iterator<ByteWrapper> it = this.pendingByteList.iterator();
                while (it.hasNext()) {
                    ByteWrapper next = it.next();
                    if (next != null && next.matchedEvent != null && next.matchedEvent.isCommitted) {
                        it.remove();
                    }
                }
                if (this.isSendSuccessed) {
                    continue;
                } else {
                    int i = this.failedTime;
                    this.failedTime = i + 1;
                    if (i > 20) {
                        HawkLogger.e("send failed too many times, exit");
                        return;
                    }
                    int i2 = this.failedTime;
                    int i3 = 1000;
                    if (i2 < 0 || i2 >= 5) {
                        int i4 = this.failedTime;
                        if (i4 >= 5 && i4 < 10) {
                            i3 = 5000;
                        } else if (this.failedTime > 10) {
                            i3 = 10000;
                        }
                    }
                    HawkLogger.d("send failed, try to sleep : " + i3 + " , times: " + this.failedTime);
                    try {
                        Thread.sleep(i3);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
