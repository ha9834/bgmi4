package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f1512a;
    private final int b;

    public a(Runnable runnable, int i) {
        this.f1512a = runnable;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.b);
        this.f1512a.run();
    }
}
