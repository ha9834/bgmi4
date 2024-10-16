package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzckq implements zzdti<zzckm> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3297a;
    private final zzdtu<zzboc> b;

    public zzckq(zzdtu<Context> zzdtuVar, zzdtu<zzboc> zzdtuVar2) {
        this.f3297a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckm(this.f3297a.get(), this.b.get());
    }
}
