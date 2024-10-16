package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzctb implements zzdti<zzcsz> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3422a;
    private final zzdtu<zzcxv> b;

    private zzctb(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        this.f3422a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzctb zzan(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        return new zzctb(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsz(this.f3422a.get(), this.b.get());
    }
}
