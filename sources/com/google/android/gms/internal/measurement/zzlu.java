package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlu implements zzdb<zzlt> {

    /* renamed from: a, reason: collision with root package name */
    private static zzlu f4629a = new zzlu();
    private final zzdb<zzlt> b;

    public static boolean zzzz() {
        return ((zzlt) f4629a.get()).zzzz();
    }

    public static boolean zzaaa() {
        return ((zzlt) f4629a.get()).zzaaa();
    }

    public static boolean zzaab() {
        return ((zzlt) f4629a.get()).zzaab();
    }

    public static boolean zzaac() {
        return ((zzlt) f4629a.get()).zzaac();
    }

    private zzlu(zzdb<zzlt> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzlu() {
        this(zzda.zzg(new zzlw()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlt get() {
        return this.b.get();
    }
}
