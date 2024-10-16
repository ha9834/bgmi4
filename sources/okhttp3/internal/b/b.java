package okhttp3.internal.b;

import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.ab;
import okhttp3.u;
import okhttp3.z;
import okio.p;

/* loaded from: classes3.dex */
public final class b implements u {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f7070a;

    public b(boolean z) {
        this.f7070a = z;
    }

    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        ab a2;
        g gVar = (g) aVar;
        c g = gVar.g();
        okhttp3.internal.connection.f f = gVar.f();
        okhttp3.internal.connection.c cVar = (okhttp3.internal.connection.c) gVar.b();
        z a3 = gVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.i().c(gVar.h());
        g.a(a3);
        gVar.i().a(gVar.h(), a3);
        ab.a aVar2 = null;
        if (f.c(a3.b()) && a3.d() != null) {
            if ("100-continue".equalsIgnoreCase(a3.a(HttpHeader.EXPECT))) {
                g.a();
                gVar.i().e(gVar.h());
                aVar2 = g.a(true);
            }
            if (aVar2 == null) {
                gVar.i().d(gVar.h());
                a aVar3 = new a(g.a(a3, a3.d().c()));
                okio.d a4 = okio.k.a(aVar3);
                a3.d().a(a4);
                a4.close();
                gVar.i().a(gVar.h(), aVar3.f7071a);
            } else if (!cVar.f()) {
                f.e();
            }
        }
        g.b();
        if (aVar2 == null) {
            gVar.i().e(gVar.h());
            aVar2 = g.a(false);
        }
        ab a5 = aVar2.a(a3).a(f.c().e()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
        int b = a5.b();
        if (b == 100) {
            a5 = g.a(false).a(a3).a(f.c().e()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
            b = a5.b();
        }
        gVar.i().a(gVar.h(), a5);
        if (this.f7070a && b == 101) {
            a2 = a5.h().a(okhttp3.internal.c.c).a();
        } else {
            a2 = a5.h().a(g.a(a5)).a();
        }
        if ("close".equalsIgnoreCase(a2.a().a(Headers.CONNECTION)) || "close".equalsIgnoreCase(a2.a(Headers.CONNECTION))) {
            f.e();
        }
        if ((b != 204 && b != 205) || a2.g().b() <= 0) {
            return a2;
        }
        throw new ProtocolException("HTTP " + b + " had non-zero Content-Length: " + a2.g().b());
    }

    /* loaded from: classes3.dex */
    static final class a extends okio.f {

        /* renamed from: a, reason: collision with root package name */
        long f7071a;

        a(p pVar) {
            super(pVar);
        }

        @Override // okio.f, okio.p
        public void a_(okio.c cVar, long j) throws IOException {
            super.a_(cVar, j);
            this.f7071a += j;
        }
    }
}
