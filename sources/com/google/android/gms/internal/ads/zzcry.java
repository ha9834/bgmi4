package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcry implements zzdti<zzcrv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3402a;
    private final zzdtu<zzawm> b;

    private zzcry(zzdtu<Executor> zzdtuVar, zzdtu<zzawm> zzdtuVar2) {
        this.f3402a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcry zzaj(zzdtu<Executor> zzdtuVar, zzdtu<zzawm> zzdtuVar2) {
        return new zzcry(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcrv(this.f3402a.get(), this.b.get());
    }
}
