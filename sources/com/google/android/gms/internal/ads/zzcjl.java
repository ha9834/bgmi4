package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcjl implements zzdti<zzcjk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcji> f3286a;

    private zzcjl(zzdtu<zzcji> zzdtuVar) {
        this.f3286a = zzdtuVar;
    }

    public static zzcjl zzah(zzdtu<zzcji> zzdtuVar) {
        return new zzcjl(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcjk(this.f3286a.get());
    }
}
