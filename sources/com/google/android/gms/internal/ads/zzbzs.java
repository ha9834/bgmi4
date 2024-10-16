package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class zzbzs implements zzdti<zzbzq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzccj> f3143a;
    private final zzdtu<Clock> b;

    public zzbzs(zzdtu<zzccj> zzdtuVar, zzdtu<Clock> zzdtuVar2) {
        this.f3143a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbzq(this.f3143a.get(), this.b.get());
    }
}
