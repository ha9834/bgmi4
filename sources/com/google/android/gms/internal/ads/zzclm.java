package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzclm implements zzdti<zzcle> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3309a;
    private final zzdtu<zzbai> b;
    private final zzdtu<zzcxv> c;
    private final zzdtu<Executor> d;
    private final zzdtu<zzbws> e;
    private final zzdtu<zzcdn> f;

    public zzclm(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<Executor> zzdtuVar4, zzdtu<zzbws> zzdtuVar5, zzdtu<zzcdn> zzdtuVar6) {
        this.f3309a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcle(this.f3309a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
