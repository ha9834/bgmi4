package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbxd implements zzdti<zzbxc> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbrt> f3098a;
    private final zzdtu<zzcxm> b;

    private zzbxd(zzdtu<zzbrt> zzdtuVar, zzdtu<zzcxm> zzdtuVar2) {
        this.f3098a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbxd zzj(zzdtu<zzbrt> zzdtuVar, zzdtu<zzcxm> zzdtuVar2) {
        return new zzbxd(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxc(this.f3098a.get(), this.b.get());
    }
}
