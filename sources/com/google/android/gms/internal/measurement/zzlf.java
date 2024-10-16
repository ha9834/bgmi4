package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlf implements zzlg {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4620a;
    private static final zzcm<Double> b;
    private static final zzcm<Long> c;
    private static final zzcm<Long> d;
    private static final zzcm<String> e;

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final boolean zzzq() {
        return f4620a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final double zzzr() {
        return b.get().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final long zzzs() {
        return c.get().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final long zzzt() {
        return d.get().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final String zzzu() {
        return e.get();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4620a = zzctVar.zzb("measurement.test.boolean_flag", false);
        b = zzctVar.zza("measurement.test.double_flag", -3.0d);
        c = zzctVar.zze("measurement.test.int_flag", -2L);
        d = zzctVar.zze("measurement.test.long_flag", -1L);
        e = zzctVar.zzt("measurement.test.string_flag", "---");
    }
}
