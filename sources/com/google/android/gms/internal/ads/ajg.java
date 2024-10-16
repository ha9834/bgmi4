package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* loaded from: classes2.dex */
final class ajg {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1911a;
    private long b;
    private long c;

    public final void a() {
        if (this.f1911a) {
            return;
        }
        this.f1911a = true;
        this.c = b(this.b);
    }

    public final void b() {
        if (this.f1911a) {
            this.b = b(this.c);
            this.f1911a = false;
        }
    }

    public final void a(long j) {
        this.b = j;
        this.c = b(j);
    }

    public final long c() {
        return this.f1911a ? b(this.c) : this.b;
    }

    private static long b(long j) {
        return (SystemClock.elapsedRealtime() * 1000) - j;
    }
}
