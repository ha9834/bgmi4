package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.ad;
import okhttp3.internal.connection.e;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.j;
import okhttp3.p;
import okhttp3.u;
import okhttp3.x;

/* loaded from: classes3.dex */
public final class f {
    static final /* synthetic */ boolean d = !f.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.a f7090a;
    public final okhttp3.e b;
    public final p c;
    private e.a e;
    private ad f;
    private final j g;
    private final Object h;
    private final e i;
    private int j;
    private c k;
    private boolean l;
    private boolean m;
    private boolean n;
    private okhttp3.internal.b.c o;

    public f(j jVar, okhttp3.a aVar, okhttp3.e eVar, p pVar, Object obj) {
        this.g = jVar;
        this.f7090a = aVar;
        this.b = eVar;
        this.c = pVar;
        this.i = new e(aVar, i(), eVar, pVar);
        this.h = obj;
    }

    public okhttp3.internal.b.c a(x xVar, u.a aVar, boolean z) {
        try {
            okhttp3.internal.b.c a2 = a(aVar.c(), aVar.d(), aVar.e(), xVar.e(), xVar.t(), z).a(xVar, aVar, this);
            synchronized (this.g) {
                this.o = a2;
            }
            return a2;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private c a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i, i2, i3, i4, z);
            synchronized (this.g) {
                if (a2.b == 0 && !a2.f()) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                e();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private c a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket h;
        Socket socket;
        c cVar;
        c cVar2;
        c cVar3;
        ad adVar;
        boolean z2;
        boolean z3;
        e.a aVar;
        synchronized (this.g) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.o != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.n) {
                throw new IOException("Canceled");
            }
            c cVar4 = this.k;
            h = h();
            socket = null;
            if (this.k != null) {
                cVar2 = this.k;
                cVar = null;
            } else {
                cVar = cVar4;
                cVar2 = null;
            }
            if (!this.l) {
                cVar = null;
            }
            if (cVar2 == null) {
                okhttp3.internal.a.f7061a.a(this.g, this.f7090a, this, null);
                if (this.k != null) {
                    cVar3 = this.k;
                    adVar = null;
                    z2 = true;
                } else {
                    adVar = this.f;
                    cVar3 = cVar2;
                    z2 = false;
                }
            } else {
                cVar3 = cVar2;
                adVar = null;
                z2 = false;
            }
        }
        okhttp3.internal.c.a(h);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
        if (z2) {
            this.c.a(this.b, cVar3);
        }
        if (cVar3 != null) {
            this.f = this.k.b();
            return cVar3;
        }
        if (adVar != null || ((aVar = this.e) != null && aVar.a())) {
            z3 = false;
        } else {
            this.e = this.i.b();
            z3 = true;
        }
        synchronized (this.g) {
            if (this.n) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<ad> c = this.e.c();
                int size = c.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    ad adVar2 = c.get(i5);
                    okhttp3.internal.a.f7061a.a(this.g, this.f7090a, this, adVar2);
                    if (this.k != null) {
                        cVar3 = this.k;
                        this.f = adVar2;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (adVar == null) {
                    adVar = this.e.b();
                }
                this.f = adVar;
                this.j = 0;
                cVar3 = new c(this.g, adVar);
                a(cVar3, false);
            }
        }
        if (z2) {
            this.c.a(this.b, cVar3);
            return cVar3;
        }
        cVar3.a(i, i2, i3, i4, z, this.b, this.c);
        i().b(cVar3.b());
        synchronized (this.g) {
            this.l = true;
            okhttp3.internal.a.f7061a.b(this.g, cVar3);
            if (cVar3.f()) {
                socket = okhttp3.internal.a.f7061a.a(this.g, this.f7090a, this);
                cVar3 = this.k;
            }
        }
        okhttp3.internal.c.a(socket);
        this.c.a(this.b, cVar3);
        return cVar3;
    }

    private Socket h() {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        c cVar = this.k;
        if (cVar == null || !cVar.f7086a) {
            return null;
        }
        return a(false, false, true);
    }

    public void a(boolean z, okhttp3.internal.b.c cVar, long j, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.c.b(this.b, j);
        synchronized (this.g) {
            if (cVar != null) {
                if (cVar == this.o) {
                    if (!z) {
                        this.k.b++;
                    }
                    cVar2 = this.k;
                    a2 = a(z, false, true);
                    if (this.k != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.o + " but was " + cVar);
        }
        okhttp3.internal.c.a(a2);
        if (cVar2 != null) {
            this.c.b(this.b, cVar2);
        }
        if (iOException != null) {
            this.c.a(this.b, okhttp3.internal.a.f7061a.a(this.b, iOException));
        } else if (z2) {
            okhttp3.internal.a.f7061a.a(this.b, (IOException) null);
            this.c.g(this.b);
        }
    }

    public okhttp3.internal.b.c a() {
        okhttp3.internal.b.c cVar;
        synchronized (this.g) {
            cVar = this.o;
        }
        return cVar;
    }

    private d i() {
        return okhttp3.internal.a.f7061a.a(this.g);
    }

    public ad b() {
        return this.f;
    }

    public synchronized c c() {
        return this.k;
    }

    public void d() {
        c cVar;
        Socket a2;
        synchronized (this.g) {
            cVar = this.k;
            a2 = a(false, true, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        okhttp3.internal.c.a(a2);
        if (cVar != null) {
            okhttp3.internal.a.f7061a.a(this.b, (IOException) null);
            this.c.b(this.b, cVar);
            this.c.g(this.b);
        }
    }

    public void e() {
        c cVar;
        Socket a2;
        synchronized (this.g) {
            cVar = this.k;
            a2 = a(true, false, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        okhttp3.internal.c.a(a2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (z3) {
            this.o = null;
        }
        if (z2) {
            this.m = true;
        }
        c cVar = this.k;
        if (cVar != null) {
            if (z) {
                cVar.f7086a = true;
            }
            if (this.o == null && (this.m || this.k.f7086a)) {
                b(this.k);
                if (this.k.d.isEmpty()) {
                    this.k.e = System.nanoTime();
                    if (okhttp3.internal.a.f7061a.a(this.g, this.k)) {
                        socket = this.k.d();
                        this.k = null;
                        return socket;
                    }
                }
                socket = null;
                this.k = null;
                return socket;
            }
        }
        return null;
    }

    public void f() {
        okhttp3.internal.b.c cVar;
        c cVar2;
        synchronized (this.g) {
            this.n = true;
            cVar = this.o;
            cVar2 = this.k;
        }
        if (cVar != null) {
            cVar.c();
        } else if (cVar2 != null) {
            cVar2.c();
        }
    }

    public void a(IOException iOException) {
        boolean z;
        c cVar;
        Socket a2;
        synchronized (this.g) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    this.j++;
                    if (this.j > 1) {
                        this.f = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.f = null;
                        z = true;
                    }
                    z = false;
                }
            } else if (this.k == null || (this.k.f() && !(iOException instanceof ConnectionShutdownException))) {
                z = false;
            } else {
                if (this.k.b == 0) {
                    if (this.f != null && iOException != null) {
                        this.i.a(this.f, iOException);
                    }
                    this.f = null;
                }
                z = true;
            }
            cVar = this.k;
            a2 = a(z, false, true);
            if (this.k != null || !this.l) {
                cVar = null;
            }
        }
        okhttp3.internal.c.a(a2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.k != null) {
            throw new IllegalStateException();
        }
        this.k = cVar;
        this.l = z;
        cVar.d.add(new a(this, this.h));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void b(c cVar) {
        int size = cVar.d.size();
        for (int i = 0; i < size; i++) {
            if (cVar.d.get(i).get() == this) {
                cVar.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.o != null || this.k.d.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<f> reference = this.k.d.get(0);
        Socket a2 = a(true, false, false);
        this.k = cVar;
        cVar.d.add(reference);
        return a2;
    }

    public boolean g() {
        e.a aVar;
        return this.f != null || ((aVar = this.e) != null && aVar.a()) || this.i.a();
    }

    public String toString() {
        c c = c();
        return c != null ? c.toString() : this.f7090a.toString();
    }

    /* loaded from: classes3.dex */
    public static final class a extends WeakReference<f> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f7091a;

        a(f fVar, Object obj) {
            super(fVar);
            this.f7091a = obj;
        }
    }
}
