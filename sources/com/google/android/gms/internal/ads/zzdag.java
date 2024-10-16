package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzdag implements zzdti<zzdae> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3527a;
    private final zzdtu<zzbah> b;
    private final zzdtu<zzcmu> c;
    private final zzdtu<zzbai> d;
    private final zzdtu<String> e;
    private final zzdtu<String> f;
    private final zzdtu<Context> g;
    private final zzdtu<Clock> h;

    private zzdag(zzdtu<Executor> zzdtuVar, zzdtu<zzbah> zzdtuVar2, zzdtu<zzcmu> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<String> zzdtuVar5, zzdtu<String> zzdtuVar6, zzdtu<Context> zzdtuVar7, zzdtu<Clock> zzdtuVar8) {
        this.f3527a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
        this.g = zzdtuVar7;
        this.h = zzdtuVar8;
    }

    public static zzdag zzc(zzdtu<Executor> zzdtuVar, zzdtu<zzbah> zzdtuVar2, zzdtu<zzcmu> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<String> zzdtuVar5, zzdtu<String> zzdtuVar6, zzdtu<Context> zzdtuVar7, zzdtu<Clock> zzdtuVar8) {
        return new zzdag(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzdae(this.f3527a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
