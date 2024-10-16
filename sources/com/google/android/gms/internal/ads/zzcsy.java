package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcsy implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final int f3420a;
    private final zzxz b;

    public zzcsy(int i, zzxz zzxzVar) {
        this.f3420a = i;
        this.b = zzxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        zzcxz.zza(bundle, "correlation_id", Integer.valueOf(this.f3420a), this.b.versionCode >= 6);
    }
}
