package com.subao.common.e;

/* loaded from: classes2.dex */
public enum g implements com.subao.common.i.c {
    UNKNOWN_APPTYPE(0),
    ANDROID_APP(1),
    ANDROID_SDK_EMBEDED(2),
    ANDROID_SDK(3),
    IOS_APP(4),
    IOS_SDK_EMBEDED(5),
    IOS_SDK(6),
    WIN_APP(7),
    WIN_SDK_EMBEDED(8),
    WIN_SDK(9),
    WEB_SDK(10);

    private final int l;

    g(int i) {
        this.l = i;
    }

    @Override // com.subao.common.i.c
    public int a() {
        return this.l;
    }
}
