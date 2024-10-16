package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class cq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f4790a;
    private final /* synthetic */ zza b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(zza zzaVar, long j) {
        this.b = zzaVar;
        this.f4790a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f4790a);
    }
}
