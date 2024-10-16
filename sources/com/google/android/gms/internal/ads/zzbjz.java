package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbjz implements zzdti<zzasl> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f2896a;

    public zzbjz(zzdtu<Context> zzdtuVar) {
        this.f2896a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Context context = this.f2896a.get();
        return (zzasl) zzdto.zza(new zzasj(context, new zzaso(context).zztt()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
