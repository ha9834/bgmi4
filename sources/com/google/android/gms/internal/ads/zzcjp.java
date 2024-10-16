package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcjp implements zzdti<zzcjm> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3288a;
    private final zzdtu<zzbbh<Bundle>> b;
    private final zzdtu<zzcji> c;
    private final zzdtu<zzcjc> d;

    private zzcjp(zzdtu<Context> zzdtuVar, zzdtu<zzbbh<Bundle>> zzdtuVar2, zzdtu<zzcji> zzdtuVar3, zzdtu<zzcjc> zzdtuVar4) {
        this.f3288a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    public static zzcjp zze(zzdtu<Context> zzdtuVar, zzdtu<zzbbh<Bundle>> zzdtuVar2, zzdtu<zzcji> zzdtuVar3, zzdtu<zzcjc> zzdtuVar4) {
        return new zzcjp(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcjm(this.f3288a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
