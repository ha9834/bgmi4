package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzma implements zzdb<zzlz> {

    /* renamed from: a, reason: collision with root package name */
    private static zzma f4633a = new zzma();
    private final zzdb<zzlz> b;

    public static boolean zzaaf() {
        return ((zzlz) f4633a.get()).zzaaf();
    }

    public static boolean zzaag() {
        return ((zzlz) f4633a.get()).zzaag();
    }

    public static boolean zzaah() {
        return ((zzlz) f4633a.get()).zzaah();
    }

    private zzma(zzdb<zzlz> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzma() {
        this(zzda.zzg(new zzmc()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlz get() {
        return this.b.get();
    }
}
