package com.tencent.grobot.lite.model.req;

/* loaded from: classes2.dex */
public class TicketReqInfo extends ReqInfo {
    public String ticketInfo = "";
    public String tagId = "";
    public String formId = "";
    public int type = 1;

    /* loaded from: classes2.dex */
    public static final class TICKETTYPE {
        public static final int NEW = 1;
        public static final int QUERYDETAIL = 3;
        public static final int QUERYFORM = 0;
        public static final int QUERYLIST = 2;
    }
}
