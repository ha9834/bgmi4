package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ez implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f4848a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(zzgp zzgpVar, long j) {
        this.b = zzgpVar;
        this.f4848a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.zzac().l.set(this.f4848a);
        this.b.zzab().zzgr().zza("Session timeout duration set", Long.valueOf(this.f4848a));
    }
}
