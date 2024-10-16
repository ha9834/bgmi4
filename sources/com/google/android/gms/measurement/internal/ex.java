package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ex implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4846a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(zzgp zzgpVar, boolean z) {
        this.b = zzgpVar;
        this.f4846a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean isEnabled = this.b.v.isEnabled();
        boolean zzib = this.b.v.zzib();
        this.b.v.a(this.f4846a);
        if (zzib == this.f4846a) {
            this.b.v.zzab().zzgs().zza("Default data collection state already set to", Boolean.valueOf(this.f4846a));
        }
        if (this.b.v.isEnabled() == isEnabled || this.b.v.isEnabled() != this.b.v.zzib()) {
            this.b.v.zzab().zzgp().zza("Default data collection is different than actual status", Boolean.valueOf(this.f4846a), Boolean.valueOf(isEnabled));
        }
        this.b.c();
    }
}
