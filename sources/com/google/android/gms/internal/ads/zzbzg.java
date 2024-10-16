package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbzg implements zzdti<zzavf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbzf f3136a;
    private final zzdtu<Context> b;
    private final zzdtu<zzcxv> c;

    private zzbzg(zzbzf zzbzfVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        this.f3136a = zzbzfVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzbzg zza(zzbzf zzbzfVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        return new zzbzg(zzbzfVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.zza(new zzavf(this.b.get(), this.c.get().zzglb), "Cannot return null from a non-@Nullable @Provides method");
    }
}
