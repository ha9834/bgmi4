package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class a extends r {

    @Nullable
    static a b;
    private boolean e;

    @Nullable
    private a f;
    private long g;

    /* renamed from: a, reason: collision with root package name */
    private static final long f7171a = TimeUnit.SECONDS.toMillis(60);
    private static final long d = TimeUnit.MILLISECONDS.toNanos(f7171a);

    protected void a() {
    }

    public final void c() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long i_ = i_();
        boolean g_ = g_();
        if (i_ != 0 || g_) {
            this.e = true;
            a(this, i_, g_);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (b == null) {
                b = new a();
                new C0234a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.g = Math.min(j, aVar.d() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.g = j + nanoTime;
            } else if (z) {
                aVar.g = aVar.d();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = b;
            while (aVar2.f != null && b2 >= aVar2.f.b(nanoTime)) {
                aVar2 = aVar2.f;
            }
            aVar.f = aVar2.f;
            aVar2.f = aVar;
            if (aVar2 == b) {
                a.class.notify();
            }
        }
    }

    public final boolean f_() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = b; aVar2 != null; aVar2 = aVar2.f) {
                if (aVar2.f == aVar) {
                    aVar2.f = aVar.f;
                    aVar.f = null;
                    return false;
                }
            }
            return true;
        }
    }

    private long b(long j) {
        return this.g - j;
    }

    public final p a(final p pVar) {
        return new p() { // from class: okio.a.1
            @Override // okio.p
            public void a_(c cVar, long j) throws IOException {
                s.a(cVar.b, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    n nVar = cVar.f7175a;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += nVar.c - nVar.b;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        nVar = nVar.f;
                    }
                    a.this.c();
                    try {
                        try {
                            pVar.a_(cVar, j2);
                            j -= j2;
                            a.this.a(true);
                        } catch (IOException e) {
                            throw a.this.b(e);
                        }
                    } catch (Throwable th) {
                        a.this.a(false);
                        throw th;
                    }
                }
            }

            @Override // okio.p, java.io.Flushable
            public void flush() throws IOException {
                a.this.c();
                try {
                    try {
                        pVar.flush();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.c();
                try {
                    try {
                        pVar.close();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // okio.p
            public r a() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + pVar + ")";
            }
        };
    }

    public final q a(final q qVar) {
        return new q() { // from class: okio.a.2
            @Override // okio.q
            public long a(c cVar, long j) throws IOException {
                a.this.c();
                try {
                    try {
                        long a2 = qVar.a(cVar, j);
                        a.this.a(true);
                        return a2;
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        qVar.close();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // okio.q
            public r a() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + qVar + ")";
            }
        };
    }

    final void a(boolean z) throws IOException {
        if (f_() && z) {
            throw a((IOException) null);
        }
    }

    final IOException b(IOException iOException) throws IOException {
        return !f_() ? iOException : a(iOException);
    }

    protected IOException a(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: okio.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0234a extends Thread {
        C0234a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0015, code lost:
        
            r1.a();
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<okio.a> r0 = okio.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                okio.a r1 = okio.a.e()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                okio.a r2 = okio.a.b     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                okio.a.b = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.a()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.a.C0234a.run():void");
        }
    }

    @Nullable
    static a e() throws InterruptedException {
        a aVar = b.f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f7171a);
            if (b.f != null || System.nanoTime() - nanoTime < d) {
                return null;
            }
            return b;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j = b2 / 1000000;
            a.class.wait(j, (int) (b2 - (1000000 * j)));
            return null;
        }
        b.f = aVar.f;
        aVar.f = null;
        return aVar;
    }
}
