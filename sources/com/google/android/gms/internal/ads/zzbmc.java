package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbmc implements zzdti<zzbmb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzaxb> f2928a;

    private zzbmc(zzdtu<zzaxb> zzdtuVar) {
        this.f2928a = zzdtuVar;
    }

    public static zzbmc zzg(zzdtu<zzaxb> zzdtuVar) {
        return new zzbmc(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbmb(this.f2928a.get());
    }
}
