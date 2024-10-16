package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcmf implements zzdti<zzcme> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3318a;
    private final zzdtu<zzbxo> b;

    public zzcmf(zzdtu<Context> zzdtuVar, zzdtu<zzbxo> zzdtuVar2) {
        this.f3318a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcme(this.f3318a.get(), this.b.get());
    }
}
