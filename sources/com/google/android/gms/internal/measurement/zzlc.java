package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlc implements zzdb<zzlb> {

    /* renamed from: a, reason: collision with root package name */
    private static zzlc f4617a = new zzlc();
    private final zzdb<zzlb> b;

    public static boolean zzzp() {
        return ((zzlb) f4617a.get()).zzzp();
    }

    private zzlc(zzdb<zzlb> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzlc() {
        this(zzda.zzg(new zzle()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlb get() {
        return this.b.get();
    }
}
