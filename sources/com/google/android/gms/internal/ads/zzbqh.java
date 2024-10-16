package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbqh implements zzdti<zzbuz<zzxr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbme> f3009a;
    private final zzdtu<Executor> b;

    private zzbqh(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3009a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbqh zzd(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbqh(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3009a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
