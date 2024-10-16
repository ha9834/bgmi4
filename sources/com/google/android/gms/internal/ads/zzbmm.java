package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbmm implements zzdti<zzbml> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f2934a;
    private final zzdtu<zzty> b;

    private zzbmm(zzdtu<Context> zzdtuVar, zzdtu<zzty> zzdtuVar2) {
        this.f2934a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbmm zza(zzdtu<Context> zzdtuVar, zzdtu<zzty> zzdtuVar2) {
        return new zzbmm(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbml(this.f2934a.get(), this.b.get());
    }
}
