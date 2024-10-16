package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzmb implements zzdb<zzme> {

    /* renamed from: a, reason: collision with root package name */
    private static zzmb f4634a = new zzmb();
    private final zzdb<zzme> b;

    public static boolean zzaai() {
        return ((zzme) f4634a.get()).zzaai();
    }

    public static boolean zzaaj() {
        return ((zzme) f4634a.get()).zzaaj();
    }

    public static boolean zzaak() {
        return ((zzme) f4634a.get()).zzaak();
    }

    public static boolean zzaal() {
        return ((zzme) f4634a.get()).zzaal();
    }

    private zzmb(zzdb<zzme> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzmb() {
        this(zzda.zzg(new zzmd()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzme get() {
        return this.b.get();
    }
}
