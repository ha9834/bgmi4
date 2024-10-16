package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzmg implements zzdb<zzmf> {

    /* renamed from: a, reason: collision with root package name */
    private static zzmg f4637a = new zzmg();
    private final zzdb<zzmf> b;

    public static boolean zzaam() {
        return ((zzmf) f4637a.get()).zzaam();
    }

    private zzmg(zzdb<zzmf> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzmg() {
        this(zzda.zzg(new zzmi()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzmf get() {
        return this.b.get();
    }
}
