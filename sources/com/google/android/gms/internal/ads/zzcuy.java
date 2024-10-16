package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcuy implements zzdti<zzcuw> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3453a;
    private final zzdtu<Context> b;
    private final zzdtu<zzbai> c;

    private zzcuy(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzbai> zzdtuVar3) {
        this.f3453a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzcuy zzp(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzbai> zzdtuVar3) {
        return new zzcuy(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcuw(this.f3453a.get(), this.b.get(), this.c.get());
    }
}
