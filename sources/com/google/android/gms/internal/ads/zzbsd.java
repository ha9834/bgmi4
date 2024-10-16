package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbsd implements zzdti<zzbry> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzbrx>>> f3033a;

    private zzbsd(zzdtu<Set<zzbuz<zzbrx>>> zzdtuVar) {
        this.f3033a = zzdtuVar;
    }

    public static zzbsd zzo(zzdtu<Set<zzbuz<zzbrx>>> zzdtuVar) {
        return new zzbsd(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbry(this.f3033a.get());
    }
}
