package com.shieldtunnel.svpn.common.f;

/* loaded from: classes2.dex */
public enum d {
    UNKNOWN(0),
    ANDROID_APP(1),
    ANDROID_SDK_EMBED(2),
    ANDROID_SDK(3),
    IOS_APP(4),
    IOS_SDK_EMBED(5),
    IOS_SDK(6),
    WIN_APP(7),
    WIN_SDK_EMBED(8),
    WIN_SDK(9),
    WEB_SDK(10);


    /* renamed from: a, reason: collision with root package name */
    private final int f5809a;

    d(int i) {
        this.f5809a = i;
    }

    public int a() {
        return this.f5809a;
    }
}
