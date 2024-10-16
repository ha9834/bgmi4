package okhttp3.internal.http2;

import com.google.android.gms.games.request.GameRequest;
import com.tencent.mtt.spcialcall.SpecialCallActivity;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.f;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class e implements Closeable {
    static final /* synthetic */ boolean p = !e.class.desiredAssertionStatus();
    private static final ExecutorService q = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp Http2Connection", true));

    /* renamed from: a, reason: collision with root package name */
    final boolean f7113a;
    final c b;
    final String d;
    int e;
    int f;
    final j g;
    long i;
    final Socket l;
    final h m;
    final C0233e n;
    private boolean r;
    private final ScheduledExecutorService s;
    private final ExecutorService t;
    final Map<Integer, g> c = new LinkedHashMap();
    private long u = 0;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private long y = 0;
    private long z = 0;
    private long A = 0;
    long h = 0;
    k j = new k();
    final k k = new k();
    final Set<Integer> o = new LinkedHashSet();

    /* loaded from: classes.dex */
    public static abstract class c {
        public static final c f = new c() { // from class: okhttp3.internal.http2.e.c.1
            @Override // okhttp3.internal.http2.e.c
            public void a(g gVar) throws IOException {
                gVar.a(ErrorCode.REFUSED_STREAM);
            }
        };

        public void a(e eVar) {
        }

        public abstract void a(g gVar) throws IOException;
    }

    boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    static /* synthetic */ long d(e eVar) {
        long j = eVar.u;
        eVar.u = 1 + j;
        return j;
    }

    static /* synthetic */ long g(e eVar) {
        long j = eVar.v;
        eVar.v = 1 + j;
        return j;
    }

    static /* synthetic */ long h(e eVar) {
        long j = eVar.x;
        eVar.x = 1 + j;
        return j;
    }

    static /* synthetic */ long i(e eVar) {
        long j = eVar.z;
        eVar.z = 1 + j;
        return j;
    }

    e(a aVar) {
        this.g = aVar.f;
        this.f7113a = aVar.g;
        this.b = aVar.e;
        this.f = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.f += 2;
        }
        if (aVar.g) {
            this.j.a(7, SpecialCallActivity.FLAG_HARDWARE_ACCELERATED);
        }
        this.d = aVar.b;
        this.s = new ScheduledThreadPoolExecutor(1, okhttp3.internal.c.a(okhttp3.internal.c.a("OkHttp %s Writer", this.d), false));
        if (aVar.h != 0) {
            this.s.scheduleAtFixedRate(new b(), aVar.h, aVar.h, TimeUnit.MILLISECONDS);
        }
        this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.a(okhttp3.internal.c.a("OkHttp %s Push Observer", this.d), true));
        this.k.a(7, GameRequest.TYPE_ALL);
        this.k.a(5, 16384);
        this.i = this.k.d();
        this.l = aVar.f7121a;
        this.m = new h(aVar.d, this.f7113a);
        this.n = new C0233e(new f(aVar.c, this.f7113a));
    }

    synchronized g a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized g b(int i) {
        g remove;
        remove = this.c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int a() {
        return this.k.c(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(long j) {
        this.h += j;
        if (this.h >= this.j.d() / 2) {
            a(0, this.h);
            this.h = 0L;
        }
    }

    public g a(List<okhttp3.internal.http2.a> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0075, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x002b, B:15:0x0033, B:19:0x003d, B:21:0x0043, B:22:0x004c, B:36:0x006f, B:37:0x0074), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private okhttp3.internal.http2.g b(int r11, java.util.List<okhttp3.internal.http2.a> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.h r7 = r10.m
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L78
            int r0 = r10.f     // Catch: java.lang.Throwable -> L75
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L75
            r10.a(r0)     // Catch: java.lang.Throwable -> L75
        L13:
            boolean r0 = r10.r     // Catch: java.lang.Throwable -> L75
            if (r0 != 0) goto L6f
            int r8 = r10.f     // Catch: java.lang.Throwable -> L75
            int r0 = r10.f     // Catch: java.lang.Throwable -> L75
            int r0 = r0 + 2
            r10.f = r0     // Catch: java.lang.Throwable -> L75
            okhttp3.internal.http2.g r9 = new okhttp3.internal.http2.g     // Catch: java.lang.Throwable -> L75
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L75
            if (r13 == 0) goto L3c
            long r0 = r10.i     // Catch: java.lang.Throwable -> L75
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3c
            long r0 = r9.b     // Catch: java.lang.Throwable -> L75
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L3a
            goto L3c
        L3a:
            r13 = 0
            goto L3d
        L3c:
            r13 = 1
        L3d:
            boolean r0 = r9.b()     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L4c
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r0 = r10.c     // Catch: java.lang.Throwable -> L75
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L75
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L75
        L4c:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            if (r11 != 0) goto L55
            okhttp3.internal.http2.h r0 = r10.m     // Catch: java.lang.Throwable -> L78
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L78
            goto L5e
        L55:
            boolean r0 = r10.f7113a     // Catch: java.lang.Throwable -> L78
            if (r0 != 0) goto L67
            okhttp3.internal.http2.h r0 = r10.m     // Catch: java.lang.Throwable -> L78
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L78
        L5e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            if (r13 == 0) goto L66
            okhttp3.internal.http2.h r11 = r10.m
            r11.b()
        L66:
            return r9
        L67:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L78
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L78
            throw r11     // Catch: java.lang.Throwable -> L78
        L6f:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L75
            r11.<init>()     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L75
        L75:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L78
        L78:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.b(int, java.util.List, boolean):okhttp3.internal.http2.g");
    }

    public void a(int i, boolean z, okio.c cVar, long j) throws IOException {
        int min;
        long j2;
        if (j == 0) {
            this.m.a(z, i, cVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.i <= 0) {
                    try {
                        if (!this.c.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.i), this.m.c());
                j2 = min;
                this.i -= j2;
            }
            j -= j2;
            this.m.a(z && j == 0, i, cVar, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final ErrorCode errorCode) {
        try {
            this.s.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.1
                @Override // okhttp3.internal.b
                public void c() {
                    try {
                        e.this.b(i, errorCode);
                    } catch (IOException unused) {
                        e.this.f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, ErrorCode errorCode) throws IOException {
        this.m.a(i, errorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        try {
            this.s.execute(new okhttp3.internal.b("OkHttp Window Update %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.2
                @Override // okhttp3.internal.b
                public void c() {
                    try {
                        e.this.m.a(i, j);
                    } catch (IOException unused) {
                        e.this.f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* loaded from: classes3.dex */
    final class d extends okhttp3.internal.b {

        /* renamed from: a, reason: collision with root package name */
        final boolean f7123a;
        final int b;
        final int d;

        d(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", e.this.d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f7123a = z;
            this.b = i;
            this.d = i2;
        }

        @Override // okhttp3.internal.b
        public void c() {
            e.this.a(this.f7123a, this.b, this.d);
        }
    }

    /* loaded from: classes3.dex */
    final class b extends okhttp3.internal.b {
        b() {
            super("OkHttp %s ping", e.this.d);
        }

        @Override // okhttp3.internal.b
        public void c() {
            boolean z;
            synchronized (e.this) {
                if (e.this.v < e.this.u) {
                    z = true;
                } else {
                    e.d(e.this);
                    z = false;
                }
            }
            if (z) {
                e.this.f();
            } else {
                e.this.a(false, 1, 0);
            }
        }
    }

    void a(boolean z, int i, int i2) {
        try {
            this.m.a(z, i, i2);
        } catch (IOException unused) {
            f();
        }
    }

    public void b() throws IOException {
        this.m.b();
    }

    public void a(ErrorCode errorCode) throws IOException {
        synchronized (this.m) {
            synchronized (this) {
                if (this.r) {
                    return;
                }
                this.r = true;
                this.m.a(this.e, errorCode, okhttp3.internal.c.f7078a);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        if (!p && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        g[] gVarArr = null;
        try {
            a(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.c.isEmpty()) {
                gVarArr = (g[]) this.c.values().toArray(new g[this.c.size()]);
                this.c.clear();
            }
        }
        if (gVarArr != null) {
            for (g gVar : gVarArr) {
                try {
                    gVar.a(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.m.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.l.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.s.shutdown();
        this.t.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    public void c() throws IOException {
        a(true);
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.m.a();
            this.m.b(this.j);
            if (this.j.d() != 65535) {
                this.m.a(0, r6 - GameRequest.TYPE_ALL);
            }
        }
        new Thread(this.n).start();
    }

    public synchronized boolean b(long j) {
        if (this.r) {
            return false;
        }
        if (this.x < this.w) {
            if (j >= this.A) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        synchronized (this) {
            if (this.x < this.w) {
                return;
            }
            this.w++;
            this.A = System.nanoTime() + 1000000000;
            try {
                this.s.execute(new okhttp3.internal.b("OkHttp %s ping", this.d) { // from class: okhttp3.internal.http2.e.3
                    @Override // okhttp3.internal.b
                    public void c() {
                        e.this.a(false, 2, 0);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Socket f7121a;
        String b;
        okio.e c;
        okio.d d;
        c e = c.f;
        j f = j.f7137a;
        boolean g;
        int h;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, okio.e eVar, okio.d dVar) {
            this.f7121a = socket;
            this.b = str;
            this.c = eVar;
            this.d = dVar;
            return this;
        }

        public a a(c cVar) {
            this.e = cVar;
            return this;
        }

        public a a(int i) {
            this.h = i;
            return this;
        }

        public e a() {
            return new e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: okhttp3.internal.http2.e$e, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0233e extends okhttp3.internal.b implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final f f7124a;

        @Override // okhttp3.internal.http2.f.b
        public void a() {
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        C0233e(f fVar) {
            super("OkHttp %s", e.this.d);
            this.f7124a = fVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // okhttp3.internal.b
        protected void c() {
            e eVar;
            ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f7124a.a(this);
                        do {
                        } while (this.f7124a.a(false, (f.b) this));
                        errorCode = ErrorCode.NO_ERROR;
                        errorCode2 = ErrorCode.CANCEL;
                        eVar = e.this;
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    eVar = e.this;
                }
                eVar.a(errorCode, errorCode2);
                okhttp3.internal.c.a(this.f7124a);
            } catch (Throwable th) {
                try {
                    e.this.a(errorCode, errorCode2);
                } catch (IOException unused3) {
                }
                okhttp3.internal.c.a(this.f7124a);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(boolean z, int i, okio.e eVar, int i2) throws IOException {
            if (e.this.c(i)) {
                e.this.a(i, eVar, i2, z);
                return;
            }
            g a2 = e.this.a(i);
            if (a2 == null) {
                e.this.a(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                e.this.a(j);
                eVar.i(j);
                return;
            }
            a2.a(eVar, i2);
            if (z) {
                a2.i();
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(boolean z, int i, int i2, List<okhttp3.internal.http2.a> list) {
            if (e.this.c(i)) {
                e.this.a(i, list, z);
                return;
            }
            synchronized (e.this) {
                g a2 = e.this.a(i);
                if (a2 == null) {
                    if (e.this.r) {
                        return;
                    }
                    if (i <= e.this.e) {
                        return;
                    }
                    if (i % 2 == e.this.f % 2) {
                        return;
                    }
                    final g gVar = new g(i, e.this, false, z, okhttp3.internal.c.b(list));
                    e.this.e = i;
                    e.this.c.put(Integer.valueOf(i), gVar);
                    e.q.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[]{e.this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.e.1
                        @Override // okhttp3.internal.b
                        public void c() {
                            try {
                                e.this.b.a(gVar);
                            } catch (IOException e) {
                                okhttp3.internal.e.g.e().a(4, "Http2Connection.Listener failure for " + e.this.d, e);
                                try {
                                    gVar.a(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                a2.a(list);
                if (z) {
                    a2.i();
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, ErrorCode errorCode) {
            if (e.this.c(i)) {
                e.this.c(i, errorCode);
                return;
            }
            g b = e.this.b(i);
            if (b != null) {
                b.c(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(final boolean z, final k kVar) {
            try {
                e.this.s.execute(new okhttp3.internal.b("OkHttp %s ACK Settings", new Object[]{e.this.d}) { // from class: okhttp3.internal.http2.e.e.2
                    @Override // okhttp3.internal.b
                    public void c() {
                        C0233e.this.b(z, kVar);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void b(boolean z, k kVar) {
            g[] gVarArr;
            long j;
            synchronized (e.this.m) {
                synchronized (e.this) {
                    int d = e.this.k.d();
                    if (z) {
                        e.this.k.a();
                    }
                    e.this.k.a(kVar);
                    int d2 = e.this.k.d();
                    gVarArr = null;
                    if (d2 == -1 || d2 == d) {
                        j = 0;
                    } else {
                        j = d2 - d;
                        if (!e.this.c.isEmpty()) {
                            gVarArr = (g[]) e.this.c.values().toArray(new g[e.this.c.size()]);
                        }
                    }
                }
                try {
                    e.this.m.a(e.this.k);
                } catch (IOException unused) {
                    e.this.f();
                }
            }
            if (gVarArr != null) {
                for (g gVar : gVarArr) {
                    synchronized (gVar) {
                        gVar.a(j);
                    }
                }
            }
            e.q.execute(new okhttp3.internal.b("OkHttp %s settings", e.this.d) { // from class: okhttp3.internal.http2.e.e.3
                @Override // okhttp3.internal.b
                public void c() {
                    e.this.b.a(e.this);
                }
            });
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    e.this.s.execute(new d(true, i, i2));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (e.this) {
                try {
                    if (i == 1) {
                        e.g(e.this);
                    } else if (i == 2) {
                        e.h(e.this);
                    } else if (i == 3) {
                        e.i(e.this);
                        e.this.notifyAll();
                    }
                } finally {
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // okhttp3.internal.http2.f.b
        public void a(int i, ErrorCode errorCode, ByteString byteString) {
            g[] gVarArr;
            byteString.g();
            synchronized (e.this) {
                gVarArr = (g[]) e.this.c.values().toArray(new g[e.this.c.size()]);
                e.this.r = true;
            }
            for (g gVar : gVarArr) {
                if (gVar.a() > i && gVar.c()) {
                    gVar.c(ErrorCode.REFUSED_STREAM);
                    e.this.b(gVar.a());
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (e.this) {
                    e.this.i += j;
                    e.this.notifyAll();
                }
                return;
            }
            g a2 = e.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, int i2, List<okhttp3.internal.http2.a> list) {
            e.this.a(i2, list);
        }
    }

    void a(final int i, final List<okhttp3.internal.http2.a> list) {
        synchronized (this) {
            if (this.o.contains(Integer.valueOf(i))) {
                a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.o.add(Integer.valueOf(i));
            try {
                a(new okhttp3.internal.b("OkHttp %s Push Request[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.4
                    @Override // okhttp3.internal.b
                    public void c() {
                        if (e.this.g.a(i, list)) {
                            try {
                                e.this.m.a(i, ErrorCode.CANCEL);
                                synchronized (e.this) {
                                    e.this.o.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(final int i, final List<okhttp3.internal.http2.a> list, final boolean z) {
        try {
            a(new okhttp3.internal.b("OkHttp %s Push Headers[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.5
                @Override // okhttp3.internal.b
                public void c() {
                    boolean a2 = e.this.g.a(i, list, z);
                    if (a2) {
                        try {
                            e.this.m.a(i, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (a2 || z) {
                        synchronized (e.this) {
                            e.this.o.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(final int i, okio.e eVar, final int i2, final boolean z) throws IOException {
        final okio.c cVar = new okio.c();
        long j = i2;
        eVar.a(j);
        eVar.a(cVar, j);
        if (cVar.b() != j) {
            throw new IOException(cVar.b() + " != " + i2);
        }
        a(new okhttp3.internal.b("OkHttp %s Push Data[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.6
            @Override // okhttp3.internal.b
            public void c() {
                try {
                    boolean a2 = e.this.g.a(i, cVar, i2, z);
                    if (a2) {
                        e.this.m.a(i, ErrorCode.CANCEL);
                    }
                    if (a2 || z) {
                        synchronized (e.this) {
                            e.this.o.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    void c(final int i, final ErrorCode errorCode) {
        a(new okhttp3.internal.b("OkHttp %s Push Reset[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.7
            @Override // okhttp3.internal.b
            public void c() {
                e.this.g.a(i, errorCode);
                synchronized (e.this) {
                    e.this.o.remove(Integer.valueOf(i));
                }
            }
        });
    }

    private synchronized void a(okhttp3.internal.b bVar) {
        if (!this.r) {
            this.t.execute(bVar);
        }
    }
}
