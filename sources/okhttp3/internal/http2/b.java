package okhttp3.internal.http2;

import com.google.android.gms.games.Notifications;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.q;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final okhttp3.internal.http2.a[] f7107a = {new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f, ""), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.c, "GET"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.c, "POST"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.d, "/"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.d, "/index.html"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "http"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "https"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.b, "200"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.b, "204"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.b, "206"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.b, "304"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.b, "400"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.b, "404"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.b, "500"), new okhttp3.internal.http2.a("accept-charset", ""), new okhttp3.internal.http2.a("accept-encoding", "gzip, deflate"), new okhttp3.internal.http2.a("accept-language", ""), new okhttp3.internal.http2.a("accept-ranges", ""), new okhttp3.internal.http2.a("accept", ""), new okhttp3.internal.http2.a("access-control-allow-origin", ""), new okhttp3.internal.http2.a("age", ""), new okhttp3.internal.http2.a("allow", ""), new okhttp3.internal.http2.a("authorization", ""), new okhttp3.internal.http2.a("cache-control", ""), new okhttp3.internal.http2.a("content-disposition", ""), new okhttp3.internal.http2.a("content-encoding", ""), new okhttp3.internal.http2.a("content-language", ""), new okhttp3.internal.http2.a("content-length", ""), new okhttp3.internal.http2.a("content-location", ""), new okhttp3.internal.http2.a("content-range", ""), new okhttp3.internal.http2.a("content-type", ""), new okhttp3.internal.http2.a("cookie", ""), new okhttp3.internal.http2.a("date", ""), new okhttp3.internal.http2.a("etag", ""), new okhttp3.internal.http2.a("expect", ""), new okhttp3.internal.http2.a("expires", ""), new okhttp3.internal.http2.a("from", ""), new okhttp3.internal.http2.a("host", ""), new okhttp3.internal.http2.a("if-match", ""), new okhttp3.internal.http2.a("if-modified-since", ""), new okhttp3.internal.http2.a("if-none-match", ""), new okhttp3.internal.http2.a("if-range", ""), new okhttp3.internal.http2.a("if-unmodified-since", ""), new okhttp3.internal.http2.a("last-modified", ""), new okhttp3.internal.http2.a("link", ""), new okhttp3.internal.http2.a(FirebaseAnalytics.Param.LOCATION, ""), new okhttp3.internal.http2.a("max-forwards", ""), new okhttp3.internal.http2.a("proxy-authenticate", ""), new okhttp3.internal.http2.a("proxy-authorization", ""), new okhttp3.internal.http2.a("range", ""), new okhttp3.internal.http2.a("referer", ""), new okhttp3.internal.http2.a("refresh", ""), new okhttp3.internal.http2.a("retry-after", ""), new okhttp3.internal.http2.a("server", ""), new okhttp3.internal.http2.a("set-cookie", ""), new okhttp3.internal.http2.a("strict-transport-security", ""), new okhttp3.internal.http2.a("transfer-encoding", ""), new okhttp3.internal.http2.a("user-agent", ""), new okhttp3.internal.http2.a("vary", ""), new okhttp3.internal.http2.a("via", ""), new okhttp3.internal.http2.a("www-authenticate", "")};
    static final Map<ByteString, Integer> b = a();

    /* loaded from: classes3.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        okhttp3.internal.http2.a[] f7108a;
        int b;
        int c;
        int d;
        private final List<okhttp3.internal.http2.a> e;
        private final okio.e f;
        private final int g;
        private int h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, q qVar) {
            this(i, i, qVar);
        }

        a(int i, int i2, q qVar) {
            this.e = new ArrayList();
            this.f7108a = new okhttp3.internal.http2.a[8];
            this.b = this.f7108a.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.f = okio.k.a(qVar);
        }

        private void d() {
            int i = this.h;
            int i2 = this.d;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    a(i2 - i);
                }
            }
        }

        private void e() {
            Arrays.fill(this.f7108a, (Object) null);
            this.b = this.f7108a.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f7108a.length;
                while (true) {
                    length--;
                    if (length < this.b || i <= 0) {
                        break;
                    }
                    i -= this.f7108a[length].i;
                    this.d -= this.f7108a[length].i;
                    this.c--;
                    i2++;
                }
                okhttp3.internal.http2.a[] aVarArr = this.f7108a;
                int i3 = this.b;
                System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i2, this.c);
                this.b += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.f.f()) {
                int i = this.f.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((i & 128) == 128) {
                    b(a(i, Notifications.NOTIFICATION_TYPES_ALL) - 1);
                } else if (i == 64) {
                    g();
                } else if ((i & 64) == 64) {
                    e(a(i, 63) - 1);
                } else if ((i & 32) == 32) {
                    this.h = a(i, 31);
                    int i2 = this.h;
                    if (i2 < 0 || i2 > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (i == 16 || i == 0) {
                    f();
                } else {
                    d(a(i, 15) - 1);
                }
            }
        }

        public List<okhttp3.internal.http2.a> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.e.add(b.f7107a[i]);
                return;
            }
            int c = c(i - b.f7107a.length);
            if (c >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.f7108a;
                if (c < aVarArr.length) {
                    this.e.add(aVarArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int c(int i) {
            return this.b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new okhttp3.internal.http2.a(f(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new okhttp3.internal.http2.a(b.a(c()), c()));
        }

        private void e(int i) throws IOException {
            a(-1, new okhttp3.internal.http2.a(f(i), c()));
        }

        private void g() throws IOException {
            a(-1, new okhttp3.internal.http2.a(b.a(c()), c()));
        }

        private ByteString f(int i) throws IOException {
            if (g(i)) {
                return b.f7107a[i].g;
            }
            int c = c(i - b.f7107a.length);
            if (c >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.f7108a;
                if (c < aVarArr.length) {
                    return aVarArr[c].g;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private boolean g(int i) {
            return i >= 0 && i <= b.f7107a.length - 1;
        }

        private void a(int i, okhttp3.internal.http2.a aVar) {
            this.e.add(aVar);
            int i2 = aVar.i;
            if (i != -1) {
                i2 -= this.f7108a[c(i)].i;
            }
            int i3 = this.h;
            if (i2 > i3) {
                e();
                return;
            }
            int a2 = a((this.d + i2) - i3);
            if (i == -1) {
                int i4 = this.c + 1;
                okhttp3.internal.http2.a[] aVarArr = this.f7108a;
                if (i4 > aVarArr.length) {
                    okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.b = this.f7108a.length - 1;
                    this.f7108a = aVarArr2;
                }
                int i5 = this.b;
                this.b = i5 - 1;
                this.f7108a[i5] = aVar;
                this.c++;
            } else {
                this.f7108a[i + c(i) + a2] = aVar;
            }
            this.d += i2;
        }

        private int h() throws IOException {
            return this.f.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int h = h();
                if ((h & 128) == 0) {
                    return i2 + (h << i4);
                }
                i2 += (h & Notifications.NOTIFICATION_TYPES_ALL) << i4;
                i4 += 7;
            }
        }

        ByteString c() throws IOException {
            int h = h();
            boolean z = (h & 128) == 128;
            int a2 = a(h, Notifications.NOTIFICATION_TYPES_ALL);
            if (z) {
                return ByteString.a(i.a().a(this.f.h(a2)));
            }
            return this.f.d(a2);
        }
    }

    private static Map<ByteString, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f7107a.length);
        int i = 0;
        while (true) {
            okhttp3.internal.http2.a[] aVarArr = f7107a;
            if (i < aVarArr.length) {
                if (!linkedHashMap.containsKey(aVarArr[i].g)) {
                    linkedHashMap.put(f7107a[i].g, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0232b {

        /* renamed from: a, reason: collision with root package name */
        int f7109a;
        int b;
        okhttp3.internal.http2.a[] c;
        int d;
        int e;
        int f;
        private final okio.c g;
        private final boolean h;
        private int i;
        private boolean j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0232b(okio.c cVar) {
            this(4096, true, cVar);
        }

        C0232b(int i, boolean z, okio.c cVar) {
            this.i = Integer.MAX_VALUE;
            this.c = new okhttp3.internal.http2.a[8];
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
            this.f7109a = i;
            this.b = i;
            this.h = z;
            this.g = cVar;
        }

        private void a() {
            Arrays.fill(this.c, (Object) null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    if (length < this.d || i <= 0) {
                        break;
                    }
                    i -= this.c[length].i;
                    this.f -= this.c[length].i;
                    this.e--;
                    i2++;
                }
                okhttp3.internal.http2.a[] aVarArr = this.c;
                int i3 = this.d;
                System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i2, this.e);
                okhttp3.internal.http2.a[] aVarArr2 = this.c;
                int i4 = this.d;
                Arrays.fill(aVarArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                this.d += i2;
            }
            return i2;
        }

        private void a(okhttp3.internal.http2.a aVar) {
            int i = aVar.i;
            int i2 = this.b;
            if (i > i2) {
                a();
                return;
            }
            b((this.f + i) - i2);
            int i3 = this.e + 1;
            okhttp3.internal.http2.a[] aVarArr = this.c;
            if (i3 > aVarArr.length) {
                okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.d = this.c.length - 1;
                this.c = aVarArr2;
            }
            int i4 = this.d;
            this.d = i4 - 1;
            this.c[i4] = aVar;
            this.e++;
            this.f += i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<okhttp3.internal.http2.a> list) throws IOException {
            int i;
            int i2;
            if (this.j) {
                int i3 = this.i;
                if (i3 < this.b) {
                    a(i3, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                a(this.b, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                okhttp3.internal.http2.a aVar = list.get(i4);
                ByteString f = aVar.g.f();
                ByteString byteString = aVar.h;
                Integer num = b.b.get(f);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        if (okhttp3.internal.c.a(b.f7107a[i - 1].h, byteString)) {
                            i2 = i;
                        } else if (okhttp3.internal.c.a(b.f7107a[i].h, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.d + 1;
                    int length = this.c.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (okhttp3.internal.c.a(this.c[i5].g, f)) {
                            if (okhttp3.internal.c.a(this.c[i5].h, byteString)) {
                                i = b.f7107a.length + (i5 - this.d);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.d) + b.f7107a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    a(i, Notifications.NOTIFICATION_TYPES_ALL, 128);
                } else if (i2 == -1) {
                    this.g.i(64);
                    a(f);
                    a(byteString);
                    a(aVar);
                } else if (f.a(okhttp3.internal.http2.a.f7106a) && !okhttp3.internal.http2.a.f.equals(f)) {
                    a(i2, 15, 0);
                    a(byteString);
                } else {
                    a(i2, 63, 64);
                    a(byteString);
                    a(aVar);
                }
            }
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.g.i(i | i3);
                return;
            }
            this.g.i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.g.i(128 | (i4 & Notifications.NOTIFICATION_TYPES_ALL));
                i4 >>>= 7;
            }
            this.g.i(i4);
        }

        void a(ByteString byteString) throws IOException {
            if (this.h && i.a().a(byteString) < byteString.g()) {
                okio.c cVar = new okio.c();
                i.a().a(byteString, cVar);
                ByteString o = cVar.o();
                a(o.g(), Notifications.NOTIFICATION_TYPES_ALL, 128);
                this.g.b(o);
                return;
            }
            a(byteString.g(), Notifications.NOTIFICATION_TYPES_ALL, 0);
            this.g.b(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f7109a = i;
            int min = Math.min(i, 16384);
            int i2 = this.b;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.i = Math.min(this.i, min);
            }
            this.j = true;
            this.b = min;
            b();
        }

        private void b() {
            int i = this.b;
            int i2 = this.f;
            if (i < i2) {
                if (i == 0) {
                    a();
                } else {
                    b(i2 - i);
                }
            }
        }
    }

    static ByteString a(ByteString byteString) throws IOException {
        int g = byteString.g();
        for (int i = 0; i < g; i++) {
            byte a2 = byteString.a(i);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.a());
            }
        }
        return byteString;
    }
}
