package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbqb implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbpx f3003a;
    private final zzdtu<zzbqe> b;

    private zzbqb(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.f3003a = zzbpxVar;
        this.b = zzdtuVar;
    }

    public static zzbqb zzd(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbqb(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
