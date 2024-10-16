package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbqs implements zzdti<zzbqr> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3016a;
    private final zzdtu<zzcxv> b;
    private final zzdtu<zzbai> c;
    private final zzdtu<zzaxb> d;
    private final zzdtu<zzcgb> e;

    private zzbqs(zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<zzaxb> zzdtuVar4, zzdtu<zzcgb> zzdtuVar5) {
        this.f3016a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    public static zzbqs zzb(zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<zzaxb> zzdtuVar4, zzdtu<zzcgb> zzdtuVar5) {
        return new zzbqs(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbqr(this.f3016a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
