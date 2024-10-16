package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class ga implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzdx f4875a;
    private final /* synthetic */ zzin b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(zzin zzinVar, zzdx zzdxVar) {
        this.b = zzinVar;
        this.f4875a = zzdxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            zzin.a(this.b, false);
            if (!this.b.f4949a.isConnected()) {
                this.b.f4949a.zzab().zzgs().zzao("Connected to service");
                this.b.f4949a.a(this.f4875a);
            }
        }
    }
}
