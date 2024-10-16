package com.tencent.hawk.streamevent;

import com.tencent.hawk.bridge.HawkLogger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class StepInfoQueue {
    private List<StepInfo> mStepInfoList = new ArrayList();
    private volatile int mHeadIdx = 0;
    private volatile int mTailIdx = 0;

    public int getHeadIdx() {
        return this.mHeadIdx;
    }

    public int getTailIdx() {
        return this.mTailIdx;
    }

    public StepInfo getStepInfo(int i) {
        if (i >= this.mHeadIdx) {
            HawkLogger.w("Read StepInfo error");
            return null;
        }
        return this.mStepInfoList.get(i);
    }

    public boolean pushStepInfo(StepInfo stepInfo) {
        this.mStepInfoList.add(stepInfo);
        this.mHeadIdx++;
        return true;
    }

    public StepInfo consumeStepEvent() {
        if (this.mTailIdx >= this.mHeadIdx) {
            HawkLogger.w("Consume StepEvent, null");
            return null;
        }
        List<StepInfo> list = this.mStepInfoList;
        int i = this.mTailIdx;
        this.mTailIdx = i + 1;
        return list.get(i);
    }

    public boolean isQueueEmpty() {
        return this.mHeadIdx == this.mTailIdx;
    }
}
