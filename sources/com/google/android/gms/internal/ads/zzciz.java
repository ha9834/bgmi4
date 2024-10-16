package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzciz implements zzdti<zzbuz<zzczz>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcjk> f3277a;
    private final zzdtu<Executor> b;

    private zzciz(zzdtu<zzcjk> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3277a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzciz zzag(zzdtu<zzcjk> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzciz(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3277a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
