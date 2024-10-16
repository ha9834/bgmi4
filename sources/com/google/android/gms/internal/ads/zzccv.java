package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzccv implements zzdti<zzccj> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3184a;
    private final zzdtu<Executor> b;
    private final zzdtu<zzdh> c;
    private final zzdtu<zzbai> d;
    private final zzdtu<com.google.android.gms.ads.internal.zza> e;
    private final zzdtu<zzbhf> f;

    public zzccv(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzdh> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<com.google.android.gms.ads.internal.zza> zzdtuVar5, zzdtu<zzbhf> zzdtuVar6) {
        this.f3184a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccj(this.f3184a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
