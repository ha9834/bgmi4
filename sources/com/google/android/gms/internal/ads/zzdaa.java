package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzdaa implements zzdti<zzczt> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3523a;
    private final zzdtu<ScheduledExecutorService> b;
    private final zzdtu<aau> c;

    private zzdaa(zzdtu<zzbbl> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<aau> zzdtuVar3) {
        this.f3523a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzdaa zzq(zzdtu<zzbbl> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<aau> zzdtuVar3) {
        return new zzdaa(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzczt(this.f3523a.get(), this.b.get(), this.c.get());
    }
}
