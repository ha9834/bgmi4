package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.http2.a;
import okhttp3.s;
import okio.p;
import okio.q;
import okio.r;

/* loaded from: classes.dex */
public final class g {
    static final /* synthetic */ boolean i = !g.class.desiredAssertionStatus();
    long b;
    final int c;
    final e d;
    final a e;
    private a.InterfaceC0231a k;
    private boolean l;
    private final b m;

    /* renamed from: a, reason: collision with root package name */
    long f7130a = 0;
    private final Deque<s> j = new ArrayDeque();
    final c f = new c();
    final c g = new c();
    ErrorCode h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i2, e eVar, boolean z, boolean z2, @Nullable s sVar) {
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.c = i2;
        this.d = eVar;
        this.b = eVar.k.d();
        this.m = new b(eVar.j.d());
        this.e = new a();
        this.m.b = z2;
        this.e.b = z;
        if (sVar != null) {
            this.j.add(sVar);
        }
        if (c() && sVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!c() && sVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public int a() {
        return this.c;
    }

    public synchronized boolean b() {
        if (this.h != null) {
            return false;
        }
        if ((this.m.b || this.m.f7132a) && (this.e.b || this.e.f7131a)) {
            if (this.l) {
                return false;
            }
        }
        return true;
    }

    public boolean c() {
        return this.d.f7113a == ((this.c & 1) == 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized s d() throws IOException {
        this.f.c();
        while (this.j.isEmpty() && this.h == null) {
            try {
                l();
            } catch (Throwable th) {
                this.f.b();
                throw th;
            }
        }
        this.f.b();
        if (!this.j.isEmpty()) {
        } else {
            throw new StreamResetException(this.h);
        }
        return this.j.removeFirst();
    }

    public r e() {
        return this.f;
    }

    public r f() {
        return this.g;
    }

    public q g() {
        return this.m;
    }

    public p h() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.e;
    }

    public void a(ErrorCode errorCode) throws IOException {
        if (d(errorCode)) {
            this.d.b(this.c, errorCode);
        }
    }

    public void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.d.a(this.c, errorCode);
        }
    }

    private boolean d(ErrorCode errorCode) {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.h != null) {
                return false;
            }
            if (this.m.b && this.e.b) {
                return false;
            }
            this.h = errorCode;
            notifyAll();
            this.d.b(this.c);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<okhttp3.internal.http2.a> list) {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.l = true;
            this.j.add(okhttp3.internal.c.b(list));
            b2 = b();
            notifyAll();
        }
        if (b2) {
            return;
        }
        this.d.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(okio.e eVar, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(eVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.m.b = true;
            b2 = b();
            notifyAll();
        }
        if (b2) {
            return;
        }
        this.d.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(ErrorCode errorCode) {
        if (this.h == null) {
            this.h = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class b implements q {
        static final /* synthetic */ boolean c = !g.class.desiredAssertionStatus();

        /* renamed from: a, reason: collision with root package name */
        boolean f7132a;
        boolean b;
        private final okio.c e = new okio.c();
        private final okio.c f = new okio.c();
        private final long g;

        b(long j) {
            this.g = j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00cb, code lost:
        
            if (r11 == (-1)) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00cd, code lost:
        
            a(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
        
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00d1, code lost:
        
            if (r0 != null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00d3, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
        
            throw new okhttp3.internal.http2.StreamResetException(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00e1, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // okio.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long a(okio.c r18, long r19) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 262
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.g.b.a(okio.c, long):long");
        }

        private void a(long j) {
            if (!c && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            g.this.d.a(j);
        }

        void a(okio.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            if (!c && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (g.this) {
                    z = this.b;
                    z2 = true;
                    z3 = this.f.b() + j > this.g;
                }
                if (z3) {
                    eVar.i(j);
                    g.this.b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.i(j);
                    return;
                }
                long a2 = eVar.a(this.e, j);
                if (a2 == -1) {
                    throw new EOFException();
                }
                j -= a2;
                synchronized (g.this) {
                    if (this.f7132a) {
                        j2 = this.e.b();
                        this.e.t();
                    } else {
                        if (this.f.b() != 0) {
                            z2 = false;
                        }
                        this.f.a((q) this.e);
                        if (z2) {
                            g.this.notifyAll();
                        }
                        j2 = 0;
                    }
                }
                if (j2 > 0) {
                    a(j2);
                }
            }
        }

        @Override // okio.q
        public r a() {
            return g.this.f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long b;
            ArrayList arrayList;
            a.InterfaceC0231a interfaceC0231a;
            synchronized (g.this) {
                this.f7132a = true;
                b = this.f.b();
                this.f.t();
                arrayList = null;
                if (g.this.j.isEmpty() || g.this.k == null) {
                    interfaceC0231a = null;
                } else {
                    arrayList = new ArrayList(g.this.j);
                    g.this.j.clear();
                    interfaceC0231a = g.this.k;
                }
                g.this.notifyAll();
            }
            if (b > 0) {
                a(b);
            }
            g.this.j();
            if (interfaceC0231a != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    interfaceC0231a.a((s) it.next());
                }
            }
        }
    }

    void j() throws IOException {
        boolean z;
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.m.b && this.m.f7132a && (this.e.b || this.e.f7131a);
            b2 = b();
        }
        if (z) {
            a(ErrorCode.CANCEL);
        } else {
            if (b2) {
                return;
            }
            this.d.b(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class a implements p {
        static final /* synthetic */ boolean c = !g.class.desiredAssertionStatus();

        /* renamed from: a, reason: collision with root package name */
        boolean f7131a;
        boolean b;
        private final okio.c e = new okio.c();

        a() {
        }

        @Override // okio.p
        public void a_(okio.c cVar, long j) throws IOException {
            if (!c && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            this.e.a_(cVar, j);
            while (this.e.b() >= 16384) {
                a(false);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void a(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.g.c();
                while (g.this.b <= 0 && !this.b && !this.f7131a && g.this.h == null) {
                    try {
                        g.this.l();
                    } finally {
                    }
                }
                g.this.g.b();
                g.this.k();
                min = Math.min(g.this.b, this.e.b());
                g.this.b -= min;
            }
            g.this.g.c();
            try {
                g.this.d.a(g.this.c, z && min == this.e.b(), this.e, min);
            } finally {
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // okio.p, java.io.Flushable
        public void flush() throws IOException {
            if (!c && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                g.this.k();
            }
            while (this.e.b() > 0) {
                a(false);
                g.this.d.b();
            }
        }

        @Override // okio.p
        public r a() {
            return g.this.g;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                if (this.f7131a) {
                    return;
                }
                if (!g.this.e.b) {
                    if (this.e.b() > 0) {
                        while (this.e.b() > 0) {
                            a(true);
                        }
                    } else {
                        g.this.d.a(g.this.c, true, (okio.c) null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f7131a = true;
                }
                g.this.d.b();
                g.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void k() throws IOException {
        if (this.e.f7131a) {
            throw new IOException("stream closed");
        }
        if (this.e.b) {
            throw new IOException("stream finished");
        }
        ErrorCode errorCode = this.h;
        if (errorCode != null) {
            throw new StreamResetException(errorCode);
        }
    }

    void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends okio.a {
        c() {
        }

        @Override // okio.a
        protected void a() {
            g.this.b(ErrorCode.CANCEL);
            g.this.d.d();
        }

        @Override // okio.a
        protected IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void b() throws IOException {
            if (f_()) {
                throw a((IOException) null);
            }
        }
    }
}
