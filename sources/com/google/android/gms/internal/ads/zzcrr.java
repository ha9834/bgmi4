package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcrr implements zzdti<zzcrp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcsk<zzcvf>> f3399a;
    private final zzdtu<zzcxv> b;
    private final zzdtu<Context> c;
    private final zzdtu<zzawm> d;

    private zzcrr(zzdtu<zzcsk<zzcvf>> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<Context> zzdtuVar3, zzdtu<zzawm> zzdtuVar4) {
        this.f3399a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    public static zzcrr zzg(zzdtu<zzcsk<zzcvf>> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<Context> zzdtuVar3, zzdtu<zzawm> zzdtuVar4) {
        return new zzcrr(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcrp(this.f3399a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
