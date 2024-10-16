package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbqj implements zzdti<zzbuz<zzbrw>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbme> f3011a;
    private final zzdtu<Executor> b;

    private zzbqj(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3011a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbqj zzf(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbqj(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3011a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
