package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzcqy implements zzdti<zzbbh<zzcrc>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3386a;
    private final zzdtu<zzcqz> b;
    private final zzdtu<zzbbh<zzarx>> c;

    public zzcqy(zzdtu<zzczt> zzdtuVar, zzdtu<zzcqz> zzdtuVar2, zzdtu<zzbbh<zzarx>> zzdtuVar3) {
        this.f3386a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.zza(this.f3386a.get().zza((zzczt) zzczs.GENERATE_SIGNALS, (zzbbh) this.c.get()).zza(this.b.get()).zza(((Integer) zzyt.zzpe().zzd(zzacu.zzcvn)).intValue(), TimeUnit.SECONDS).zzane(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
