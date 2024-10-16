package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcjf implements zzdti<zzcjc> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcja> f3280a;
    private final zzdtu<zzbbl> b;

    private zzcjf(zzdtu<zzcja> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        this.f3280a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcjf zzah(zzdtu<zzcja> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        return new zzcjf(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcjc(this.f3280a.get(), this.b.get());
    }
}
