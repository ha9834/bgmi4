package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcsc implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final int f3405a;
    private final boolean b;
    private final boolean c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final boolean h;

    public zzcsc(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.f3405a = i;
        this.b = z;
        this.c = z2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
        this.h = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putInt("am", this.f3405a);
        bundle2.putBoolean("ma", this.b);
        bundle2.putBoolean("sp", this.c);
        bundle2.putInt("muv", this.d);
        bundle2.putInt("rm", this.e);
        bundle2.putInt("riv", this.f);
        bundle2.putFloat("android_app_volume", this.g);
        bundle2.putBoolean("android_app_muted", this.h);
    }
}
