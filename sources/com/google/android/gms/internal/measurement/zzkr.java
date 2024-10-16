package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkr implements zzdb<zzku> {

    /* renamed from: a, reason: collision with root package name */
    private static zzkr f4609a = new zzkr();
    private final zzdb<zzku> b;

    public static boolean zzzj() {
        return ((zzku) f4609a.get()).zzzj();
    }

    public static boolean zzzk() {
        return ((zzku) f4609a.get()).zzzk();
    }

    public static boolean zzzl() {
        return ((zzku) f4609a.get()).zzzl();
    }

    private zzkr(zzdb<zzku> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzkr() {
        this(zzda.zzg(new zzkt()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzku get() {
        return this.b.get();
    }
}
