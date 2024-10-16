package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcrb implements zzdti<zzcqz> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3388a;
    private final zzdtu<zzchz> b;

    public zzcrb(zzdtu<Executor> zzdtuVar, zzdtu<zzchz> zzdtuVar2) {
        this.f3388a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcqz(this.f3388a.get(), this.b.get());
    }
}
