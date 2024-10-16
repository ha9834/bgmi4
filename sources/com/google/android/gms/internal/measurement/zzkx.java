package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkx implements zzdb<zzla> {

    /* renamed from: a, reason: collision with root package name */
    private static zzkx f4613a = new zzkx();
    private final zzdb<zzla> b;

    public static boolean zzzo() {
        return ((zzla) f4613a.get()).zzzo();
    }

    private zzkx(zzdb<zzla> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzkx() {
        this(zzda.zzg(new zzkz()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzla get() {
        return this.b.get();
    }
}
