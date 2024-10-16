package com.google.android.gms.ads.mediation;

/* loaded from: classes.dex */
public final class VersionInfo {

    /* renamed from: a, reason: collision with root package name */
    private final int f1171a;
    private final int b;
    private final int c;

    public VersionInfo(int i, int i2, int i3) {
        this.f1171a = i;
        this.b = i2;
        this.c = i3;
    }

    public final int getMajorVersion() {
        return this.f1171a;
    }

    public final int getMinorVersion() {
        return this.b;
    }

    public final int getMicroVersion() {
        return this.c;
    }
}
