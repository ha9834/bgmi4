package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzchd implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<tt> f3255a;
    private final zzdtu<Executor> b;

    private zzchd(zzdtu<tt> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3255a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzchd zzab(zzdtu<tt> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzchd(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3255a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
