package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjm implements zzdb<zzjl> {

    /* renamed from: a, reason: collision with root package name */
    private static zzjm f4588a = new zzjm();
    private final zzdb<zzjl> b;

    public static boolean zzxm() {
        return ((zzjl) f4588a.get()).zzxm();
    }

    private zzjm(zzdb<zzjl> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzjm() {
        this(zzda.zzg(new zzjo()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjl get() {
        return this.b.get();
    }
}
