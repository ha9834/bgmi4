package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcwe implements zzdti<zzcwc> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzvx> f3471a;
    private final zzdtu<zzbbl> b;
    private final zzdtu<Context> c;

    public zzcwe(zzdtu<zzvx> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        this.f3471a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcwc(this.f3471a.get(), this.b.get(), this.c.get());
    }
}
