package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbou implements zzdti<zzbot> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f2979a;
    private final zzdtu<zzbgz> b;
    private final zzdtu<zzcxm> c;
    private final zzdtu<zzbai> d;

    public zzbou(zzdtu<Context> zzdtuVar, zzdtu<zzbgz> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzbai> zzdtuVar4) {
        this.f2979a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbot(this.f2979a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
