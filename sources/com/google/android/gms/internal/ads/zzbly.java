package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbly implements zzdti<zzblx> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcxk> f2923a;

    private zzbly(zzdtu<zzcxk> zzdtuVar) {
        this.f2923a = zzdtuVar;
    }

    public static zzbly zze(zzdtu<zzcxk> zzdtuVar) {
        return new zzbly(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblx(this.f2923a.get());
    }
}
