package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbwj implements zzdti<zzavf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3083a;
    private final zzdtu<Context> b;
    private final zzdtu<zzcxv> c;

    private zzbwj(zzbvz zzbvzVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        this.f3083a = zzbvzVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzbwj zza(zzbvz zzbvzVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        return new zzbwj(zzbvzVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.zza(new zzavf(this.b.get(), this.c.get().zzglb), "Cannot return null from a non-@Nullable @Provides method");
    }
}
