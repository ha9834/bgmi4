package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzchi implements zzdti<zzchv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3260a;

    private zzchi(zzdtu<Context> zzdtuVar) {
        this.f3260a = zzdtuVar;
    }

    public static zzchi zzae(zzdtu<Context> zzdtuVar) {
        return new zzchi(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzchv) zzdto.zza(new zzchv(this.f3260a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
