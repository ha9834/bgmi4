package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class zzbqd implements zzdti<zzawj> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Clock> f3005a;
    private final zzdtu<zzawu> b;
    private final zzdtu<zzcxv> c;

    private zzbqd(zzdtu<Clock> zzdtuVar, zzdtu<zzawu> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        this.f3005a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzbqd zzg(zzdtu<Clock> zzdtuVar, zzdtu<zzawu> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        return new zzbqd(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzawj) zzdto.zza(this.b.get().zza(this.f3005a.get(), this.c.get().zzglb), "Cannot return null from a non-@Nullable @Provides method");
    }
}
