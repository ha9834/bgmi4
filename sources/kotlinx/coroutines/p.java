package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes3.dex */
public final class p extends u implements Runnable {
    private static volatile Thread _thread;
    public static final p b;
    private static final long d;
    private static volatile int debugStatus;

    static {
        Long l;
        p pVar = new p();
        b = pVar;
        t.a(pVar, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        d = timeUnit.toNanos(l.longValue());
    }

    private p() {
    }

    @Override // kotlinx.coroutines.v
    protected Thread a() {
        Thread thread = _thread;
        return thread != null ? thread : l();
    }

    private final boolean k() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        boolean c;
        ae.f6990a.a(this);
        af a2 = ag.a();
        if (a2 != null) {
            a2.d();
        }
        try {
            if (!m()) {
                if (c) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long b2 = b();
                if (b2 == Long.MAX_VALUE) {
                    af a3 = ag.a();
                    long a4 = a3 != null ? a3.a() : System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = d + a4;
                    }
                    long j2 = j - a4;
                    if (j2 <= 0) {
                        _thread = (Thread) null;
                        n();
                        af a5 = ag.a();
                        if (a5 != null) {
                            a5.e();
                        }
                        if (c()) {
                            return;
                        }
                        a();
                        return;
                    }
                    b2 = kotlin.d.d.b(b2, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (b2 > 0) {
                    if (k()) {
                        _thread = (Thread) null;
                        n();
                        af a6 = ag.a();
                        if (a6 != null) {
                            a6.e();
                        }
                        if (c()) {
                            return;
                        }
                        a();
                        return;
                    }
                    af a7 = ag.a();
                    if (a7 != null) {
                        a7.a(this, b2);
                    } else {
                        LockSupport.parkNanos(this, b2);
                    }
                }
            }
        } finally {
            _thread = (Thread) null;
            n();
            af a8 = ag.a();
            if (a8 != null) {
                a8.e();
            }
            if (!c()) {
                a();
            }
        }
    }

    private final synchronized Thread l() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final synchronized boolean m() {
        if (k()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final synchronized void n() {
        if (k()) {
            debugStatus = 3;
            i();
            notifyAll();
        }
    }
}
