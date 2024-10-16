package com.devbrackets.android.exomedia.b;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected volatile boolean f1002a;
    protected int b;
    protected Handler c;
    protected HandlerThread d;
    protected boolean e;
    protected b f;
    protected a g;

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public c() {
        this(true);
    }

    public c(boolean z) {
        this.f1002a = false;
        this.b = 33;
        this.e = false;
        this.g = new a();
        if (z) {
            this.c = new Handler();
        } else {
            this.e = true;
        }
    }

    public void a(int i) {
        this.b = i;
    }

    public void a() {
        if (this.f1002a) {
            return;
        }
        this.f1002a = true;
        if (this.e) {
            this.d = new HandlerThread("ExoMedia_Repeater_HandlerThread");
            this.d.start();
            this.c = new Handler(this.d.getLooper());
        }
        this.g.a();
    }

    public void b() {
        HandlerThread handlerThread = this.d;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.f1002a = false;
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    /* loaded from: classes.dex */
    protected class a implements Runnable {
        protected a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f != null) {
                c.this.f.a();
            }
            if (c.this.f1002a) {
                a();
            }
        }

        public void a() {
            c.this.c.postDelayed(c.this.g, c.this.b);
        }
    }
}
