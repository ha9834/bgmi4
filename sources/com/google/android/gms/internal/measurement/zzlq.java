package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlq implements zzln {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4627a;
    private static final zzcm<Long> b;

    @Override // com.google.android.gms.internal.measurement.zzln
    public final boolean zzzx() {
        return f4627a.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4627a = zzctVar.zzb("measurement.reset_analytics.persist_time", false);
        b = zzctVar.zze("measurement.id.reset_analytics.persist_time", 0L);
    }
}
