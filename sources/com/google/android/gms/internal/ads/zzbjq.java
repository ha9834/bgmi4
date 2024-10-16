package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbjq implements zzdti<Context> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjn f2887a;

    public zzbjq(zzbjn zzbjnVar) {
        this.f2887a = zzbjnVar;
    }

    public static Context zza(zzbjn zzbjnVar) {
        return (Context) zzdto.zza(zzbjnVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f2887a);
    }
}
