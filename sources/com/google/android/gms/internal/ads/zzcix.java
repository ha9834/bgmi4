package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcix implements zzdti<zzbuz<zzbro>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcjg> f3275a;
    private final zzdtu<Executor> b;

    private zzcix(zzdtu<zzcjg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3275a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcix zzae(zzdtu<zzcjg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcix(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3275a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
