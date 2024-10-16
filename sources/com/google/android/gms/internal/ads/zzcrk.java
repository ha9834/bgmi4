package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcrk implements zzcva<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbh<String> f3395a;
    private final Executor b;

    public zzcrk(zzbbh<String> zzbbhVar, Executor executor) {
        this.f3395a = zzbbhVar;
        this.b = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<Object> zzalm() {
        return zzbar.zza(this.f3395a, xy.f2625a, this.b);
    }
}
