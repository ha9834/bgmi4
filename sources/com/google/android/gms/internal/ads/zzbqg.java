package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbqg implements zzdti<zzbuz<zzbvg>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbvh> f3008a;
    private final zzdtu<Executor> b;

    private zzbqg(zzdtu<zzbvh> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3008a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbqg zzc(zzdtu<zzbvh> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbqg(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3008a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
