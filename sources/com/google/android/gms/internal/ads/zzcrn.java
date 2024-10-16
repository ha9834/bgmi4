package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcrn implements zzdti<zzcrk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbh<String>> f3396a;
    private final zzdtu<Executor> b;

    private zzcrn(zzdtu<zzbbh<String>> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3396a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcrn zzai(zzdtu<zzbbh<String>> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcrn(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcrk(this.f3396a.get(), this.b.get());
    }
}
