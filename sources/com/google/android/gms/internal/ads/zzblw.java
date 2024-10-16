package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzblw implements zzdti<zzblv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzaxb> f2921a;

    private zzblw(zzdtu<zzaxb> zzdtuVar) {
        this.f2921a = zzdtuVar;
    }

    public static zzblw zzd(zzdtu<zzaxb> zzdtuVar) {
        return new zzblw(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblv(this.f2921a.get());
    }
}
