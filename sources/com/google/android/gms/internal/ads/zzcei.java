package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcei implements zzdti<zzbuz<zzbrw>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcep> f3205a;
    private final zzdtu<Executor> b;

    private zzcei(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3205a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcei zzn(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcei(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3205a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
