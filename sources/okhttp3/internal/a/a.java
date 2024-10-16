package okhttp3.internal.a;

import com.amazonaws.services.s3.Headers;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.internal.a.c;
import okhttp3.internal.b.f;
import okhttp3.internal.b.h;
import okhttp3.s;
import okhttp3.u;
import okhttp3.z;
import okio.k;
import okio.p;
import okio.q;
import okio.r;

/* loaded from: classes3.dex */
public final class a implements u {

    /* renamed from: a, reason: collision with root package name */
    final e f7062a;

    public a(e eVar) {
        this.f7062a = eVar;
    }

    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        e eVar = this.f7062a;
        ab a2 = eVar != null ? eVar.a(aVar.a()) : null;
        c a3 = new c.a(System.currentTimeMillis(), aVar.a(), a2).a();
        z zVar = a3.f7064a;
        ab abVar = a3.b;
        e eVar2 = this.f7062a;
        if (eVar2 != null) {
            eVar2.a(a3);
        }
        if (a2 != null && abVar == null) {
            okhttp3.internal.c.a(a2.g());
        }
        if (zVar == null && abVar == null) {
            return new ab.a().a(aVar.a()).a(Protocol.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(okhttp3.internal.c.c).a(-1L).b(System.currentTimeMillis()).a();
        }
        if (zVar == null) {
            return abVar.h().b(a(abVar)).a();
        }
        try {
            ab a4 = aVar.a(zVar);
            if (a4 == null && a2 != null) {
            }
            if (abVar != null) {
                if (a4.b() == 304) {
                    ab a5 = abVar.h().a(a(abVar.f(), a4.f())).a(a4.k()).b(a4.l()).b(a(abVar)).a(a(a4)).a();
                    a4.g().close();
                    this.f7062a.a();
                    this.f7062a.a(abVar, a5);
                    return a5;
                }
                okhttp3.internal.c.a(abVar.g());
            }
            ab a6 = a4.h().b(a(abVar)).a(a(a4)).a();
            if (this.f7062a != null) {
                if (okhttp3.internal.b.e.b(a6) && c.a(a6, zVar)) {
                    return a(this.f7062a.a(a6), a6);
                }
                if (f.a(zVar.b())) {
                    try {
                        this.f7062a.b(zVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a6;
        } finally {
            if (a2 != null) {
                okhttp3.internal.c.a(a2.g());
            }
        }
    }

    private static ab a(ab abVar) {
        return (abVar == null || abVar.g() == null) ? abVar : abVar.h().a((ac) null).a();
    }

    private ab a(final b bVar, ab abVar) throws IOException {
        p a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return abVar;
        }
        final okio.e d = abVar.g().d();
        final okio.d a3 = k.a(a2);
        return abVar.h().a(new h(abVar.a("Content-Type"), abVar.g().b(), k.a(new q() { // from class: okhttp3.internal.a.a.1

            /* renamed from: a, reason: collision with root package name */
            boolean f7063a;

            @Override // okio.q
            public long a(okio.c cVar, long j) throws IOException {
                try {
                    long a4 = d.a(cVar, j);
                    if (a4 == -1) {
                        if (!this.f7063a) {
                            this.f7063a = true;
                            a3.close();
                        }
                        return -1L;
                    }
                    cVar.a(a3.c(), cVar.b() - a4, a4);
                    a3.w();
                    return a4;
                } catch (IOException e) {
                    if (!this.f7063a) {
                        this.f7063a = true;
                        bVar.b();
                    }
                    throw e;
                }
            }

            @Override // okio.q
            public r a() {
                return d.a();
            }

            @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f7063a && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f7063a = true;
                    bVar.b();
                }
                d.close();
            }
        }))).a();
    }

    private static s a(s sVar, s sVar2) {
        s.a aVar = new s.a();
        int a2 = sVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = sVar.a(i);
            String b = sVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a3) || !b.startsWith("1")) && (b(a3) || !a(a3) || sVar2.a(a3) == null)) {
                okhttp3.internal.a.f7061a.a(aVar, a3, b);
            }
        }
        int a4 = sVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = sVar2.a(i2);
            if (!b(a5) && a(a5)) {
                okhttp3.internal.a.f7061a.a(aVar, a5, sVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return (Headers.CONNECTION.equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    static boolean b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || Headers.CONTENT_ENCODING.equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
