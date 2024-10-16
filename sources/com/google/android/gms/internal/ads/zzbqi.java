package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbqi implements zzdti<zzbuz<zzbrl>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbme> f3010a;
    private final zzdtu<Executor> b;

    private zzbqi(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3010a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbqi zze(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbqi(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3010a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
