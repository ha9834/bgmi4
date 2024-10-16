package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlp implements zzdb<zzls> {

    /* renamed from: a, reason: collision with root package name */
    private static zzlp f4626a = new zzlp();
    private final zzdb<zzls> b;

    public static boolean zzzy() {
        return ((zzls) f4626a.get()).zzzy();
    }

    private zzlp(zzdb<zzls> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzlp() {
        this(zzda.zzg(new zzlr()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzls get() {
        return this.b.get();
    }
}
