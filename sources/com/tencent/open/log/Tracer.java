package com.tencent.open.log;

import com.tencent.open.log.d;

/* loaded from: classes.dex */
public abstract class Tracer {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f6386a;
    private volatile boolean b;
    private g c;

    protected abstract void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th);

    public Tracer() {
        this(c.f6389a, true, g.f6393a);
    }

    public Tracer(int i, boolean z, g gVar) {
        this.f6386a = c.f6389a;
        this.b = true;
        this.c = g.f6393a;
        a(i);
        a(z);
        a(gVar);
    }

    public void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f6386a, i)) {
            doTrace(i, thread, j, str, str2, th);
        }
    }

    public void a(int i) {
        this.f6386a = i;
    }

    public boolean d() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public g e() {
        return this.c;
    }

    public void a(g gVar) {
        this.c = gVar;
    }
}
