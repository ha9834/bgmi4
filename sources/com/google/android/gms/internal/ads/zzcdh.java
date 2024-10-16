package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcdh implements zzdti<zzcjv<zzcdb>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcoe<zzcdb, zzams, zzclb>> f3190a;
    private final zzdtu<zzcoe<zzcdb, zzams, zzcla>> b;
    private final zzdtu<zzcxv> c;

    public zzcdh(zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtuVar, zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        this.f3190a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzcoe<zzcdb, zzams, zzclb> zzcoeVar;
        zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtuVar = this.f3190a;
        zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtuVar2 = this.b;
        if (this.c.get().zzglj.contains("new_rewarded")) {
            zzcoeVar = zzdtuVar2.get();
        } else {
            zzcoeVar = zzdtuVar.get();
        }
        return (zzcjv) zzdto.zza(zzcoeVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
