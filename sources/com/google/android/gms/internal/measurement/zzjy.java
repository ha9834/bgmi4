package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjy implements zzdb<zzjx> {

    /* renamed from: a, reason: collision with root package name */
    private static zzjy f4596a = new zzjy();
    private final zzdb<zzjx> b;

    public static boolean zzyz() {
        return ((zzjx) f4596a.get()).zzyz();
    }

    private zzjy(zzdb<zzjx> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzjy() {
        this(zzda.zzg(new zzka()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjx get() {
        return this.b.get();
    }
}
