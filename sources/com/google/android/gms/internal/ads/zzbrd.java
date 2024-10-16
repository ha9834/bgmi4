package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbrd implements zzdti<String> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqy f3025a;
    private final zzdtu<zzbqe> b;

    private zzbrd(zzbqy zzbqyVar, zzdtu<zzbqe> zzdtuVar) {
        this.f3025a = zzbqyVar;
        this.b = zzdtuVar;
    }

    public static zzbrd zzb(zzbqy zzbqyVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbrd(zzbqyVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.zza(this.b.get().zzum(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
