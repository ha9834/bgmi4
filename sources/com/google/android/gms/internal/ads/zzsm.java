package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzsm {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3732a;

    public final synchronized boolean zzjx() {
        if (this.f3732a) {
            return false;
        }
        this.f3732a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zzjy() {
        boolean z;
        z = this.f3732a;
        this.f3732a = false;
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void block() throws InterruptedException {
        while (!this.f3732a) {
            wait();
        }
    }
}
