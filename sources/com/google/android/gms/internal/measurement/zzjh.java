package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjh implements zzdb<zzjk> {

    /* renamed from: a, reason: collision with root package name */
    private static zzjh f4585a = new zzjh();
    private final zzdb<zzjk> b;

    public static boolean zzxj() {
        return ((zzjk) f4585a.get()).zzxj();
    }

    public static boolean zzxk() {
        return ((zzjk) f4585a.get()).zzxk();
    }

    public static boolean zzxl() {
        return ((zzjk) f4585a.get()).zzxl();
    }

    private zzjh(zzdb<zzjk> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzjh() {
        this(zzda.zzg(new zzjj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjk get() {
        return this.b.get();
    }
}
