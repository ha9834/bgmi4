package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcjh implements zzdti<zzcjg> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcjm> f3282a;

    private zzcjh(zzdtu<zzcjm> zzdtuVar) {
        this.f3282a = zzdtuVar;
    }

    public static zzcjh zzag(zzdtu<zzcjm> zzdtuVar) {
        return new zzcjh(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcjg(this.f3282a.get());
    }
}
