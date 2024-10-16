package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class gm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f4887a;
    private final /* synthetic */ zziw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gm(zziw zziwVar, long j) {
        this.b = zziwVar;
        this.f4887a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f4887a);
    }
}
