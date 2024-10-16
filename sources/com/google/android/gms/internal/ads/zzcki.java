package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcki implements zzdti<zzckb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzboc> f3293a;
    private final zzdtu<Context> b;
    private final zzdtu<Executor> c;
    private final zzdtu<zzcdn> d;
    private final zzdtu<zzcxv> e;
    private final zzdtu<zzbam<zzcxm, zzayb>> f;

    public zzcki(zzdtu<zzboc> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzcdn> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5, zzdtu<zzbam<zzcxm, zzayb>> zzdtuVar6) {
        this.f3293a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckb(this.f3293a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
