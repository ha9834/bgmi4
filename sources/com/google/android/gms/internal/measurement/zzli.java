package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzli implements zzdb<zzlh> {

    /* renamed from: a, reason: collision with root package name */
    private static zzli f4621a = new zzli();
    private final zzdb<zzlh> b;

    public static boolean zzzv() {
        return ((zzlh) f4621a.get()).zzzv();
    }

    private zzli(zzdb<zzlh> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzli() {
        this(zzda.zzg(new zzlk()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlh get() {
        return this.b.get();
    }
}
