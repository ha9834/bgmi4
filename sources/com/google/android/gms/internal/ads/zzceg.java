package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzceg implements zzdti<zzbuz<zzxr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcep> f3203a;
    private final zzdtu<Executor> b;

    private zzceg(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3203a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzceg zzl(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzceg(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.f3203a.get(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
