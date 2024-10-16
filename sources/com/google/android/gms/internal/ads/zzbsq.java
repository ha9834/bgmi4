package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbsq implements zzdti<zzbso> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzbsr>>> f3035a;

    private zzbsq(zzdtu<Set<zzbuz<zzbsr>>> zzdtuVar) {
        this.f3035a = zzdtuVar;
    }

    public static zzbsq zzq(zzdtu<Set<zzbuz<zzbsr>>> zzdtuVar) {
        return new zzbsq(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbso(this.f3035a.get());
    }
}
