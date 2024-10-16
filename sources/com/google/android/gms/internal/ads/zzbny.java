package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbny implements zzdti<zzbuz<zzue>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2963a;
    private final zzdtu<zzboz> b;
    private final zzdtu<Executor> c;

    public zzbny(zzbnk zzbnkVar, zzdtu<zzboz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f2963a = zzbnkVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
