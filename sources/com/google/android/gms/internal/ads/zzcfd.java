package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcfd implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcfb> f3224a;
    private final zzdtu<Executor> b;

    private zzcfd(zzdtu<zzcfb> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3224a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcfd zzt(zzdtu<zzcfb> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfd(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3224a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
