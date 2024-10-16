package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcft implements zzdti<Set<zzbuz<zzbsr>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcfp f3238a;
    private final zzdtu<zzcfz> b;
    private final zzdtu<Executor> c;

    private zzcft(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3238a = zzcfpVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzcft zzd(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcft(zzcfpVar, zzdtuVar, zzdtuVar2);
    }

    public static Set<zzbuz<zzbsr>> zza(zzcfp zzcfpVar, zzcfz zzcfzVar, Executor executor) {
        return (Set) zzdto.zza(zzcfp.zzc(zzcfzVar, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f3238a, this.b.get(), this.c.get());
    }
}
