package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjv implements zzjw {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4595a;
    private static final zzcm<Long> b;

    @Override // com.google.android.gms.internal.measurement.zzjw
    public final boolean zzyy() {
        return f4595a.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4595a = zzctVar.zzb("measurement.upload_dsid_enabled", false);
        b = zzctVar.zze("measurement.id.upload_dsid_enabled", 0L);
    }
}
