package okhttp3;

import com.amazonaws.services.s3.Headers;
import com.qq.taf.jce.JceStruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.s;
import okio.ByteString;

/* loaded from: classes.dex */
public final class w extends aa {

    /* renamed from: a, reason: collision with root package name */
    public static final v f7160a = v.a("multipart/mixed");
    public static final v b = v.a("multipart/alternative");
    public static final v c = v.a("multipart/digest");
    public static final v d = v.a("multipart/parallel");
    public static final v e = v.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {JceStruct.SIMPLE_LIST, 10};
    private static final byte[] h = {45, 45};
    private final ByteString i;
    private final v j;
    private final v k;
    private final List<b> l;
    private long m = -1;

    w(ByteString byteString, v vVar, List<b> list) {
        this.i = byteString;
        this.j = vVar;
        this.k = v.a(vVar + "; boundary=" + byteString.a());
        this.l = okhttp3.internal.c.a(list);
    }

    @Override // okhttp3.aa
    public v b() {
        return this.k;
    }

    @Override // okhttp3.aa
    public long c() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((okio.d) null, true);
        this.m = a2;
        return a2;
    }

    @Override // okhttp3.aa
    public void a(okio.d dVar) throws IOException {
        a(dVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(@Nullable okio.d dVar, boolean z) throws IOException {
        okio.c cVar;
        if (z) {
            dVar = new okio.c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.l.get(i);
            s sVar = bVar.f7162a;
            aa aaVar = bVar.b;
            dVar.c(h);
            dVar.b(this.i);
            dVar.c(g);
            if (sVar != null) {
                int a2 = sVar.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    dVar.b(sVar.a(i2)).c(f).b(sVar.b(i2)).c(g);
                }
            }
            v b2 = aaVar.b();
            if (b2 != null) {
                dVar.b("Content-Type: ").b(b2.toString()).c(g);
            }
            long c2 = aaVar.c();
            if (c2 != -1) {
                dVar.b("Content-Length: ").m(c2).c(g);
            } else if (z) {
                cVar.t();
                return -1L;
            }
            dVar.c(g);
            if (z) {
                j += c2;
            } else {
                aaVar.a(dVar);
            }
            dVar.c(g);
        }
        dVar.c(h);
        dVar.b(this.i);
        dVar.c(h);
        dVar.c(g);
        if (!z) {
            return j;
        }
        long b3 = j + cVar.b();
        cVar.t();
        return b3;
    }

    static StringBuilder a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(charAt);
            }
        }
        sb.append('\"');
        return sb;
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        final s f7162a;
        final aa b;

        public static b a(@Nullable s sVar, aa aaVar) {
            if (aaVar == null) {
                throw new NullPointerException("body == null");
            }
            if (sVar != null && sVar.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (sVar != null && sVar.a("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new b(sVar, aaVar);
        }

        public static b a(String str, String str2) {
            return a(str, null, aa.a((v) null, str2));
        }

        public static b a(String str, @Nullable String str2, aa aaVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            w.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                w.a(sb, str2);
            }
            return a(new s.a().b(Headers.CONTENT_DISPOSITION, sb.toString()).a(), aaVar);
        }

        private b(@Nullable s sVar, aa aaVar) {
            this.f7162a = sVar;
            this.b = aaVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final ByteString f7161a;
        private v b;
        private final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.b = w.f7160a;
            this.c = new ArrayList();
            this.f7161a = ByteString.a(str);
        }

        public a a(v vVar) {
            if (vVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!vVar.a().equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + vVar);
            }
            this.b = vVar;
            return this;
        }

        public a a(@Nullable s sVar, aa aaVar) {
            return a(b.a(sVar, aaVar));
        }

        public a a(String str, String str2) {
            return a(b.a(str, str2));
        }

        public a a(String str, @Nullable String str2, aa aaVar) {
            return a(b.a(str, str2, aaVar));
        }

        public a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.c.add(bVar);
            return this;
        }

        public w a() {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new w(this.f7161a, this.b, this.c);
        }
    }
}
