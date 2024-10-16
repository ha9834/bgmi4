package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcve<T> implements zzdti<zzcvb<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3455a;
    private final zzdtu<Set<zzcva<? extends zzcuz<T>>>> b;

    private zzcve(zzdtu<Executor> zzdtuVar, zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzdtuVar2) {
        this.f3455a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static <T> zzcve<T> zzas(zzdtu<Executor> zzdtuVar, zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzdtuVar2) {
        return new zzcve<>(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcvb(this.f3455a.get(), this.b.get());
    }
}
