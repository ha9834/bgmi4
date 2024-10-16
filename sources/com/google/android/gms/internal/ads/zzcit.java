package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcit implements zzdti<zzcig> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3271a;
    private final zzdtu<Executor> b;
    private final zzdtu<zzasm> c;
    private final zzdtu<zzblp> d;
    private final zzdtu<zzasl> e;

    private zzcit(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzasm> zzdtuVar3, zzdtu<zzblp> zzdtuVar4, zzdtu<zzasl> zzdtuVar5) {
        this.f3271a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    public static zzcit zzg(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzasm> zzdtuVar3, zzdtu<zzblp> zzdtuVar4, zzdtu<zzasl> zzdtuVar5) {
        return new zzcit(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcig(this.f3271a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
