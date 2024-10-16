package androidx.core.os;

import android.os.Build;
import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f570a;
    private a b;
    private Object c;
    private boolean d;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = this.f570a;
        }
        return z;
    }

    public void b() {
        synchronized (this) {
            if (this.f570a) {
                return;
            }
            this.f570a = true;
            this.d = true;
            a aVar = this.b;
            Object obj = this.c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.d = false;
                notifyAll();
            }
        }
    }

    public void a(a aVar) {
        synchronized (this) {
            c();
            if (this.b == aVar) {
                return;
            }
            this.b = aVar;
            if (this.f570a && aVar != null) {
                aVar.a();
            }
        }
    }

    private void c() {
        while (this.d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
