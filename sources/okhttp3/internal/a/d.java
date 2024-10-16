package okhttp3.internal.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class d implements Closeable, Flushable {
    final okhttp3.internal.d.a b;
    final int c;
    okio.d d;
    final LinkedHashMap<String, b> e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    private long k;
    private long l;
    private long m;
    private final Executor n;
    private final Runnable o;
    static final /* synthetic */ boolean j = !d.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    static final Pattern f7066a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void a(a aVar, boolean z) throws IOException {
        b bVar = aVar.f7067a;
        if (bVar.f != aVar) {
            throw new IllegalStateException();
        }
        if (z && !bVar.e) {
            for (int i = 0; i < this.c; i++) {
                if (!aVar.b[i]) {
                    aVar.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.b.b(bVar.d[i])) {
                    aVar.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            File file = bVar.d[i2];
            if (z) {
                if (this.b.b(file)) {
                    File file2 = bVar.c[i2];
                    this.b.a(file, file2);
                    long j2 = bVar.b[i2];
                    long c = this.b.c(file2);
                    bVar.b[i2] = c;
                    this.l = (this.l - j2) + c;
                }
            } else {
                this.b.a(file);
            }
        }
        this.f++;
        bVar.f = null;
        if (bVar.e | z) {
            bVar.e = true;
            this.d.b("CLEAN").i(32);
            this.d.b(bVar.f7068a);
            bVar.a(this.d);
            this.d.i(10);
            if (z) {
                long j3 = this.m;
                this.m = 1 + j3;
                bVar.g = j3;
            }
        } else {
            this.e.remove(bVar.f7068a);
            this.d.b("REMOVE").i(32);
            this.d.b(bVar.f7068a);
            this.d.i(10);
        }
        this.d.flush();
        if (this.l > this.k || a()) {
            this.n.execute(this.o);
        }
    }

    boolean a() {
        int i = this.f;
        return i >= 2000 && i >= this.e.size();
    }

    boolean a(b bVar) throws IOException {
        if (bVar.f != null) {
            bVar.f.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.b.a(bVar.c[i]);
            this.l -= bVar.b[i];
            bVar.b[i] = 0;
        }
        this.f++;
        this.d.b("REMOVE").i(32).b(bVar.f7068a).i(10);
        this.e.remove(bVar.f7068a);
        if (a()) {
            this.n.execute(this.o);
        }
        return true;
    }

    public synchronized boolean b() {
        return this.h;
    }

    private synchronized void d() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.g) {
            d();
            c();
            this.d.flush();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.g && !this.h) {
            for (b bVar : (b[]) this.e.values().toArray(new b[this.e.size()])) {
                if (bVar.f != null) {
                    bVar.f.b();
                }
            }
            c();
            this.d.close();
            this.d = null;
            this.h = true;
            return;
        }
        this.h = true;
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.e.values().iterator().next());
        }
        this.i = false;
    }

    /* loaded from: classes3.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        final b f7067a;
        final boolean[] b;
        final /* synthetic */ d c;
        private boolean d;

        void a() {
            if (this.f7067a.f == this) {
                for (int i = 0; i < this.c.c; i++) {
                    try {
                        this.c.b.a(this.f7067a.d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f7067a.f = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.c) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f7067a.f == this) {
                    this.c.a(this, false);
                }
                this.d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f7068a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        a f;
        long g;

        void a(okio.d dVar) throws IOException {
            for (long j : this.b) {
                dVar.i(32).m(j);
            }
        }
    }
}
