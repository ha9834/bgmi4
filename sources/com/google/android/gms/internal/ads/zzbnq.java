package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbnq implements zzdti<zzbpb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2955a;

    public zzbnq(zzbnk zzbnkVar) {
        this.f2955a = zzbnkVar;
    }

    public static zzbpb zzc(zzbnk zzbnkVar) {
        return (zzbpb) zzdto.zza(zzbnkVar.zzafo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzc(this.f2955a);
    }
}
