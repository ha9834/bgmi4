package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzlj implements zzdb<zzlm> {

    /* renamed from: a, reason: collision with root package name */
    private static zzlj f4622a = new zzlj();
    private final zzdb<zzlm> b;

    public static boolean zzzw() {
        return ((zzlm) f4622a.get()).zzzw();
    }

    private zzlj(zzdb<zzlm> zzdbVar) {
        this.b = zzda.zza(zzdbVar);
    }

    public zzlj() {
        this(zzda.zzg(new zzll()));
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlm get() {
        return this.b.get();
    }
}
