package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzclp implements zzdti<zzcln> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3311a;
    private final zzdtu<zzbai> b;
    private final zzdtu<zzbws> c;

    public zzclp(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzbws> zzdtuVar3) {
        this.f3311a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcln(this.f3311a.get(), this.b.get(), this.c.get());
    }
}
