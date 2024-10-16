package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcch implements zzdti<zzccg> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<String> f3179a;
    private final zzdtu<zzbyn> b;
    private final zzdtu<zzbyt> c;

    private zzcch(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        this.f3179a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzcch zzk(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        return new zzcch(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccg(this.f3179a.get(), this.b.get(), this.c.get());
    }
}
