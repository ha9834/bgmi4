package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzblu implements zzdti<zzblt> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzaxb> f2919a;

    private zzblu(zzdtu<zzaxb> zzdtuVar) {
        this.f2919a = zzdtuVar;
    }

    public static zzblu zzc(zzdtu<zzaxb> zzdtuVar) {
        return new zzblu(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblt(this.f2919a.get());
    }
}
