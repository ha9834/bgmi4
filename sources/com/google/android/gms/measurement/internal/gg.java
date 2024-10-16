package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class gg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzjg f4881a;
    private final /* synthetic */ Runnable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(zzit zzitVar, zzjg zzjgVar, Runnable runnable) {
        this.f4881a = zzjgVar;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4881a.d();
        this.f4881a.a(this.b);
        this.f4881a.c();
    }
}
