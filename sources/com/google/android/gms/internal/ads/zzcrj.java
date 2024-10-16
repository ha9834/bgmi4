package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcrj implements zzdti<zzcri> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcxv> f3394a;

    private zzcrj(zzdtu<zzcxv> zzdtuVar) {
        this.f3394a = zzdtuVar;
    }

    public static zzcrj zzaj(zzdtu<zzcxv> zzdtuVar) {
        return new zzcrj(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcri(this.f3394a.get());
    }
}
