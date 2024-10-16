package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjo implements zzjl {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4590a;
    private static final zzcm<Long> b;

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final boolean zzxm() {
        return f4590a.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4590a = zzctVar.zzb("measurement.app_launch.event_ordering_fix", false);
        b = zzctVar.zze("measurement.id.app_launch.event_ordering_fix", 0L);
    }
}
