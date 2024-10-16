package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbxf implements zzdti<zzbxe> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbry> f3100a;

    private zzbxf(zzdtu<zzbry> zzdtuVar) {
        this.f3100a = zzdtuVar;
    }

    public static zzbxf zzaa(zzdtu<zzbry> zzdtuVar) {
        return new zzbxf(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxe(this.f3100a.get());
    }
}
