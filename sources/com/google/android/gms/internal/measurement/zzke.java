package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzke implements zzdb<zzkd> {

    /* renamed from: a, reason: collision with root package name */
    private static zzke f4600a = new zzke();
    private final zzdb<zzkd> b;

    public static boolean zzzd() {
        return ((zzkd) f4600a.get()).zzzd();
    }

    private zzke(zzdb<zzkd> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzke() {
        this(zzda.zzg(new zzkg()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkd get() {
        return this.b.get();
    }
}
