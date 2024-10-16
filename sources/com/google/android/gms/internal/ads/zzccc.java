package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzccc implements zzdti<zzccb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<String> f3175a;
    private final zzdtu<zzbyn> b;
    private final zzdtu<zzbyt> c;

    private zzccc(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        this.f3175a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzccc zzj(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        return new zzccc(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccb(this.f3175a.get(), this.b.get(), this.c.get());
    }
}
