package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkk implements zzdb<zzkj> {

    /* renamed from: a, reason: collision with root package name */
    private static zzkk f4604a = new zzkk();
    private final zzdb<zzkj> b;

    public static boolean zzzf() {
        return ((zzkj) f4604a.get()).zzzf();
    }

    public static boolean zzzg() {
        return ((zzkj) f4604a.get()).zzzg();
    }

    private zzkk(zzdb<zzkj> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzkk() {
        this(zzda.zzg(new zzkm()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkj get() {
        return this.b.get();
    }
}
