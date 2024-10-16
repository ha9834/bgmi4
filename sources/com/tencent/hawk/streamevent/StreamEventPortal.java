package com.tencent.hawk.streamevent;

import android.content.Context;
import com.tencent.hawk.bridge.Constant;
import com.tencent.hawk.bridge.HawkLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class StreamEventPortal {
    private Semaphore mComittingSemaphore;
    private Context mContext;
    private Semaphore mProcessSemaphore;
    private Ticker mTicker;
    private StepInfoQueue mBufferedEventQueue = new StepInfoQueue();
    private Random mRandomGen = new Random();
    private StreamEventProcessor mStreamEventProcessor = null;
    private Map<String, Long> mStepSpanTimeMap = new HashMap();

    public StreamEventPortal(Context context, Semaphore semaphore, Ticker ticker) {
        this.mProcessSemaphore = null;
        this.mComittingSemaphore = null;
        this.mContext = context;
        this.mProcessSemaphore = new Semaphore(0);
        this.mComittingSemaphore = semaphore;
        this.mTicker = ticker;
    }

    public void postStepEvent(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mStreamEventProcessor == null) {
            this.mStreamEventProcessor = new StreamEventProcessor(this.mBufferedEventQueue, this.mProcessSemaphore, this.mComittingSemaphore, this.mContext, this.mTicker);
            this.mStreamEventProcessor.startProcess();
        }
        if (str == null) {
            HawkLogger.e("EventCategory is NULL");
            return;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = Constant.APM_CFG_GPU_NA;
        }
        if (str3 == null || str3.length() == 0) {
            str3 = Constant.APM_CFG_GPU_NA;
        }
        StepInfo stepInfo = new StepInfo();
        stepInfo.eventCategory = str;
        stepInfo.stepId = i;
        stepInfo.stepStatus = i2;
        stepInfo.stepCode = i3;
        stepInfo.stepMsg = str2;
        stepInfo.extDefinedKey = str3;
        stepInfo.stepTime = System.currentTimeMillis();
        Long l = this.mStepSpanTimeMap.get(str);
        if (l != null) {
            stepInfo.stepSpanTime = stepInfo.stepTime - l.longValue();
        } else {
            stepInfo.stepSpanTime = 0L;
        }
        this.mStepSpanTimeMap.put(str, Long.valueOf(stepInfo.stepTime));
        stepInfo.stepRandom = this.mRandomGen.nextInt();
        this.mBufferedEventQueue.pushStepInfo(stepInfo);
        this.mProcessSemaphore.release();
    }

    public void linkSession(String str) {
        StepInfo stepInfo = new StepInfo();
        stepInfo.isLinked = true;
        stepInfo.eventCategory = str;
        this.mBufferedEventQueue.pushStepInfo(stepInfo);
        this.mProcessSemaphore.release();
    }

    public void releaseStepEventContext() {
        StepInfo stepInfo = new StepInfo();
        stepInfo.isFinishedEvent = true;
        this.mBufferedEventQueue.pushStepInfo(stepInfo);
        this.mProcessSemaphore.release();
    }
}
