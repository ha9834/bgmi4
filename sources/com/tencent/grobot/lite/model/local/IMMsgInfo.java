package com.tencent.grobot.lite.model.local;

/* loaded from: classes2.dex */
public class IMMsgInfo {
    public static final int AGENT_MSG = 1;
    public static final int STAR_MSG = 6;
    public static final int SYS_MSG = 0;
    public int msgType = 1;
    public String sessionId = "";
    public EvaluateInfo evaluateInfo = null;
    public String agentName = "";
    public String content = "";
    public long createTime = 0;
    public SysMsg sysMsg = new SysMsg();

    /* loaded from: classes2.dex */
    public static class SysMsg {
        public static final int BEFORE = 0;
        public static final int MANSERVEING = 2;
        public static final int OVER = 3;
        public static final int QUEUING = 1;
        public int subType = 1;
        public int sessionStatus = 1;
        public String msg = "";
    }
}
