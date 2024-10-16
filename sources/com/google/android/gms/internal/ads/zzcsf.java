package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcsf implements zzdti<zzcsd> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3407a;
    private final zzdtu<Context> b;

    private zzcsf(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        this.f3407a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcsf zzak(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        return new zzcsf(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsd(this.f3407a.get(), this.b.get());
    }
}
