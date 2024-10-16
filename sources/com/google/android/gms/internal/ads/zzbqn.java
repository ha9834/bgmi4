package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbqn implements zzdti<com.google.android.gms.ads.internal.zzb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqm f3013a;
    private final zzdtu<Context> b;
    private final zzdtu<zzavb> c;

    private zzbqn(zzbqm zzbqmVar, zzdtu<Context> zzdtuVar, zzdtu<zzavb> zzdtuVar2) {
        this.f3013a = zzbqmVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzbqn zza(zzbqm zzbqmVar, zzdtu<Context> zzdtuVar, zzdtu<zzavb> zzdtuVar2) {
        return new zzbqn(zzbqmVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (com.google.android.gms.ads.internal.zzb) zzdto.zza(new com.google.android.gms.ads.internal.zzb(this.b.get(), this.c.get(), null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
