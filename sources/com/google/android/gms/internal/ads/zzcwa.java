package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcwa implements zzdti<zzcvy> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzasc> f3468a;
    private final zzdtu<Context> b;
    private final zzdtu<String> c;
    private final zzdtu<zzbbl> d;

    public zzcwa(zzdtu<zzasc> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<String> zzdtuVar3, zzdtu<zzbbl> zzdtuVar4) {
        this.f3468a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcvy(this.f3468a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
