package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkq implements zzdb<zzkp> {

    /* renamed from: a, reason: collision with root package name */
    private static zzkq f4608a = new zzkq();
    private final zzdb<zzkp> b;

    public static boolean zzzi() {
        return ((zzkp) f4608a.get()).zzzi();
    }

    private zzkq(zzdb<zzkp> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzkq() {
        this(zzda.zzg(new zzks()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkp get() {
        return this.b.get();
    }
}
