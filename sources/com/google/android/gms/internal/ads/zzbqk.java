package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbqk implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbme> f3012a;
    private final zzdtu<Executor> b;

    private zzbqk(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3012a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbqk zzg(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbqk(zzdtuVar, zzdtuVar2);
    }

    public static zzbuz<zzbsr> zza(zzbme zzbmeVar, Executor executor) {
        return (zzbuz) zzdto.zza(new zzbuz(zzbmeVar, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f3012a.get(), this.b.get());
    }
}
