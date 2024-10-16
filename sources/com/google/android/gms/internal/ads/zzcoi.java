package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsm;

/* loaded from: classes2.dex */
public final class zzcoi<AdT, AdapterT, ListenerT extends zzbsm> implements zzdti<zzcoe<AdT, AdapterT, ListenerT>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3346a;
    private final zzdtu<zzbbl> b;
    private final zzdtu<zzcjz<AdapterT, ListenerT>> c;
    private final zzdtu<zzcka<AdT, AdapterT, ListenerT>> d;

    private zzcoi(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzcjz<AdapterT, ListenerT>> zzdtuVar3, zzdtu<zzcka<AdT, AdapterT, ListenerT>> zzdtuVar4) {
        this.f3346a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbsm> zzcoi<AdT, AdapterT, ListenerT> zzf(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzcjz<AdapterT, ListenerT>> zzdtuVar3, zzdtu<zzcka<AdT, AdapterT, ListenerT>> zzdtuVar4) {
        return new zzcoi<>(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcoe(this.f3346a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
