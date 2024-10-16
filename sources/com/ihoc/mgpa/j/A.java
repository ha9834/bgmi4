package com.ihoc.mgpa.j;

import com.adjust.sdk.Constants;

/* loaded from: classes2.dex */
public enum A {
    UNKOWN("unknown"),
    SOCKET("socket"),
    KOGSOCKET("kogsocket"),
    TGPABINDER("tgpabinder"),
    TGPABINDER2("tgpabinder2"),
    KOGHUAWEI("koghuawei"),
    HUAWEI(Constants.REFERRER_API_HUAWEI),
    SAMSUNG2("samsung2"),
    SAMSUNG("samsung"),
    VIVO("vivo"),
    VIVO2("vivo2"),
    XIAOMI("xiaomi"),
    OPPO("oppo");

    private String o;

    A(String str) {
        this.o = str;
    }

    public String a() {
        return this.o;
    }
}
