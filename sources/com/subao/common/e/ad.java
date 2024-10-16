package com.subao.common.e;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.Headers;
import com.helpshift.util.ErrorReportProvider;
import com.subao.common.e.f;
import com.subao.common.j.b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ad {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f5955a = new ArrayList(8);
    private static volatile long b = g() - ErrorReportProvider.BATCH_TIME;
    private final a c;
    private final Object d;
    private final g e;

    /* loaded from: classes2.dex */
    public interface g {
        void a();
    }

    protected abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ae aeVar) {
    }

    protected abstract String b();

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        return "v1";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(ae aeVar) {
        return aeVar != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(a aVar) {
        this(aVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(a aVar, g gVar) {
        this.d = new Object();
        this.c = aVar;
        this.e = gVar;
    }

    public static long g() {
        return SystemClock.elapsedRealtime();
    }

    public static synchronized long h() {
        long j;
        synchronized (ad.class) {
            j = b;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return com.subao.common.d.a("SubaoData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(Headers.CACHE_CONTROL);
        if (TextUtils.isEmpty(headerField) || headerField.length() <= 8 || !headerField.startsWith("max-age=")) {
            return 0L;
        }
        try {
            long parseLong = Long.parseLong(headerField.substring(8));
            if (parseLong <= 0) {
                return 0L;
            }
            long j = parseLong * 1000;
            return (j <= 3600000 ? j : 3600000L) + System.currentTimeMillis();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        if (str != null) {
            Log.d("SubaoData", c(str));
        }
    }

    private void b(String str) {
        if (str != null) {
            Log.w("SubaoData", c(str));
        }
    }

    private String c(String str) {
        return "Portal." + b() + ": " + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public URL d() {
        return new URL(this.c.c.f5971a, this.c.c.b, this.c.c.c, String.format("/api/%s/%s/%s", c(), this.c.f6011a, a()));
    }

    private String e() {
        return b() + ".portal2";
    }

    private com.subao.common.f.c f() {
        return this.c.a(e());
    }

    protected String j() {
        return b.a.JSON.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.subao.common.f.c] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public ae k() {
        String str;
        InputStream inputStream;
        ae aeVar;
        ?? f2 = f();
        synchronized (this.d) {
            str = null;
            try {
                if (f2.a()) {
                    try {
                        inputStream = f2.b();
                        try {
                            aeVar = ae.a(inputStream);
                            com.subao.common.e.a((Closeable) inputStream);
                            f2 = inputStream;
                        } catch (IOException e2) {
                            e = e2;
                            String message = e.getMessage();
                            com.subao.common.e.a((Closeable) inputStream);
                            str = message;
                            aeVar = null;
                            f2 = inputStream;
                            b(str);
                            return aeVar;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        inputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        f2 = 0;
                        com.subao.common.e.a((Closeable) f2);
                        throw th;
                    }
                } else {
                    aeVar = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        b(str);
        return aeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l() {
        com.subao.common.f.c f2 = f();
        synchronized (this.d) {
            f2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ae aeVar) {
        return aeVar != null && com.subao.common.e.a(this.c.b, aeVar.d());
    }

    public final a m() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(ae aeVar) {
        return a(aeVar, false);
    }

    protected boolean a(ae aeVar, boolean z) {
        boolean n = n();
        if (n) {
            com.subao.common.m.d.a(new h(this, aeVar, z));
        }
        if (i()) {
            a("execute() return: " + n);
        }
        return n;
    }

    private boolean n() {
        boolean z;
        String b2 = b();
        synchronized (f5955a) {
            if (f5955a.contains(b2)) {
                z = false;
            } else {
                f5955a.add(b2);
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        synchronized (f5955a) {
            f5955a.remove(b());
        }
    }

    ae b(ae aeVar, boolean z) {
        boolean i = i();
        if (z) {
            aeVar = k();
            if (i) {
                a("Load from file: " + com.subao.common.n.h.a(aeVar));
            }
        } else if (i) {
            a("Use init data: " + com.subao.common.n.h.a(aeVar));
        }
        boolean z2 = aeVar != null && d(aeVar);
        if (z2) {
            long currentTimeMillis = System.currentTimeMillis() - aeVar.e();
            if (currentTimeMillis < 0) {
                if (currentTimeMillis > -3600000) {
                    if (i) {
                        a("Data not expired: " + (currentTimeMillis / 1000));
                    }
                    return aeVar;
                }
                if (i) {
                    a("Too large cache alive time: " + (currentTimeMillis / 1000));
                }
            }
        }
        if (i) {
            a("Try download from network ...");
        }
        c a2 = new e(z2 ? aeVar.c() : null, i).a();
        if (a2 == null) {
            return aeVar;
        }
        synchronized (ad.class) {
            b = g();
        }
        d dVar = new d();
        if (!z2) {
            aeVar = null;
        }
        return dVar.a(a2, aeVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ae aeVar) {
        String message;
        OutputStream c2;
        if (i()) {
            a("Save data, expire time: " + com.subao.common.n.c.a(com.subao.common.n.c.b(aeVar.e()), 7));
        }
        com.subao.common.f.c f2 = f();
        synchronized (this.d) {
            OutputStream outputStream = null;
            try {
                try {
                    c2 = f2.c();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                aeVar.a(c2);
                com.subao.common.e.a(c2);
                message = null;
            } catch (IOException e3) {
                e = e3;
                outputStream = c2;
                message = e.getMessage();
                com.subao.common.e.a(outputStream);
                b(message);
            } catch (Throwable th2) {
                th = th2;
                outputStream = c2;
                com.subao.common.e.a(outputStream);
                throw th;
            }
        }
        b(message);
    }

    /* loaded from: classes2.dex */
    public static abstract class a extends w {
        private final boolean e;

        public abstract com.subao.common.f.c a(String str);

        public a(String str, String str2, an anVar, boolean z, com.subao.common.j.l lVar) {
            super(str, str2, a(anVar), lVar);
            this.e = z;
        }

        private static an a(an anVar) {
            return anVar == null ? com.subao.common.e.f.a(f.g.PORTAL) : anVar;
        }

        public boolean a() {
            return this.e;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends a {
        private final a e;

        public b(a aVar) {
            super("common", aVar.b, aVar.c, aVar.e, aVar.d);
            this.e = aVar;
        }

        @Override // com.subao.common.e.ad.a
        public com.subao.common.f.c a(String str) {
            return this.e.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private ad f5959a;
        private ae b;
        private final boolean c;

        h(ad adVar, ae aeVar, boolean z) {
            this.f5959a = adVar;
            this.b = aeVar;
            this.c = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            ad adVar = this.f5959a;
            if (adVar != null) {
                try {
                    ae b = adVar.b(this.b, this.c);
                    if (b != null && adVar.m().a()) {
                        b = a(b);
                    }
                    adVar.a(b);
                } finally {
                    adVar.o();
                    g gVar = adVar.e;
                    this.b = null;
                    this.f5959a = null;
                    if (gVar != null) {
                        gVar.a();
                    }
                }
            }
        }

        private static ae a(ae aeVar) {
            byte[] a2 = aeVar.a();
            if (a2 == null) {
                return aeVar;
            }
            try {
                return new ae(aeVar.c(), aeVar.e(), aeVar.d(), ac.a(a2), aeVar.d);
            } catch (IOException unused) {
                Log.w("SubaoData", "Decode failed");
                return aeVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final b.c f5956a;
        public final String b;
        public final long c;

        c(b.c cVar, String str, long j) {
            this.f5956a = cVar;
            this.b = str;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e {
        private final String b;
        private final boolean c;

        e(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        c a() {
            int max = Math.max(f.a(), 0) + 1;
            for (int i = 0; i < max; i++) {
                long a2 = f.a(i);
                if (a2 > 0) {
                    SystemClock.sleep(a2);
                }
                try {
                    return b();
                } catch (IOException e) {
                    if (this.c) {
                        ad.this.a(e.getMessage());
                    }
                } catch (RuntimeException e2) {
                    if (!this.c) {
                        return null;
                    }
                    ad.this.a(e2.getMessage());
                    return null;
                }
            }
            return null;
        }

        private c b() {
            HttpURLConnection a2 = new com.subao.common.j.b(7000, 7000).a(ad.this.d(), b.EnumC0172b.GET, b.a.JSON.e);
            com.subao.common.j.b.b(a2, ad.this.j());
            String str = this.b;
            if (str != null) {
                a2.setRequestProperty(Headers.GET_OBJECT_IF_NONE_MATCH, str);
                if (this.c) {
                    ad.this.a("Cache TAG: " + this.b);
                }
            }
            return new c(com.subao.common.j.b.b(a2), a2.getHeaderField(Headers.ETAG), ad.b(a2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        private d() {
        }

        ae a(c cVar, ae aeVar, boolean z) {
            int i = cVar.f5956a.f6066a;
            if (i == 200) {
                return c(cVar, aeVar, z);
            }
            if (i == 304) {
                return b(cVar, aeVar, z);
            }
            if (i == 404) {
                return a(z);
            }
            if (z) {
                ad.this.a("Server response: " + cVar.f5956a.f6066a);
            }
            return aeVar;
        }

        private ae a(boolean z) {
            if (z) {
                ad.this.a("Response 404 not found, remove local cache.");
            }
            ad.this.l();
            return null;
        }

        private ae b(c cVar, ae aeVar, boolean z) {
            if (z) {
                ad.this.a("Portal data not modified.");
            }
            if (aeVar != null) {
                aeVar.a(cVar.c);
                ad.this.b(aeVar);
            }
            return aeVar;
        }

        private ae c(c cVar, ae aeVar, boolean z) {
            ae aeVar2 = new ae(cVar.b, cVar.c, ad.this.c.b, cVar.f5956a.b, true);
            if (ad.this.c(aeVar2)) {
                if (z) {
                    ad.this.a("Serialize download data " + aeVar2);
                }
                ad.this.b(aeVar2);
                return aeVar2;
            }
            ad.this.a("Invalid download data " + aeVar2);
            return aeVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static int a() {
            return 3;
        }

        public static long a(int i) {
            if (i <= 0) {
                return 0L;
            }
            return (((long) (Math.random() * 4000.0d)) + 3000) * i;
        }
    }
}
