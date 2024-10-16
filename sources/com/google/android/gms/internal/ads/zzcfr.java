package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcfr implements zzdti<Set<zzbuz<zzbro>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcfp f3236a;
    private final zzdtu<zzcfz> b;
    private final zzdtu<Executor> c;

    private zzcfr(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3236a = zzcfpVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzcfr zzb(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfr(zzcfpVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(zzcfp.zzd(this.b.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
