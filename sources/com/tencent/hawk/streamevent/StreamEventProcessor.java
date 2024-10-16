package com.tencent.hawk.streamevent;

import android.content.Context;
import com.tencent.hawk.bridge.HawkLogger;
import com.tencent.hawk.bridge.HawkNative;
import com.tencent.hawk.bridge.NetworkUtil;
import com.tencent.hawk.bridge.RTState;
import com.tencent.hawk.db.DMLProcessor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class StreamEventProcessor implements Runnable {
    private boolean isInitSuccessed;
    private Semaphore mCommittingSemaphore;
    private Context mContext;
    private DMLProcessor mDMLProcessor = DMLProcessor.getInstance();
    private StepInfoQueue mPendingCommitingStepInfoQueue;
    private Semaphore mProcessSemaphore;
    private StepInfoQueue mStepEventQueue;
    private StreamEventCommitter mStreamEventCommitter;
    private Map<String, StreamEvent> mStreamEventMap;

    public StreamEventProcessor(StepInfoQueue stepInfoQueue, Semaphore semaphore, Semaphore semaphore2, Context context, Ticker ticker) {
        this.mStreamEventMap = null;
        this.mContext = null;
        this.mStreamEventMap = new HashMap();
        this.mContext = context;
        this.mProcessSemaphore = semaphore;
        this.mCommittingSemaphore = semaphore2;
        this.mStepEventQueue = stepInfoQueue;
        this.mDMLProcessor.initialize(context);
        if (!this.mDMLProcessor.createDB()) {
            HawkLogger.e("init DB failed");
            this.isInitSuccessed = false;
        }
        this.mPendingCommitingStepInfoQueue = new StepInfoQueue();
        this.mStreamEventCommitter = new StreamEventCommitter(this.mPendingCommitingStepInfoQueue, this.mCommittingSemaphore, context, this.mDMLProcessor, ticker);
        this.isInitSuccessed = true;
    }

    public void startProcess() {
        if (!this.isInitSuccessed) {
            HawkLogger.e("Created DB failed");
            return;
        }
        this.mStreamEventCommitter.startCommitting();
        Thread thread = new Thread(this);
        thread.setName("StreamEvent Processing Thread");
        thread.start();
    }

    private void fillStreamEvent(StepInfo stepInfo, boolean z) {
        Context context = this.mContext;
        if (context != null) {
            stepInfo.networkType = NetworkUtil.getNetworkState(context);
        } else {
            stepInfo.networkType = 0;
        }
        stepInfo.sessionId = RTState.getSessionId();
        stepInfo.uniqueSessionId = RTState.getUniversalSessionId();
        if (z) {
            HawkLogger.i("Linked Session");
            stepInfo.linkedSessionId = RTState.getLinkedSessionId();
        }
    }

    private boolean saveStepEvent(StepInfo stepInfo, boolean z) {
        fillStreamEvent(stepInfo, z);
        if (this.mDMLProcessor.saveStepInfo(stepInfo)) {
            return true;
        }
        HawkLogger.e("save stepEvent failed");
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                this.mProcessSemaphore.acquire();
                StepInfo consumeStepEvent = this.mStepEventQueue.consumeStepEvent();
                if (consumeStepEvent != null) {
                    HawkNative.packetAndSendByTDM(consumeStepEvent.eventCategory, consumeStepEvent.stepId, consumeStepEvent.stepStatus, consumeStepEvent.stepCode, consumeStepEvent.stepMsg, consumeStepEvent.networkType, consumeStepEvent.stepTime, (int) consumeStepEvent.stepSpanTime, consumeStepEvent.stepRandom, consumeStepEvent.sessionId, consumeStepEvent.uniqueSessionId, consumeStepEvent.linkedSessionId, consumeStepEvent.extDefinedKey);
                }
            } catch (InterruptedException unused) {
                HawkLogger.e("Semaphone acquire failed");
                return;
            }
        }
    }
}
