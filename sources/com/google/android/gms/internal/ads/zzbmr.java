package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbmr implements zzdti<zzbmg> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzty> f2938a;
    private final zzdtu<zzaly> b;
    private final zzdtu<Executor> c;

    private zzbmr(zzdtu<zzty> zzdtuVar, zzdtu<zzaly> zzdtuVar2, zzdtu<Executor> zzdtuVar3) {
        this.f2938a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzbmr zzb(zzdtu<zzty> zzdtuVar, zzdtu<zzaly> zzdtuVar2, zzdtu<Executor> zzdtuVar3) {
        return new zzbmr(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzty zztyVar = this.f2938a.get();
        return (zzbmg) zzdto.zza(new zzbmg(zztyVar.zzmi(), this.b.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
