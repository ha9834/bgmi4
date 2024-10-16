package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbpg<AdT> implements zzdti<zzbpf<AdT>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Map<String, zzcjv<AdT>>> f2991a;

    private zzbpg(zzdtu<Map<String, zzcjv<AdT>>> zzdtuVar) {
        this.f2991a = zzdtuVar;
    }

    public static <AdT> zzbpg<AdT> zzj(zzdtu<Map<String, zzcjv<AdT>>> zzdtuVar) {
        return new zzbpg<>(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbpf(this.f2991a.get());
    }
}
