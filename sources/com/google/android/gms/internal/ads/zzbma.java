package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbma implements zzdti<zzblz> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f2926a;

    private zzbma(zzdtu<Context> zzdtuVar) {
        this.f2926a = zzdtuVar;
    }

    public static zzbma zzf(zzdtu<Context> zzdtuVar) {
        return new zzbma(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblz(this.f2926a.get());
    }
}
