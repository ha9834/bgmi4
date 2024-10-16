package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcsg implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final double f3408a;
    private final boolean b;

    public zzcsg(double d, boolean z) {
        this.f3408a = d;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzcxz.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzcxz.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.b);
        zza2.putDouble("battery_level", this.f3408a);
    }
}
