package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzcuq implements zzdti<zzcul> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3447a;
    private final zzdtu<ScheduledExecutorService> b;
    private final zzdtu<String> c;
    private final zzdtu<zzcpf> d;
    private final zzdtu<Context> e;
    private final zzdtu<zzcxv> f;

    private zzcuq(zzdtu<zzbbl> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<String> zzdtuVar3, zzdtu<zzcpf> zzdtuVar4, zzdtu<Context> zzdtuVar5, zzdtu<zzcxv> zzdtuVar6) {
        this.f3447a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
    }

    public static zzcuq zzb(zzdtu<zzbbl> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<String> zzdtuVar3, zzdtu<zzcpf> zzdtuVar4, zzdtu<Context> zzdtuVar5, zzdtu<zzcxv> zzdtuVar6) {
        return new zzcuq(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcul(this.f3447a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
