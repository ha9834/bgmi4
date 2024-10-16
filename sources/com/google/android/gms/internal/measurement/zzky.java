package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzky implements zzkv {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4614a;
    private static final zzcm<Boolean> b;

    @Override // com.google.android.gms.internal.measurement.zzkv
    public final boolean zzzm() {
        return f4614a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkv
    public final boolean zzzn() {
        return b.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4614a = zzctVar.zzb("measurement.personalized_ads_signals_collection_enabled", true);
        b = zzctVar.zzb("measurement.personalized_ads_property_translation_enabled", true);
    }
}
