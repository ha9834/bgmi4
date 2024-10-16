package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcek implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcep> f3207a;
    private final zzdtu<Executor> b;

    private zzcek(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3207a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcek zzp(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcek(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3207a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
