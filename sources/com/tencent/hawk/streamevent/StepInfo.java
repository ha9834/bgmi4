package com.tencent.hawk.streamevent;

/* loaded from: classes2.dex */
public class StepInfo {
    public long autoId;
    public String eventCategory;
    public String extDefinedKey;
    public boolean isCommitted;
    public boolean isFinishedEvent;
    public boolean isLinked;
    public boolean isStaged;
    public String linkedSessionId;
    public int networkType;
    public String sessionId;
    public int stepCode;
    public int stepId;
    public String stepMsg;
    public int stepRandom;
    public long stepSpanTime;
    public int stepStatus;
    public long stepTime;
    public String uniqueSessionId;

    public StepInfo() {
        reset();
    }

    public void reset() {
        this.isStaged = false;
        this.isCommitted = false;
        this.isFinishedEvent = false;
        this.isLinked = false;
        this.eventCategory = "_DEFAULT_";
        this.stepId = 0;
        this.stepStatus = 0;
        this.stepCode = 0;
        this.stepMsg = "";
        this.networkType = 0;
        this.stepTime = 0L;
        this.stepSpanTime = 0L;
        this.stepRandom = 0;
        this.sessionId = "";
        this.uniqueSessionId = "";
        this.extDefinedKey = "";
        this.linkedSessionId = "";
    }
}
