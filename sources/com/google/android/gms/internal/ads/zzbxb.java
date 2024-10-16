package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbxb implements zzdti<zzbxa> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3096a;
    private final zzdtu<zzbgz> b;
    private final zzdtu<zzcxm> c;
    private final zzdtu<zzbai> d;
    private final zzdtu<Integer> e;

    private zzbxb(zzdtu<Context> zzdtuVar, zzdtu<zzbgz> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<Integer> zzdtuVar5) {
        this.f3096a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    public static zzbxb zzc(zzdtu<Context> zzdtuVar, zzdtu<zzbgz> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<Integer> zzdtuVar5) {
        return new zzbxb(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxa(this.f3096a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get().intValue());
    }
}
