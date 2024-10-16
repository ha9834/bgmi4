package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcfc implements zzdti<zzcfb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcfi> f3223a;
    private final zzdtu<zzdae> b;

    private zzcfc(zzdtu<zzcfi> zzdtuVar, zzdtu<zzdae> zzdtuVar2) {
        this.f3223a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcfc zzs(zzdtu<zzcfi> zzdtuVar, zzdtu<zzdae> zzdtuVar2) {
        return new zzcfc(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcfb(this.f3223a.get(), this.b.get());
    }
}
