package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcsx implements zzdti<zzcsv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3419a;
    private final zzdtu<zzbbl> b;

    private zzcsx(zzdtu<Context> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        this.f3419a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcsx zzam(zzdtu<Context> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        return new zzcsx(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsv(this.f3419a.get(), this.b.get());
    }
}
