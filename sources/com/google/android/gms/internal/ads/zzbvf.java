package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbvf implements zzdti<zzbvd> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzbvg>>> f3069a;

    private zzbvf(zzdtu<Set<zzbuz<zzbvg>>> zzdtuVar) {
        this.f3069a = zzdtuVar;
    }

    public static zzbvf zzx(zzdtu<Set<zzbuz<zzbvg>>> zzdtuVar) {
        return new zzbvf(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbvd(this.f3069a.get());
    }
}
