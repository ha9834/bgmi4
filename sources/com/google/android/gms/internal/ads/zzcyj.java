package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcyj implements zzdti<zzcyi> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3500a;
    private final zzdtu<zzawu> b;

    private zzcyj(zzdtu<Context> zzdtuVar, zzdtu<zzawu> zzdtuVar2) {
        this.f3500a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcyj zzau(zzdtu<Context> zzdtuVar, zzdtu<zzawu> zzdtuVar2) {
        return new zzcyj(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcyi(this.f3500a.get(), this.b.get());
    }
}
