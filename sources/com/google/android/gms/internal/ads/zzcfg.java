package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcfg implements zzdti<zzbuz<zzczz>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcfk> f3227a;
    private final zzdtu<Executor> b;

    private zzcfg(zzdtu<zzcfk> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3227a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcfg zzw(zzdtu<zzcfk> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfg(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3227a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
