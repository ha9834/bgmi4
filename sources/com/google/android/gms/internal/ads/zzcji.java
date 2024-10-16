package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcji {

    /* renamed from: a, reason: collision with root package name */
    private int f3283a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private final Object e = new Object();
    private final Object f = new Object();
    private final Object g = new Object();
    private final Object h = new Object();

    public final void zzdo(int i) {
        synchronized (this.e) {
            this.f3283a = i;
        }
    }

    public final int getResponseCode() {
        int i;
        synchronized (this.e) {
            i = this.f3283a;
        }
        return i;
    }

    public final void zzeu(long j) {
        synchronized (this.f) {
            this.b = j;
        }
    }

    public final long zzakl() {
        long j;
        synchronized (this.f) {
            j = this.b;
        }
        return j;
    }

    public final synchronized void zzfh(long j) {
        synchronized (this.g) {
            this.c = j;
        }
    }

    public final synchronized long zzakm() {
        long j;
        synchronized (this.g) {
            j = this.c;
        }
        return j;
    }

    public final synchronized void zzev(long j) {
        synchronized (this.h) {
            this.d = j;
        }
    }

    public final synchronized long zzakn() {
        long j;
        synchronized (this.h) {
            j = this.d;
        }
        return j;
    }
}
