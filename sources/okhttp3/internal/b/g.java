package okhttp3.internal.b;

import java.io.IOException;
import java.util.List;
import okhttp3.ab;
import okhttp3.p;
import okhttp3.u;
import okhttp3.z;

/* loaded from: classes3.dex */
public final class g implements u.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<u> f7074a;
    private final okhttp3.internal.connection.f b;
    private final c c;
    private final okhttp3.internal.connection.c d;
    private final int e;
    private final z f;
    private final okhttp3.e g;
    private final p h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<u> list, okhttp3.internal.connection.f fVar, c cVar, okhttp3.internal.connection.c cVar2, int i, z zVar, okhttp3.e eVar, p pVar, int i2, int i3, int i4) {
        this.f7074a = list;
        this.d = cVar2;
        this.b = fVar;
        this.c = cVar;
        this.e = i;
        this.f = zVar;
        this.g = eVar;
        this.h = pVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    @Override // okhttp3.u.a
    public okhttp3.i b() {
        return this.d;
    }

    @Override // okhttp3.u.a
    public int c() {
        return this.i;
    }

    @Override // okhttp3.u.a
    public int d() {
        return this.j;
    }

    @Override // okhttp3.u.a
    public int e() {
        return this.k;
    }

    public okhttp3.internal.connection.f f() {
        return this.b;
    }

    public c g() {
        return this.c;
    }

    public okhttp3.e h() {
        return this.g;
    }

    public p i() {
        return this.h;
    }

    @Override // okhttp3.u.a
    public z a() {
        return this.f;
    }

    @Override // okhttp3.u.a
    public ab a(z zVar) throws IOException {
        return a(zVar, this.b, this.c, this.d);
    }

    public ab a(z zVar, okhttp3.internal.connection.f fVar, c cVar, okhttp3.internal.connection.c cVar2) throws IOException {
        if (this.e >= this.f7074a.size()) {
            throw new AssertionError();
        }
        this.l++;
        if (this.c != null && !this.d.a(zVar.a())) {
            throw new IllegalStateException("network interceptor " + this.f7074a.get(this.e - 1) + " must retain the same host and port");
        }
        if (this.c != null && this.l > 1) {
            throw new IllegalStateException("network interceptor " + this.f7074a.get(this.e - 1) + " must call proceed() exactly once");
        }
        g gVar = new g(this.f7074a, fVar, cVar, cVar2, this.e + 1, zVar, this.g, this.h, this.i, this.j, this.k);
        u uVar = this.f7074a.get(this.e);
        ab intercept = uVar.intercept(gVar);
        if (cVar != null && this.e + 1 < this.f7074a.size() && gVar.l != 1) {
            throw new IllegalStateException("network interceptor " + uVar + " must call proceed() exactly once");
        }
        if (intercept == null) {
            throw new NullPointerException("interceptor " + uVar + " returned null");
        }
        if (intercept.g() != null) {
            return intercept;
        }
        throw new IllegalStateException("interceptor " + uVar + " returned a response with no body");
    }
}
