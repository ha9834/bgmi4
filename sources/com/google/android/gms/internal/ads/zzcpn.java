package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcpn implements zzdti<zzcpm> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3364a;
    private final zzdtu<zzyz> b;
    private final zzdtu<zzcxv> c;
    private final zzdtu<zzbnf> d;

    public zzcpn(zzdtu<Context> zzdtuVar, zzdtu<zzyz> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzbnf> zzdtuVar4) {
        this.f3364a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcpm(this.f3364a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
