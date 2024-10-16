package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcuu implements zzdti<zzcus> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzavg> f3450a;
    private final zzdtu<zzbbl> b;
    private final zzdtu<Context> c;

    private zzcuu(zzdtu<zzavg> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        this.f3450a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzcuu zzo(zzdtu<zzavg> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        return new zzcuu(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcus(this.f3450a.get(), this.b.get(), this.c.get());
    }
}
