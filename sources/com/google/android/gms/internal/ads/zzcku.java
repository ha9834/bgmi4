package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcku implements zzdti<zzckr> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3299a;
    private final zzdtu<Executor> b;
    private final zzdtu<zzbws> c;
    private final zzdtu<zzcxk> d;

    public zzcku(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzbws> zzdtuVar3, zzdtu<zzcxk> zzdtuVar4) {
        this.f3299a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckr(this.f3299a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
