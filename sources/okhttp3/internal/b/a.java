package okhttp3.internal.b;

import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import java.io.IOException;
import java.util.List;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.m;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;

/* loaded from: classes3.dex */
public final class a implements u {

    /* renamed from: a, reason: collision with root package name */
    private final m f7069a;

    public a(m mVar) {
        this.f7069a = mVar;
    }

    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        z a2 = aVar.a();
        z.a e = a2.e();
        aa d = a2.d();
        if (d != null) {
            v b = d.b();
            if (b != null) {
                e.a("Content-Type", b.toString());
            }
            long c = d.c();
            if (c != -1) {
                e.a("Content-Length", Long.toString(c));
                e.b("Transfer-Encoding");
            } else {
                e.a("Transfer-Encoding", "chunked");
                e.b("Content-Length");
            }
        }
        boolean z = false;
        if (a2.a(HttpHeader.HOST) == null) {
            e.a(HttpHeader.HOST, okhttp3.internal.c.a(a2.a(), false));
        }
        if (a2.a(Headers.CONNECTION) == null) {
            e.a(Headers.CONNECTION, "Keep-Alive");
        }
        if (a2.a(HttpStack.HEADER_ACCEPT_ENCODING) == null && a2.a(Headers.RANGE) == null) {
            z = true;
            e.a(HttpStack.HEADER_ACCEPT_ENCODING, HttpStack.ENCODING_GZIP);
        }
        List<okhttp3.l> a3 = this.f7069a.a(a2.a());
        if (!a3.isEmpty()) {
            e.a("Cookie", a(a3));
        }
        if (a2.a(HttpHeader.USER_AGENT) == null) {
            e.a(HttpHeader.USER_AGENT, okhttp3.internal.d.a());
        }
        ab a4 = aVar.a(e.b());
        e.a(this.f7069a, a2.a(), a4.f());
        ab.a a5 = a4.h().a(a2);
        if (z && HttpStack.ENCODING_GZIP.equalsIgnoreCase(a4.a(Headers.CONTENT_ENCODING)) && e.b(a4)) {
            okio.i iVar = new okio.i(a4.g().d());
            a5.a(a4.f().b().b(Headers.CONTENT_ENCODING).b("Content-Length").a());
            a5.a(new h(a4.a("Content-Type"), -1L, okio.k.a(iVar)));
        }
        return a5.a();
    }

    private String a(List<okhttp3.l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            okhttp3.l lVar = list.get(i);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }
}
