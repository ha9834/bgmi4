package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjt implements zzdb<zzjw> {

    /* renamed from: a, reason: collision with root package name */
    private static zzjt f4593a = new zzjt();
    private final zzdb<zzjw> b;

    public static boolean zzyy() {
        return ((zzjw) f4593a.get()).zzyy();
    }

    private zzjt(zzdb<zzjw> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzjt() {
        this(zzda.zzg(new zzjv()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjw get() {
        return this.b.get();
    }
}
