package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbqu implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqt f3017a;
    private final zzdtu<zzbqr> b;

    private zzbqu(zzbqt zzbqtVar, zzdtu<zzbqr> zzdtuVar) {
        this.f3017a = zzbqtVar;
        this.b = zzdtuVar;
    }

    public static zzbqu zza(zzbqt zzbqtVar, zzdtu<zzbqr> zzdtuVar) {
        return new zzbqu(zzbqtVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
