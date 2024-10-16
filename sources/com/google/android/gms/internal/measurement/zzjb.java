package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzjb implements zzdb<zzje> {

    /* renamed from: a, reason: collision with root package name */
    private static zzjb f4581a = new zzjb();
    private final zzdb<zzje> b;

    public static boolean zzxh() {
        return ((zzje) f4581a.get()).zzxh();
    }

    private zzjb(zzdb<zzje> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzjb() {
        this(zzda.zzg(new zzjd()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzje get() {
        return this.b.get();
    }
}
