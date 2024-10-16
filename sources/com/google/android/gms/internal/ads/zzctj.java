package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzctj implements zzdti<zzcth> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3428a;

    private zzctj(zzdtu<zzbbl> zzdtuVar) {
        this.f3428a = zzdtuVar;
    }

    public static zzctj zzam(zzdtu<zzbbl> zzdtuVar) {
        return new zzctj(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcth(this.f3428a.get());
    }
}
