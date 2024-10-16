package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbos implements zzdti<zzbol> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzaga> f2977a;
    private final zzdtu<Runnable> b;
    private final zzdtu<Executor> c;
    private final zzdtu<zzcxu> d;
    private final zzdtu<zzcxm> e;
    private final zzdtu<zzbry> f;
    private final zzdtu<zzbso> g;
    private final zzdtu<String> h;

    public zzbos(zzdtu<zzaga> zzdtuVar, zzdtu<Runnable> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzcxu> zzdtuVar4, zzdtu<zzcxm> zzdtuVar5, zzdtu<zzbry> zzdtuVar6, zzdtu<zzbso> zzdtuVar7, zzdtu<String> zzdtuVar8) {
        this.f2977a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
        this.g = zzdtuVar7;
        this.h = zzdtuVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbol zzbolVar = new zzbol(this.f2977a.get(), this.b.get(), this.c.get());
        zzbql.zza(zzbolVar, this.d.get());
        zzbql.zza(zzbolVar, this.e.get());
        zzbql.zza(zzbolVar, this.f.get());
        zzbql.zza(zzbolVar, this.g.get());
        zzbql.zza(zzbolVar, this.h.get());
        return zzbolVar;
    }
}
