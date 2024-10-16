package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzccf implements zzdti<zzccd> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3177a;
    private final zzdtu<zzbyt> b;
    private final zzdtu<zzbzl> c;
    private final zzdtu<zzbyn> d;

    private zzccf(zzdtu<Context> zzdtuVar, zzdtu<zzbyt> zzdtuVar2, zzdtu<zzbzl> zzdtuVar3, zzdtu<zzbyn> zzdtuVar4) {
        this.f3177a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    public static zzccf zzb(zzdtu<Context> zzdtuVar, zzdtu<zzbyt> zzdtuVar2, zzdtu<zzbzl> zzdtuVar3, zzdtu<zzbyn> zzdtuVar4) {
        return new zzccf(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccd(this.f3177a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
