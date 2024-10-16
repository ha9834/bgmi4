package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzblf implements zzdti<zzayu> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f2906a;

    public zzblf(zzdtu<Context> zzdtuVar) {
        this.f2906a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzayu) zzdto.zza(new zzayu(this.f2906a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
