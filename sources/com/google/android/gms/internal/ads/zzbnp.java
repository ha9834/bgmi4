package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbnp implements zzdti<zzcxn> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2954a;

    public zzbnp(zzbnk zzbnkVar) {
        this.f2954a = zzbnkVar;
    }

    public static zzcxn zzb(zzbnk zzbnkVar) {
        return (zzcxn) zzdto.zza(zzbnkVar.zzafp(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzb(this.f2954a);
    }
}
