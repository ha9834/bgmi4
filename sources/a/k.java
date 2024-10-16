package a;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import okhttp3.aa;
import okhttp3.q;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f45a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String b;
    private final t c;
    private String d;
    private t.a e;
    private final z.a f = new z.a();
    private v g;
    private final boolean h;
    private w.a i;
    private q.a j;
    private aa k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, t tVar, String str2, s sVar, v vVar, boolean z, boolean z2, boolean z3) {
        this.b = str;
        this.c = tVar;
        this.d = str2;
        this.g = vVar;
        this.h = z;
        if (sVar != null) {
            this.f.a(sVar);
        }
        if (z2) {
            this.j = new q.a();
        } else if (z3) {
            this.i = new w.a();
            this.i.a(w.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("@Url parameter is null.");
        }
        this.d = obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            v b = v.b(str2);
            if (b == null) {
                throw new IllegalArgumentException("Malformed content type: " + str2);
            }
            this.g = b;
            return;
        }
        this.f.b(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z) {
        String str3 = this.d;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.d = str3.replace("{" + str + "}", a(str2, z));
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i += Character.charCount(codePointAt);
            } else {
                okio.c cVar = new okio.c();
                cVar.a(str, 0, i);
                a(cVar, str, i, length, z);
                return cVar.p();
            }
        }
        return str;
    }

    private static void a(okio.c cVar, String str, int i, int i2, boolean z) {
        okio.c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new okio.c();
                    }
                    cVar2.a(codePointAt);
                    while (!cVar2.f()) {
                        int i3 = cVar2.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                        cVar.i(37);
                        cVar.i((int) f45a[(i3 >> 4) & 15]);
                        cVar.i((int) f45a[i3 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2, boolean z) {
        String str3 = this.d;
        if (str3 != null) {
            this.e = this.c.d(str3);
            if (this.e == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.c + ", Relative: " + this.d);
            }
            this.d = null;
        }
        if (z) {
            this.e.b(str, str2);
        } else {
            this.e.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, String str2, boolean z) {
        if (z) {
            this.j.b(str, str2);
        } else {
            this.j.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(s sVar, aa aaVar) {
        this.i.a(sVar, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w.b bVar) {
        this.i.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(aa aaVar) {
        this.k = aaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z a() {
        t c;
        t.a aVar = this.e;
        if (aVar != null) {
            c = aVar.c();
        } else {
            c = this.c.c(this.d);
            if (c == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.c + ", Relative: " + this.d);
            }
        }
        aa aaVar = this.k;
        if (aaVar == null) {
            q.a aVar2 = this.j;
            if (aVar2 != null) {
                aaVar = aVar2.a();
            } else {
                w.a aVar3 = this.i;
                if (aVar3 != null) {
                    aaVar = aVar3.a();
                } else if (this.h) {
                    aaVar = aa.a((v) null, new byte[0]);
                }
            }
        }
        v vVar = this.g;
        if (vVar != null) {
            if (aaVar != null) {
                aaVar = new a(aaVar, vVar);
            } else {
                this.f.b("Content-Type", vVar.toString());
            }
        }
        return this.f.a(c).a(this.b, aaVar).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends aa {

        /* renamed from: a, reason: collision with root package name */
        private final aa f46a;
        private final v b;

        a(aa aaVar, v vVar) {
            this.f46a = aaVar;
            this.b = vVar;
        }

        @Override // okhttp3.aa
        public v b() {
            return this.b;
        }

        @Override // okhttp3.aa
        public long c() throws IOException {
            return this.f46a.c();
        }

        @Override // okhttp3.aa
        public void a(okio.d dVar) throws IOException {
            this.f46a.a(dVar);
        }
    }
}
