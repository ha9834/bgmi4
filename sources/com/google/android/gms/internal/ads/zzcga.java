package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcga implements zzdti<zzcfz> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcfn> f3245a;
    private final zzdtu<zzbjm> b;

    private zzcga(zzdtu<zzcfn> zzdtuVar, zzdtu<zzbjm> zzdtuVar2) {
        this.f3245a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcga zzy(zzdtu<zzcfn> zzdtuVar, zzdtu<zzbjm> zzdtuVar2) {
        return new zzcga(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcfz(this.f3245a.get(), this.b.get());
    }
}
