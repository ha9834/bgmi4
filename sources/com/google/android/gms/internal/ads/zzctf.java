package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzctf implements zzdti<zzctd> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3425a;

    private zzctf(zzdtu<zzbbl> zzdtuVar) {
        this.f3425a = zzdtuVar;
    }

    public static zzctf zzal(zzdtu<zzbbl> zzdtuVar) {
        return new zzctf(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzctd(this.f3425a.get());
    }
}
