package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcaa implements zzdti<zzbzt> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3145a;
    private final zzdtu<zzcdn> b;
    private final zzdtu<zzccj> c;
    private final zzdtu<zzbmy> d;
    private final zzdtu<zzbzb> e;

    public zzcaa(zzdtu<Context> zzdtuVar, zzdtu<zzcdn> zzdtuVar2, zzdtu<zzccj> zzdtuVar3, zzdtu<zzbmy> zzdtuVar4, zzdtu<zzbzb> zzdtuVar5) {
        this.f3145a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbzt(this.f3145a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
