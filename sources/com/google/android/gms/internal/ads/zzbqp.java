package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbqp implements zzdti<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqo f3014a;
    private final zzdtu<zzbpv> b;

    private zzbqp(zzbqo zzbqoVar, zzdtu<zzbpv> zzdtuVar) {
        this.f3014a = zzbqoVar;
        this.b = zzdtuVar;
    }

    public static zzbqp zza(zzbqo zzbqoVar, zzdtu<zzbpv> zzdtuVar) {
        return new zzbqp(zzbqoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
