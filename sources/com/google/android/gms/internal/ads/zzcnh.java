package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcnh implements zzdti<zzcnd> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3335a;
    private final zzdtu<zzcdf> b;

    public zzcnh(zzdtu<Context> zzdtuVar, zzdtu<zzcdf> zzdtuVar2) {
        this.f3335a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcnd(this.f3335a.get(), this.b.get());
    }
}
