package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlw implements zzlt {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4631a;
    private static final zzcm<Boolean> b;
    private static final zzcm<Boolean> c;
    private static final zzcm<Boolean> d;

    @Override // com.google.android.gms.internal.measurement.zzlt
    public final boolean zzzz() {
        return f4631a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlt
    public final boolean zzaaa() {
        return b.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlt
    public final boolean zzaab() {
        return c.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlt
    public final boolean zzaac() {
        return d.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4631a = zzctVar.zzb("measurement.service.audience.scoped_filters_v27", false);
        b = zzctVar.zzb("measurement.service.audience.session_scoped_user_engagement", false);
        c = zzctVar.zzb("measurement.service.audience.session_scoped_event_aggregates", false);
        d = zzctVar.zzb("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false);
    }
}
