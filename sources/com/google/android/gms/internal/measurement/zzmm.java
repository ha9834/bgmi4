package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzmm implements zzdb<zzml> {

    /* renamed from: a, reason: collision with root package name */
    private static zzmm f4641a = new zzmm();
    private final zzdb<zzml> b;

    public static boolean zzaao() {
        return ((zzml) f4641a.get()).zzaao();
    }

    private zzmm(zzdb<zzml> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzmm() {
        this(zzda.zzg(new zzmn()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzml get() {
        return this.b.get();
    }
}
