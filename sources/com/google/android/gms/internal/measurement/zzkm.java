package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkm implements zzkj {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4606a;
    private static final zzcm<Boolean> b;

    @Override // com.google.android.gms.internal.measurement.zzkj
    public final boolean zzzf() {
        return f4606a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkj
    public final boolean zzzg() {
        return b.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4606a = zzctVar.zzb("measurement.collection.efficient_engagement_reporting_enabled", false);
        b = zzctVar.zzb("measurement.collection.redundant_engagement_removal_enabled", false);
    }
}
