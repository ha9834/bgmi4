package okhttp3.logging;

import com.amazonaws.services.s3.Headers;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.i;
import okhttp3.internal.b.e;
import okhttp3.internal.e.g;
import okhttp3.s;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
import okio.c;

/* loaded from: classes3.dex */
public final class HttpLoggingInterceptor implements u {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f7145a = Charset.forName("UTF-8");
    private final a b;
    private volatile Set<String> c;
    private volatile Level d;

    /* loaded from: classes3.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: classes3.dex */
    public interface a {
        public static final a b = new a() { // from class: okhttp3.logging.HttpLoggingInterceptor.a.1
            @Override // okhttp3.logging.HttpLoggingInterceptor.a
            public void a(String str) {
                g.e().a(4, str, (Throwable) null);
            }
        };

        void a(String str);
    }

    public HttpLoggingInterceptor() {
        this(a.b);
    }

    public HttpLoggingInterceptor(a aVar) {
        this.c = Collections.emptySet();
        this.d = Level.NONE;
        this.b = aVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        Long l;
        Level level = this.d;
        z a2 = aVar.a();
        if (level == Level.NONE) {
            return aVar.a(a2);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        aa d = a2.d();
        boolean z3 = d != null;
        i b = aVar.b();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(a2.b());
        sb.append(' ');
        sb.append(a2.a());
        sb.append(b != null ? " " + b.a() : "");
        String sb2 = sb.toString();
        if (!z2 && z3) {
            sb2 = sb2 + " (" + d.c() + "-byte body)";
        }
        this.b.a(sb2);
        if (z2) {
            if (z3) {
                if (d.b() != null) {
                    this.b.a("Content-Type: " + d.b());
                }
                if (d.c() != -1) {
                    this.b.a("Content-Length: " + d.c());
                }
            }
            s c = a2.c();
            int a3 = c.a();
            for (int i = 0; i < a3; i++) {
                String a4 = c.a(i);
                if (!"Content-Type".equalsIgnoreCase(a4) && !"Content-Length".equalsIgnoreCase(a4)) {
                    a(c, i);
                }
            }
            if (!z || !z3) {
                this.b.a("--> END " + a2.b());
            } else if (a(a2.c())) {
                this.b.a("--> END " + a2.b() + " (encoded body omitted)");
            } else {
                c cVar = new c();
                d.a(cVar);
                Charset charset = f7145a;
                v b2 = d.b();
                if (b2 != null) {
                    charset = b2.a(f7145a);
                }
                this.b.a("");
                if (a(cVar)) {
                    this.b.a(cVar.a(charset));
                    this.b.a("--> END " + a2.b() + " (" + d.c() + "-byte body)");
                } else {
                    this.b.a("--> END " + a2.b() + " (binary " + d.c() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            ab a5 = aVar.a(a2);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ac g = a5.g();
            long b3 = g.b();
            String str = b3 != -1 ? b3 + "-byte" : "unknown-length";
            a aVar2 = this.b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<-- ");
            sb3.append(a5.b());
            sb3.append(a5.d().isEmpty() ? "" : ' ' + a5.d());
            sb3.append(' ');
            sb3.append(a5.a().a());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            sb3.append(z2 ? "" : ", " + str + " body");
            sb3.append(')');
            aVar2.a(sb3.toString());
            if (z2) {
                s f = a5.f();
                int a6 = f.a();
                for (int i2 = 0; i2 < a6; i2++) {
                    a(f, i2);
                }
                if (!z || !e.b(a5)) {
                    this.b.a("<-- END HTTP");
                } else if (a(a5.f())) {
                    this.b.a("<-- END HTTP (encoded body omitted)");
                } else {
                    okio.e d2 = g.d();
                    d2.b(Long.MAX_VALUE);
                    c c2 = d2.c();
                    okio.i iVar = null;
                    if (HttpStack.ENCODING_GZIP.equalsIgnoreCase(f.a(Headers.CONTENT_ENCODING))) {
                        l = Long.valueOf(c2.b());
                        try {
                            okio.i iVar2 = new okio.i(c2.clone());
                            try {
                                c2 = new c();
                                c2.a(iVar2);
                                iVar2.close();
                            } catch (Throwable th) {
                                th = th;
                                iVar = iVar2;
                                if (iVar != null) {
                                    iVar.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        l = null;
                    }
                    Charset charset2 = f7145a;
                    v a7 = g.a();
                    if (a7 != null) {
                        charset2 = a7.a(f7145a);
                    }
                    if (!a(c2)) {
                        this.b.a("");
                        this.b.a("<-- END HTTP (binary " + c2.b() + "-byte body omitted)");
                        return a5;
                    }
                    if (b3 != 0) {
                        this.b.a("");
                        this.b.a(c2.clone().a(charset2));
                    }
                    if (l != null) {
                        this.b.a("<-- END HTTP (" + c2.b() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.b.a("<-- END HTTP (" + c2.b() + "-byte body)");
                    }
                }
            }
            return a5;
        } catch (Exception e) {
            this.b.a("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    private void a(s sVar, int i) {
        String b = this.c.contains(sVar.a(i)) ? "██" : sVar.b(i);
        this.b.a(sVar.a(i) + ": " + b);
    }

    static boolean a(c cVar) {
        try {
            c cVar2 = new c();
            cVar.a(cVar2, 0L, cVar.b() < 64 ? cVar.b() : 64L);
            for (int i = 0; i < 16; i++) {
                if (cVar2.f()) {
                    return true;
                }
                int r = cVar2.r();
                if (Character.isISOControl(r) && !Character.isWhitespace(r)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private static boolean a(s sVar) {
        String a2 = sVar.a(Headers.CONTENT_ENCODING);
        return (a2 == null || a2.equalsIgnoreCase("identity") || a2.equalsIgnoreCase(HttpStack.ENCODING_GZIP)) ? false : true;
    }
}
