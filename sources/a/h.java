package a;

import java.io.IOException;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h<T> implements a.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final n<T> f24a;
    private final Object[] b;
    private volatile boolean c;
    private okhttp3.e d;
    private Throwable e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(n<T> nVar, Object[] objArr) {
        this.f24a = nVar;
        this.b = objArr;
    }

    @Override // a.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public h<T> clone() {
        return new h<>(this.f24a, this.b);
    }

    @Override // a.b
    public void a(final d<T> dVar) {
        okhttp3.e eVar;
        Throwable th;
        if (dVar == null) {
            throw new NullPointerException("callback == null");
        }
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f = true;
            eVar = this.d;
            th = this.e;
            if (eVar == null && th == null) {
                try {
                    okhttp3.e e = e();
                    this.d = e;
                    eVar = e;
                } catch (Throwable th2) {
                    th = th2;
                    this.e = th;
                }
            }
        }
        if (th != null) {
            dVar.onFailure(this, th);
            return;
        }
        if (this.c) {
            eVar.b();
        }
        eVar.a(new okhttp3.f() { // from class: a.h.1
            @Override // okhttp3.f
            public void a(okhttp3.e eVar2, ab abVar) throws IOException {
                try {
                    a(h.this.a(abVar));
                } catch (Throwable th3) {
                    a(th3);
                }
            }

            @Override // okhttp3.f
            public void a(okhttp3.e eVar2, IOException iOException) {
                try {
                    dVar.onFailure(h.this, iOException);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }

            private void a(Throwable th3) {
                try {
                    dVar.onFailure(h.this, th3);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }

            private void a(l<T> lVar) {
                try {
                    dVar.onResponse(h.this, lVar);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        });
    }

    @Override // a.b
    public l<T> a() throws IOException {
        okhttp3.e eVar;
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f = true;
            if (this.e != null) {
                if (this.e instanceof IOException) {
                    throw ((IOException) this.e);
                }
                throw ((RuntimeException) this.e);
            }
            eVar = this.d;
            if (eVar == null) {
                try {
                    eVar = e();
                    this.d = eVar;
                } catch (IOException | RuntimeException e) {
                    this.e = e;
                    throw e;
                }
            }
        }
        if (this.c) {
            eVar.b();
        }
        return a(eVar.a());
    }

    private okhttp3.e e() throws IOException {
        okhttp3.e a2 = this.f24a.c.a(this.f24a.a(this.b));
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    l<T> a(ab abVar) throws IOException {
        ac g = abVar.g();
        ab a2 = abVar.h().a(new b(g.a(), g.b())).a();
        int b2 = a2.b();
        if (b2 < 200 || b2 >= 300) {
            try {
                return l.a(o.a(g), a2);
            } finally {
                g.close();
            }
        }
        if (b2 == 204 || b2 == 205) {
            return l.a((Object) null, a2);
        }
        a aVar = new a(g);
        try {
            return l.a(this.f24a.a(aVar), a2);
        } catch (RuntimeException e) {
            aVar.h();
            throw e;
        }
    }

    @Override // a.b
    public boolean b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends ac {

        /* renamed from: a, reason: collision with root package name */
        private final v f28a;
        private final long b;

        b(v vVar, long j) {
            this.f28a = vVar;
            this.b = j;
        }

        @Override // okhttp3.ac
        public v a() {
            return this.f28a;
        }

        @Override // okhttp3.ac
        public long b() {
            return this.b;
        }

        @Override // okhttp3.ac
        public okio.e d() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends ac {

        /* renamed from: a, reason: collision with root package name */
        IOException f26a;
        private final ac b;

        a(ac acVar) {
            this.b = acVar;
        }

        @Override // okhttp3.ac
        public v a() {
            return this.b.a();
        }

        @Override // okhttp3.ac
        public long b() {
            return this.b.b();
        }

        @Override // okhttp3.ac
        public okio.e d() {
            return okio.k.a(new okio.g(this.b.d()) { // from class: a.h.a.1
                @Override // okio.g, okio.q
                public long a(okio.c cVar, long j) throws IOException {
                    try {
                        return super.a(cVar, j);
                    } catch (IOException e) {
                        a.this.f26a = e;
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ac, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.b.close();
        }

        void h() throws IOException {
            IOException iOException = this.f26a;
            if (iOException != null) {
                throw iOException;
            }
        }
    }
}
