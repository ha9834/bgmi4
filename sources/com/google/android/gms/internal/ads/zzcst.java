package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcst implements zzdti<zzcsp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3416a;
    private final zzdtu<zzbbl> b;

    private zzcst(zzdtu<Context> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        this.f3416a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcst zzal(zzdtu<Context> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        return new zzcst(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsp(this.f3416a.get(), this.b.get());
    }
}
