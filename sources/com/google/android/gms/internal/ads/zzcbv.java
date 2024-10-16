package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcbv implements zzdti<zzcbi> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3168a;
    private final zzdtu<zzcxv> b;
    private final zzdtu<Executor> c;
    private final zzdtu<zzcdn> d;

    public zzcbv(zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzcdn> zzdtuVar4) {
        this.f3168a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbi(this.f3168a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
