package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcyr implements zzdti<Context> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcyo f3505a;
    private final zzdtu<zzcym> b;

    private zzcyr(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        this.f3505a = zzcyoVar;
        this.b = zzdtuVar;
    }

    public static zzcyr zzb(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        return new zzcyr(zzcyoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Context) zzdto.zza(this.b.get().zzys, "Cannot return null from a non-@Nullable @Provides method");
    }
}
