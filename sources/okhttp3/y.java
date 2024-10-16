package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements e {

    /* renamed from: a, reason: collision with root package name */
    final x f7165a;
    final okhttp3.internal.b.j b;
    final okio.a c = new okio.a() { // from class: okhttp3.y.1
        @Override // okio.a
        protected void a() {
            y.this.b();
        }
    };
    final z d;
    final boolean e;

    @Nullable
    private p f;
    private boolean g;

    private y(x xVar, z zVar, boolean z) {
        this.f7165a = xVar;
        this.d = zVar;
        this.e = z;
        this.b = new okhttp3.internal.b.j(xVar, z);
        this.c.a(xVar.a(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static y a(x xVar, z zVar, boolean z) {
        y yVar = new y(xVar, zVar, z);
        yVar.f = xVar.z().a(yVar);
        return yVar;
    }

    @Override // okhttp3.e
    public ab a() throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        h();
        this.c.c();
        this.f.a(this);
        try {
            try {
                this.f7165a.u().a(this);
                ab g = g();
                if (g != null) {
                    return g;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                IOException a2 = a(e);
                this.f.a(this, a2);
                throw a2;
            }
        } finally {
            this.f7165a.u().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException a(@Nullable IOException iOException) {
        if (!this.c.f_()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void h() {
        this.b.a(okhttp3.internal.e.g.e().a("response.body().close()"));
    }

    @Override // okhttp3.e
    public void a(f fVar) {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        h();
        this.f.a(this);
        this.f7165a.u().a(new a(fVar));
    }

    @Override // okhttp3.e
    public void b() {
        this.b.a();
    }

    public boolean c() {
        return this.b.b();
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public y clone() {
        return a(this.f7165a, this.d, this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class a extends okhttp3.internal.b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f7167a = !y.class.desiredAssertionStatus();
        private final f d;

        a(f fVar) {
            super("OkHttp %s", y.this.f());
            this.d = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return y.this.d.a().f();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public y b() {
            return y.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            if (!f7167a && Thread.holdsLock(y.this.f7165a.u())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    y.this.f.a(y.this, interruptedIOException);
                    this.d.a(y.this, interruptedIOException);
                    y.this.f7165a.u().b(this);
                }
            } catch (Throwable th) {
                y.this.f7165a.u().b(this);
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // okhttp3.internal.b
        protected void c() {
            Throwable th;
            boolean z;
            IOException e;
            y.this.c.c();
            try {
                try {
                    z = true;
                    try {
                        this.d.a(y.this, y.this.g());
                    } catch (IOException e2) {
                        e = e2;
                        IOException a2 = y.this.a(e);
                        if (!z) {
                            y.this.f.a(y.this, a2);
                            this.d.a(y.this, a2);
                        } else {
                            okhttp3.internal.e.g.e().a(4, "Callback failure for " + y.this.e(), a2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        y.this.b();
                        if (!z) {
                            this.d.a(y.this, new IOException("canceled due to " + th));
                        }
                        throw th;
                    }
                } finally {
                    y.this.f7165a.u().b(this);
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
        }
    }

    String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(c() ? "canceled " : "");
        sb.append(this.e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(f());
        return sb.toString();
    }

    String f() {
        return this.d.a().o();
    }

    ab g() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f7165a.x());
        arrayList.add(this.b);
        arrayList.add(new okhttp3.internal.b.a(this.f7165a.h()));
        arrayList.add(new okhttp3.internal.a.a(this.f7165a.i()));
        arrayList.add(new okhttp3.internal.connection.a(this.f7165a));
        if (!this.e) {
            arrayList.addAll(this.f7165a.y());
        }
        arrayList.add(new okhttp3.internal.b.b(this.e));
        ab a2 = new okhttp3.internal.b.g(arrayList, null, null, null, 0, this.d, this, this.f, this.f7165a.b(), this.f7165a.c(), this.f7165a.d()).a(this.d);
        if (!this.b.b()) {
            return a2;
        }
        okhttp3.internal.c.a(a2);
        throw new IOException("Canceled");
    }
}
