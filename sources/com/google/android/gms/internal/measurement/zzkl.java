package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkl implements zzdb<zzko> {

    /* renamed from: a, reason: collision with root package name */
    private static zzkl f4605a = new zzkl();
    private final zzdb<zzko> b;

    public static boolean zzzh() {
        return ((zzko) f4605a.get()).zzzh();
    }

    private zzkl(zzdb<zzko> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzkl() {
        this(zzda.zzg(new zzkn()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzko get() {
        return this.b.get();
    }
}
