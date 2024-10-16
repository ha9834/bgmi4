package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzld implements zzdb<zzlg> {

    /* renamed from: a, reason: collision with root package name */
    private static zzld f4618a = new zzld();
    private final zzdb<zzlg> b;

    public static boolean zzzq() {
        return ((zzlg) f4618a.get()).zzzq();
    }

    public static double zzzr() {
        return ((zzlg) f4618a.get()).zzzr();
    }

    public static long zzzs() {
        return ((zzlg) f4618a.get()).zzzs();
    }

    public static long zzzt() {
        return ((zzlg) f4618a.get()).zzzt();
    }

    public static String zzzu() {
        return ((zzlg) f4618a.get()).zzzu();
    }

    private zzld(zzdb<zzlg> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzld() {
        this(zzda.zzg(new zzlf()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlg get() {
        return this.b.get();
    }
}
