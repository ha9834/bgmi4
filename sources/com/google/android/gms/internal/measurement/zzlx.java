package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlx implements zzly {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4632a;
    private static final zzcm<Boolean> b;
    private static final zzcm<Long> c;

    @Override // com.google.android.gms.internal.measurement.zzly
    public final boolean zzaad() {
        return f4632a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final boolean zzaae() {
        return b.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4632a = zzctVar.zzb("measurement.audience.sequence_filters", false);
        b = zzctVar.zzb("measurement.audience.sequence_filters_bundle_timestamp", false);
        c = zzctVar.zze("measurement.id.audience.sequence_filters", 0L);
    }
}
