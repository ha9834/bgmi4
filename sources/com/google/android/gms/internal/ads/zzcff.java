package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcff implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcfb> f3226a;
    private final zzdtu<Executor> b;

    private zzcff(zzdtu<zzcfb> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3226a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcff zzv(zzdtu<zzcfb> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcff(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3226a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
