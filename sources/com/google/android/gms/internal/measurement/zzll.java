package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzll implements zzlm {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4624a = new zzct(zzcn.zzdh("com.google.android.gms.measurement")).zzb("measurement.experiment.enable_experiment_reporting", true);

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final boolean zzzw() {
        return f4624a.get().booleanValue();
    }
}
