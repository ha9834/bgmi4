package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbjr implements zzdti<Context> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjn f2888a;

    public zzbjr(zzbjn zzbjnVar) {
        this.f2888a = zzbjnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Context) zzdto.zza(this.f2888a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
