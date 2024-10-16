package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class zzbqf implements zzdti<zzbqe> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Clock> f3007a;
    private final zzdtu<zzawj> b;

    private zzbqf(zzdtu<Clock> zzdtuVar, zzdtu<zzawj> zzdtuVar2) {
        this.f3007a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbqf zzb(zzdtu<Clock> zzdtuVar, zzdtu<zzawj> zzdtuVar2) {
        return new zzbqf(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbqe(this.f3007a.get(), this.b.get());
    }
}
