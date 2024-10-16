package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class zzcsn implements zzdti<zzcsk<zzcvf>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zl> f3413a;
    private final zzdtu<Clock> b;

    public zzcsn(zzdtu<zl> zzdtuVar, zzdtu<Clock> zzdtuVar2) {
        this.f3413a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcsk) zzdto.zza(new zzcsk(this.f3413a.get(), ((Long) zzyt.zzpe().zzd(zzacu.zzcqm)).longValue(), this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
