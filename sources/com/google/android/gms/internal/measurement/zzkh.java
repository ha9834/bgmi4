package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkh implements zzki {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4603a;
    private static final zzcm<Long> b;

    @Override // com.google.android.gms.internal.measurement.zzki
    public final boolean zzze() {
        return f4603a.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4603a = zzctVar.zzb("measurement.fetch_config_with_admob_app_id", true);
        b = zzctVar.zze("measurement.id.fetch_config_with_admob_app_id", 0L);
    }
}
