package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcfx implements zzdti<Set<zzbuz<zzbrw>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcfp f3242a;
    private final zzdtu<zzcfz> b;
    private final zzdtu<Executor> c;

    private zzcfx(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3242a = zzcfpVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzcfx zzh(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfx(zzcfpVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(zzcfp.zzf(this.b.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
