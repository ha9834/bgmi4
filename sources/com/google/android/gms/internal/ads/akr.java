package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class akr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzr f1938a;
    private final zzy b;
    private final Runnable c;

    public akr(zzr zzrVar, zzy zzyVar, Runnable runnable) {
        this.f1938a = zzrVar;
        this.b = zzyVar;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1938a.isCanceled();
        if (this.b.zzbi == null) {
            this.f1938a.a((zzr) this.b.result);
        } else {
            this.f1938a.zzb(this.b.zzbi);
        }
        if (this.b.zzbj) {
            this.f1938a.zzb("intermediate-response");
        } else {
            this.f1938a.b("done");
        }
        Runnable runnable = this.c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
