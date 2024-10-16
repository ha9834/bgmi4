package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjj implements zzjk {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4587a;
    private static final zzcm<Boolean> b;
    private static final zzcm<Boolean> c;

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzxj() {
        return f4587a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzxk() {
        return b.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzxl() {
        return c.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4587a = zzctVar.zzb("measurement.log_installs_enabled", false);
        b = zzctVar.zzb("measurement.log_third_party_store_events_enabled", false);
        c = zzctVar.zzb("measurement.log_upgrades_enabled", false);
    }
}
