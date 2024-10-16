package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcid implements zzdti<tt> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3269a;
    private final zzdtu<zzavg> b;

    private zzcid(zzdtu<Context> zzdtuVar, zzdtu<zzavg> zzdtuVar2) {
        this.f3269a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcid zzad(zzdtu<Context> zzdtuVar, zzdtu<zzavg> zzdtuVar2) {
        return new zzcid(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new tt(this.f3269a.get(), this.b.get());
    }
}
