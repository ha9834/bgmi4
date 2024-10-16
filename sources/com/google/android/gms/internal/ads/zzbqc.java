package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbqc implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbpx f3004a;
    private final zzdtu<zzbqe> b;

    private zzbqc(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.f3004a = zzbpxVar;
        this.b = zzdtuVar;
    }

    public static zzbqc zze(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbqc(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
