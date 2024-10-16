package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlv implements zzdb<zzly> {

    /* renamed from: a, reason: collision with root package name */
    private static zzlv f4630a = new zzlv();
    private final zzdb<zzly> b;

    public static boolean zzaad() {
        return ((zzly) f4630a.get()).zzaad();
    }

    public static boolean zzaae() {
        return ((zzly) f4630a.get()).zzaae();
    }

    private zzlv(zzdb<zzly> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzlv() {
        this(zzda.zzg(new zzlx()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzly get() {
        return this.b.get();
    }
}
