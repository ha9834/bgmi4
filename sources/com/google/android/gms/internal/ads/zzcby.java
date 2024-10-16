package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcby implements zzdti<zzcbw> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbyn> f3170a;
    private final zzdtu<zzbyt> b;

    private zzcby(zzdtu<zzbyn> zzdtuVar, zzdtu<zzbyt> zzdtuVar2) {
        this.f3170a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcby zzk(zzdtu<zzbyn> zzdtuVar, zzdtu<zzbyt> zzdtuVar2) {
        return new zzcby(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbw(this.f3170a.get(), this.b.get());
    }
}
