package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlo implements zzdb<zzln> {

    /* renamed from: a, reason: collision with root package name */
    private static zzlo f4625a = new zzlo();
    private final zzdb<zzln> b;

    public static boolean zzzx() {
        return ((zzln) f4625a.get()).zzzx();
    }

    private zzlo(zzdb<zzln> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzlo() {
        this(zzda.zzg(new zzlq()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzln get() {
        return this.b.get();
    }
}
