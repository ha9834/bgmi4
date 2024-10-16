package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcpe implements zzdti<zzcpa> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3358a;
    private final zzdtu<zzbws> b;

    public zzcpe(zzdtu<Context> zzdtuVar, zzdtu<zzbws> zzdtuVar2) {
        this.f3358a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcpa(this.f3358a.get(), this.b.get());
    }
}
