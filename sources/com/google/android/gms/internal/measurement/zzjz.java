package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjz implements zzdb<zzkc> {

    /* renamed from: a, reason: collision with root package name */
    private static zzjz f4597a = new zzjz();
    private final zzdb<zzkc> b;

    public static boolean zzza() {
        return ((zzkc) f4597a.get()).zzza();
    }

    public static boolean zzzb() {
        return ((zzkc) f4597a.get()).zzzb();
    }

    public static boolean zzzc() {
        return ((zzkc) f4597a.get()).zzzc();
    }

    private zzjz(zzdb<zzkc> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzjz() {
        this(zzda.zzg(new zzkb()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkc get() {
        return this.b.get();
    }
}
