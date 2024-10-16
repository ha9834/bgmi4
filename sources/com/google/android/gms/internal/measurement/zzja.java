package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzja implements zzdb<zziz> {

    /* renamed from: a, reason: collision with root package name */
    private static zzja f4580a = new zzja();
    private final zzdb<zziz> b;

    public static boolean zzxg() {
        return ((zziz) f4580a.get()).zzxg();
    }

    private zzja(zzdb<zziz> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzja() {
        this(zzda.zzg(new zzjc()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zziz get() {
        return this.b.get();
    }
}
