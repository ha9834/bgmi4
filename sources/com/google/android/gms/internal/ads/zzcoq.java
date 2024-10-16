package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcoq implements zzdti<zzcok> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3350a;
    private final zzdtu<zzboc> b;
    private final zzdtu<zzczt> c;
    private final zzdtu<zzbbl> d;
    private final zzdtu<zzado> e;

    public zzcoq(zzdtu<Context> zzdtuVar, zzdtu<zzboc> zzdtuVar2, zzdtu<zzczt> zzdtuVar3, zzdtu<zzbbl> zzdtuVar4, zzdtu<zzado> zzdtuVar5) {
        this.f3350a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcok(this.f3350a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
