package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzceh implements zzdti<zzbuz<zzbro>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcep> f3204a;
    private final zzdtu<Executor> b;

    private zzceh(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3204a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzceh zzm(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzceh(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3204a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
