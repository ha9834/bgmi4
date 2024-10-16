package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbpz implements zzdti<zzbuz<zzbrl>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbpx f3001a;
    private final zzdtu<zzbqe> b;

    private zzbpz(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.f3001a = zzbpxVar;
        this.b = zzdtuVar;
    }

    public static zzbpz zzb(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbpz(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
