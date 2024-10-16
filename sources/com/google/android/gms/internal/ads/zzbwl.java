package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbwl implements zzdti<zzbuz<zzbrl>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3084a;
    private final zzdtu<zzbxg> b;
    private final zzdtu<Executor> c;

    private zzbwl(zzbvz zzbvzVar, zzdtu<zzbxg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3084a = zzbvzVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzbwl zzb(zzbvz zzbvzVar, zzdtu<zzbxg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbwl(zzbvzVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
