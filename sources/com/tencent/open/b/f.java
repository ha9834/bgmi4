package com.tencent.open.b;

/* loaded from: classes.dex */
public class f {
    public static int a(String str) {
        int a2;
        if (com.tencent.open.utils.g.a() == null || (a2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a2;
    }

    public static int a() {
        int a2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_HttpRetryCount");
        if (a2 == 0) {
            return 2;
        }
        return a2;
    }
}
