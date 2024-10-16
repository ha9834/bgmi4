package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcfe implements zzdti<zzbuz<zzbro>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcfb> f3225a;
    private final zzdtu<Executor> b;

    private zzcfe(zzdtu<zzcfb> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3225a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcfe zzu(zzdtu<zzcfb> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfe(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3225a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
