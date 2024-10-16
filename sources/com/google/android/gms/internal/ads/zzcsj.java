package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcsj implements zzdti<zzcsh> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3410a;
    private final zzdtu<Context> b;

    public zzcsj(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        this.f3410a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsh(this.f3410a.get(), this.b.get());
    }
}
