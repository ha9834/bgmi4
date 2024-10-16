package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbqa implements zzdti<zzbuz<zzbrw>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbpx f3002a;
    private final zzdtu<zzbqe> b;

    private zzbqa(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.f3002a = zzbpxVar;
        this.b = zzdtuVar;
    }

    public static zzbqa zzc(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbqa(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
