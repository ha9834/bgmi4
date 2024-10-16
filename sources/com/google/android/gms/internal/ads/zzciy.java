package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzciy implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcjg> f3276a;
    private final zzdtu<Executor> b;

    private zzciy(zzdtu<zzcjg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3276a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzciy zzaf(zzdtu<zzcjg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzciy(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3276a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
