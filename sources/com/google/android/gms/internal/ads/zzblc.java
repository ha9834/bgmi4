package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzblc implements zzdti<zzbkz> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f2904a;
    private final zzdtu<zzbai> b;
    private final zzdtu<zzclc> c;
    private final zzdtu<zzcjz<zzams, zzclb>> d;
    private final zzdtu<zzcpf> e;
    private final zzdtu<zzcgb> f;

    public zzblc(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzclc> zzdtuVar3, zzdtu<zzcjz<zzams, zzclb>> zzdtuVar4, zzdtu<zzcpf> zzdtuVar5, zzdtu<zzcgb> zzdtuVar6) {
        this.f2904a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbkz(this.f2904a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
