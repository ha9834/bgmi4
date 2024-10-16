package com.devbrackets.android.exomedia.b;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected volatile boolean f1004a;
    protected int b;
    protected Handler c;
    protected HandlerThread d;
    protected boolean e;
    protected a f;
    protected b g;
    protected long h;
    protected long i;
    protected long j;
    protected float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j);
    }

    public e() {
        this(true);
    }

    public e(boolean z) {
        this.f1004a = false;
        this.b = 33;
        this.e = false;
        this.g = new b();
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 1.0f;
        if (z) {
            this.c = new Handler();
        } else {
            this.e = true;
        }
    }

    public void a(float f) {
        this.k = f;
    }

    public void a() {
        if (b()) {
            this.c.removeCallbacksAndMessages(null);
            HandlerThread handlerThread = this.d;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.j = this.i + this.j;
            this.f1004a = false;
            this.i = 0L;
        }
    }

    public boolean b() {
        return this.f1004a;
    }

    public long c() {
        return this.i + this.j;
    }

    /* loaded from: classes.dex */
    protected class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        protected long f1005a = 0;
        protected long b = -1;

        protected b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b == -1) {
                this.b = e.this.h;
            }
            this.f1005a = System.currentTimeMillis();
            e.this.i = ((float) r0.i) + (((float) (this.f1005a - this.b)) * e.this.k);
            this.b = this.f1005a;
            if (e.this.f1004a) {
                a();
            }
            if (e.this.f != null) {
                e.this.f.a(e.this.i + e.this.j);
            }
        }

        public void a() {
            e.this.c.postDelayed(e.this.g, e.this.b);
        }
    }
}
