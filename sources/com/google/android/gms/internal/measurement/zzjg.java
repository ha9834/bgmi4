package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjg implements zzdb<zzjf> {

    /* renamed from: a, reason: collision with root package name */
    private static zzjg f4584a = new zzjg();
    private final zzdb<zzjf> b;

    public static boolean zzxi() {
        return ((zzjf) f4584a.get()).zzxi();
    }

    private zzjg(zzdb<zzjf> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzjg() {
        this(zzda.zzg(new zzji()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjf get() {
        return this.b.get();
    }
}
