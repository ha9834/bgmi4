package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class gl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f4886a;
    private final /* synthetic */ zziw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(zziw zziwVar, long j) {
        this.b = zziwVar;
        this.f4886a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.f4886a);
    }
}
