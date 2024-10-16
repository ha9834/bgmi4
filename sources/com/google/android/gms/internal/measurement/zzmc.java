package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzmc implements zzlz {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4635a;
    private static final zzcm<Boolean> b;
    private static final zzcm<Boolean> c;
    private static final zzcm<Long> d;

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final boolean zzaaf() {
        return f4635a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final boolean zzaag() {
        return b.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final boolean zzaah() {
        return c.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4635a = zzctVar.zzb("measurement.service.sessions.remove_disabled_session_number", false);
        b = zzctVar.zzb("measurement.service.sessions.session_number_enabled", false);
        c = zzctVar.zzb("measurement.service.sessions.session_number_backfill_enabled", false);
        d = zzctVar.zze("measurement.id.session_number", 0L);
    }
}
