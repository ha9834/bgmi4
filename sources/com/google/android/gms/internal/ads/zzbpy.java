package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbpy implements zzdti<zzbuz<zzxr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbpx f3000a;
    private final zzdtu<zzbqe> b;

    private zzbpy(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.f3000a = zzbpxVar;
        this.b = zzdtuVar;
    }

    public static zzbpy zza(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbpy(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
