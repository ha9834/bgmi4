package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzclu implements zzdti<zzclq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3313a;
    private final zzdtu<zzbws> b;

    public zzclu(zzdtu<Context> zzdtuVar, zzdtu<zzbws> zzdtuVar2) {
        this.f3313a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzclq(this.f3313a.get(), this.b.get());
    }
}
