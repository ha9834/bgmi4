package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzcgz implements zzdti<zzbbh<zzcxu>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3251a;
    private final zzdtu<zzchl> b;
    private final zzdtu<zzchq> c;
    private final zzdtu<zzbbh<zzarx>> d;
    private final zzdtu<zzcxv> e;

    private zzcgz(zzdtu<zzczt> zzdtuVar, zzdtu<zzchl> zzdtuVar2, zzdtu<zzchq> zzdtuVar3, zzdtu<zzbbh<zzarx>> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5) {
        this.f3251a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    public static zzcgz zzf(zzdtu<zzczt> zzdtuVar, zzdtu<zzchl> zzdtuVar2, zzdtu<zzchq> zzdtuVar3, zzdtu<zzbbh<zzarx>> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5) {
        return new zzcgz(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzcze zzane;
        zzczt zzcztVar = this.f3251a.get();
        zzchl zzchlVar = this.b.get();
        zzchq zzchqVar = this.c.get();
        zzbbh<zzarx> zzbbhVar = this.d.get();
        zzcxv zzcxvVar = this.e.get();
        zzk.zzlm().zzng();
        if (zzcxvVar.zzghg.zzchb != null) {
            zzane = zzcztVar.zza((zzczt) zzczs.SERVER_TRANSACTION, (zzbbh) zzbbhVar).zzb(zzchqVar.a()).zzane();
        } else {
            zzane = zzcztVar.zza((zzczt) zzczs.SERVER_TRANSACTION, (zzbbh) zzbbhVar).zza(zzchlVar).zzane();
        }
        return (zzbbh) zzdto.zza(zzane, "Cannot return null from a non-@Nullable @Provides method");
    }
}
