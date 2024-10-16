package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjs implements zzdb<zzjr> {

    /* renamed from: a, reason: collision with root package name */
    private static zzjs f4592a = new zzjs();
    private final zzdb<zzjr> b;

    public static boolean zzyx() {
        return ((zzjr) f4592a.get()).zzyx();
    }

    private zzjs(zzdb<zzjr> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzjs() {
        this(zzda.zzg(new zzju()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjr get() {
        return this.b.get();
    }
}
