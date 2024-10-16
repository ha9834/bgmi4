package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public final class zzcrg implements zzdti<zzcre> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3391a;
    private final zzdtu<Context> b;
    private final zzdtu<zzcxv> c;
    private final zzdtu<ViewGroup> d;

    public zzcrg(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<ViewGroup> zzdtuVar4) {
        this.f3391a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcre(this.f3391a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
