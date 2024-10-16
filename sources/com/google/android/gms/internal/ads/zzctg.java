package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzctg implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f3426a;

    public zzctg(Bundle bundle) {
        this.f3426a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzcxz.zza(bundle2, "device");
        zza.putBundle("android_mem_info", this.f3426a);
        bundle2.putBundle("device", zza);
    }
}
