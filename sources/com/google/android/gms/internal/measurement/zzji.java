package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzji implements zzjf {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4586a = new zzct(zzcn.zzdh("com.google.android.gms.measurement")).zzb("measurement.module.collection.conditionally_omit_admob_app_id", true);

    @Override // com.google.android.gms.internal.measurement.zzjf
    public final boolean zzxi() {
        return f4586a.get().booleanValue();
    }
}
