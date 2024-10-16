package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcca implements zzdti<zzcbz> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<String> f3173a;
    private final zzdtu<zzbyn> b;
    private final zzdtu<zzbyt> c;

    private zzcca(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        this.f3173a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzcca zzi(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        return new zzcca(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbz(this.f3173a.get(), this.b.get(), this.c.get());
    }
}
