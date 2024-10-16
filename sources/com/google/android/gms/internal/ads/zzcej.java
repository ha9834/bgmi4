package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcej implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcep> f3206a;
    private final zzdtu<Executor> b;

    private zzcej(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3206a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcej zzo(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcej(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3206a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
