package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

@zzard
/* loaded from: classes2.dex */
public final class zzazg {

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f2836a = null;
    private Handler b = null;
    private int c = 0;
    private final Object d = new Object();

    public final Looper zzwr() {
        Looper looper;
        synchronized (this.d) {
            if (this.c == 0) {
                if (this.f2836a == null) {
                    zzawz.zzds("Starting the looper thread.");
                    this.f2836a = new HandlerThread("LooperProvider");
                    this.f2836a.start();
                    this.b = new zzdbh(this.f2836a.getLooper());
                    zzawz.zzds("Looper thread started.");
                } else {
                    zzawz.zzds("Resuming the looper thread");
                    this.d.notifyAll();
                }
            } else {
                Preconditions.checkNotNull(this.f2836a, "Invalid state: mHandlerThread should already been initialized.");
            }
            this.c++;
            looper = this.f2836a.getLooper();
        }
        return looper;
    }

    public final Handler getHandler() {
        return this.b;
    }
}
