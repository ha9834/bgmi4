package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzmh implements zzdb<zzmk> {

    /* renamed from: a, reason: collision with root package name */
    private static zzmh f4638a = new zzmh();
    private final zzdb<zzmk> b;

    public static boolean zzaan() {
        return ((zzmk) f4638a.get()).zzaan();
    }

    private zzmh(zzdb<zzmk> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzmh() {
        this(zzda.zzg(new zzmj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzmk get() {
        return this.b.get();
    }
}
