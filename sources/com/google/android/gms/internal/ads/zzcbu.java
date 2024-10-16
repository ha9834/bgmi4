package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcbu implements zzdti<zzcbp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3167a;
    private final zzdtu<zzbmy> b;
    private final zzdtu<zzbva> c;

    public zzcbu(zzdtu<Executor> zzdtuVar, zzdtu<zzbmy> zzdtuVar2, zzdtu<zzbva> zzdtuVar3) {
        this.f3167a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbp(this.f3167a.get(), this.b.get(), this.c.get());
    }
}
