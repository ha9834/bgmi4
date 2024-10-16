package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcvi implements zzdti<zl> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3457a;
    private final zzdtu<Context> b;

    public zzcvi(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        this.f3457a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zl(this.f3457a.get(), this.b.get());
    }
}
