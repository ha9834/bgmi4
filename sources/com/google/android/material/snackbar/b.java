package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f5331a;
    private final Object b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.a((C0120b) message.obj);
            return true;
        }
    });
    private C0120b d;
    private C0120b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a() {
        if (f5331a == null) {
            f5331a = new b();
        }
        return f5331a;
    }

    private b() {
    }

    public void a(int i, a aVar) {
        synchronized (this.b) {
            if (g(aVar)) {
                this.d.b = i;
                this.c.removeCallbacksAndMessages(this.d);
                b(this.d);
                return;
            }
            if (h(aVar)) {
                this.e.b = i;
            } else {
                this.e = new C0120b(i, aVar);
            }
            if (this.d == null || !a(this.d, 4)) {
                this.d = null;
                b();
            }
        }
    }

    public void a(a aVar, int i) {
        synchronized (this.b) {
            if (g(aVar)) {
                a(this.d, i);
            } else if (h(aVar)) {
                a(this.e, i);
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.b) {
            if (g(aVar)) {
                this.d = null;
                if (this.e != null) {
                    b();
                }
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.b) {
            if (g(aVar)) {
                b(this.d);
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.b) {
            if (g(aVar) && !this.d.c) {
                this.d.c = true;
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.b) {
            if (g(aVar) && this.d.c) {
                this.d.c = false;
                b(this.d);
            }
        }
    }

    public boolean e(a aVar) {
        boolean g;
        synchronized (this.b) {
            g = g(aVar);
        }
        return g;
    }

    public boolean f(a aVar) {
        boolean z;
        synchronized (this.b) {
            z = g(aVar) || h(aVar);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0120b {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<a> f5333a;
        int b;
        boolean c;

        C0120b(int i, a aVar) {
            this.f5333a = new WeakReference<>(aVar);
            this.b = i;
        }

        boolean a(a aVar) {
            return aVar != null && this.f5333a.get() == aVar;
        }
    }

    private void b() {
        C0120b c0120b = this.e;
        if (c0120b != null) {
            this.d = c0120b;
            this.e = null;
            a aVar = this.d.f5333a.get();
            if (aVar != null) {
                aVar.a();
            } else {
                this.d = null;
            }
        }
    }

    private boolean a(C0120b c0120b, int i) {
        a aVar = c0120b.f5333a.get();
        if (aVar == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(c0120b);
        aVar.a(i);
        return true;
    }

    private boolean g(a aVar) {
        C0120b c0120b = this.d;
        return c0120b != null && c0120b.a(aVar);
    }

    private boolean h(a aVar) {
        C0120b c0120b = this.e;
        return c0120b != null && c0120b.a(aVar);
    }

    private void b(C0120b c0120b) {
        if (c0120b.b == -2) {
            return;
        }
        int i = 2750;
        if (c0120b.b > 0) {
            i = c0120b.b;
        } else if (c0120b.b == -1) {
            i = 1500;
        }
        this.c.removeCallbacksAndMessages(c0120b);
        Handler handler = this.c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, c0120b), i);
    }

    void a(C0120b c0120b) {
        synchronized (this.b) {
            if (this.d == c0120b || this.e == c0120b) {
                a(c0120b, 2);
            }
        }
    }
}
