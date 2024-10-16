package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbwy implements zzdti<zzcjv<zzbvx>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3094a;
    private final zzdtu<zzbbl> b;
    private final zzdtu<zzclq> c;
    private final zzdtu<zzcoc> d;

    public zzbwy(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzclq> zzdtuVar3, zzdtu<zzcoc> zzdtuVar4) {
        this.f3094a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjv) zzdto.zza(new zzcoe(this.f3094a.get(), this.b.get(), this.d.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
