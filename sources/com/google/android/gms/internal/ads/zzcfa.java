package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcfa implements zzdti<zzcex> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzwj> f3221a;
    private final zzdtu<Map<zzczs, zzcez>> b;

    private zzcfa(zzdtu<zzwj> zzdtuVar, zzdtu<Map<zzczs, zzcez>> zzdtuVar2) {
        this.f3221a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcfa zzr(zzdtu<zzwj> zzdtuVar, zzdtu<Map<zzczs, zzcez>> zzdtuVar2) {
        return new zzcfa(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcex(this.f3221a.get(), this.b.get());
    }
}
