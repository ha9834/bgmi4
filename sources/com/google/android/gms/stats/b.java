package com.google.android.gms.stats;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ WakeLock f5060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WakeLock wakeLock) {
        this.f5060a = wakeLock;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5060a.a(0);
    }
}
