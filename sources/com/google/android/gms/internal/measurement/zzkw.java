package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkw implements zzdb<zzkv> {

    /* renamed from: a, reason: collision with root package name */
    private static zzkw f4612a = new zzkw();
    private final zzdb<zzkv> b;

    public static boolean zzzm() {
        return ((zzkv) f4612a.get()).zzzm();
    }

    public static boolean zzzn() {
        return ((zzkv) f4612a.get()).zzzn();
    }

    private zzkw(zzdb<zzkv> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzkw() {
        this(zzda.zzg(new zzky()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkv get() {
        return this.b.get();
    }
}
