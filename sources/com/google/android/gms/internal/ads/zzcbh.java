package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcbh implements zzdti<zzcbd> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3164a;
    private final zzdtu<zzcau> b;

    public zzcbh(zzdtu<Executor> zzdtuVar, zzdtu<zzcau> zzdtuVar2) {
        this.f3164a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbd(this.f3164a.get(), this.b.get());
    }
}
