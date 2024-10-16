package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f4850a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(zzgp zzgpVar, long j) {
        this.b = zzgpVar;
        this.f4850a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.zzac().k.set(this.f4850a);
        this.b.zzab().zzgr().zza("Minimum session duration set", Long.valueOf(this.f4850a));
    }
}
