package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcmj implements zzdti<zzcmg> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3320a;
    private final zzdtu<zzbxo> b;

    public zzcmj(zzdtu<Context> zzdtuVar, zzdtu<zzbxo> zzdtuVar2) {
        this.f3320a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcmg(this.f3320a.get(), this.b.get());
    }
}
