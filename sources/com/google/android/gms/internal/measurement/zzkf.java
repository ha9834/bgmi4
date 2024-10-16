package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkf implements zzdb<zzki> {

    /* renamed from: a, reason: collision with root package name */
    private static zzkf f4601a = new zzkf();
    private final zzdb<zzki> b;

    public static boolean zzze() {
        return ((zzki) f4601a.get()).zzze();
    }

    private zzkf(zzdb<zzki> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzkf() {
        this(zzda.zzg(new zzkh()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzki get() {
        return this.b.get();
    }
}
