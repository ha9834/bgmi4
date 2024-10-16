package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzmd implements zzme {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4636a;
    private static final zzcm<Boolean> b;
    private static final zzcm<Boolean> c;
    private static final zzcm<Boolean> d;
    private static final zzcm<Boolean> e;
    private static final zzcm<Long> f;

    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zzaai() {
        return f4636a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zzaaj() {
        return b.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zzaak() {
        return d.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zzaal() {
        return e.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4636a = zzctVar.zzb("measurement.client.sessions.background_sessions_enabled", true);
        b = zzctVar.zzb("measurement.client.sessions.immediate_start_enabled_foreground", false);
        c = zzctVar.zzb("measurement.client.sessions.immediate_start_enabled", false);
        d = zzctVar.zzb("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        e = zzctVar.zzb("measurement.client.sessions.session_id_enabled", true);
        f = zzctVar.zze("measurement.id.sessionization_client", 0L);
    }
}
