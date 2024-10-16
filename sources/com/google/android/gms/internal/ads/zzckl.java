package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzckl implements zzdti<zzckj> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3295a;
    private final zzdtu<zzbai> b;
    private final zzdtu<zzboc> c;

    public zzckl(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzboc> zzdtuVar3) {
        this.f3295a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckj(this.f3295a.get(), this.b.get(), this.c.get());
    }
}
