package com.shieldtunnel.svpn.common.f;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.Constants;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.f.c;
import com.shieldtunnel.svpn.common.i.a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class k {
    private static final List<String> e = new ArrayList(8);

    /* renamed from: a, reason: collision with root package name */
    private final b f5818a;
    private int b;
    private final Object c;
    private final h d;

    /* loaded from: classes2.dex */
    public static abstract class b extends com.shieldtunnel.svpn.common.f.g {
        public b(String str, String str2, q qVar, com.shieldtunnel.svpn.common.i.h hVar) {
            super(str, str2, a(qVar), hVar);
        }

        private static q a(q qVar) {
            return qVar == null ? com.shieldtunnel.svpn.common.f.c.b(c.d.PORTAL) : qVar;
        }

        public abstract com.shieldtunnel.svpn.common.g.b a(String str);
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final l f5819a;
        public final int b;

        c(l lVar, int i) {
            this.f5819a = lVar;
            this.b = i;
        }

        public String toString() {
            Locale locale = com.shieldtunnel.svpn.common.f.f.b;
            Object[] objArr = new Object[2];
            l lVar = this.f5819a;
            objArr[0] = lVar == null ? Constants.NULL_VERSION_ID : Boolean.toString(lVar.e);
            objArr[1] = Integer.valueOf(this.b);
            return String.format(locale, "[Data=%s,Code=%d]", objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final a.c f5820a;
        final String b;
        final long c;

        d(a.c cVar, String str, long j) {
            this.f5820a = cVar;
            this.b = str;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        private final String f5822a;
        private final boolean b;

        f(String str, boolean z) {
            this.f5822a = str;
            this.b = z;
        }

        private d b() {
            int h = k.this.h();
            HttpURLConnection a2 = new com.shieldtunnel.svpn.common.i.a(h, h).a(k.this.c(), a.b.GET, a.EnumC0156a.JSON.f5839a);
            com.shieldtunnel.svpn.common.i.a.a(a2, k.this.g());
            String str = this.f5822a;
            if (str != null) {
                a2.setRequestProperty(Headers.GET_OBJECT_IF_NONE_MATCH, str);
                if (this.b) {
                    k.this.b("Cache TAG: " + this.f5822a);
                }
            }
            return new d(com.shieldtunnel.svpn.common.i.a.a(a2), a2.getHeaderField(Headers.ETAG), k.b(a2));
        }

        d a() {
            d b;
            int max = Math.max(k.this.k(), 0) + 1;
            k.this.b = 0;
            for (int i = 0; i < max; i++) {
                long a2 = g.a(i);
                if (a2 > 0) {
                    SystemClock.sleep(a2);
                }
                k.d(k.this);
                try {
                    b = b();
                } catch (IOException e) {
                    if (this.b) {
                        k.this.b(e.getMessage());
                    }
                } catch (RuntimeException e2) {
                    if (!this.b) {
                        return null;
                    }
                    k.this.b(e2.getMessage());
                    return null;
                }
                if (b.f5820a.f5841a != 500) {
                    return b;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g {
        static int a() {
            return 3;
        }

        static long a(int i) {
            if (i <= 0) {
                return 0L;
            }
            return (((long) (Math.random() * 4000.0d)) + 3000) * i;
        }
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private k f5823a;
        private l b;
        private final boolean c;

        i(k kVar, l lVar, boolean z) {
            this.f5823a = kVar;
            this.b = lVar;
            this.c = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            k kVar = this.f5823a;
            if (kVar != null) {
                try {
                    kVar.a(kVar.a(this.b, this.c));
                } finally {
                    kVar.o();
                    h hVar = kVar.d;
                    this.b = null;
                    this.f5823a = null;
                    if (hVar != null) {
                        hVar.a();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(b bVar) {
        this(bVar, null);
    }

    static /* synthetic */ int d(k kVar) {
        int i2 = kVar.b + 1;
        kVar.b = i2;
        return i2;
    }

    private com.shieldtunnel.svpn.common.g.b j() {
        return this.f5818a.a(b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        return g.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m() {
        return com.shieldtunnel.svpn.common.b.a(LogTag.DATA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        synchronized (e) {
            e.remove(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(l lVar) {
        return lVar != null;
    }

    protected abstract String e();

    public b f() {
        return this.f5818a;
    }

    protected String g() {
        return a.EnumC0156a.JSON.f5839a;
    }

    protected int h() {
        return 7000;
    }

    protected abstract String i();

    protected abstract String l();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.shieldtunnel.svpn.common.g.b] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public l n() {
        l lVar;
        InputStream inputStream;
        String message;
        ?? j = j();
        synchronized (this.c) {
            lVar = null;
            try {
                if (j.d()) {
                    try {
                        inputStream = j.e();
                        try {
                            l a2 = l.a(inputStream);
                            com.shieldtunnel.svpn.common.c.a((Closeable) inputStream);
                            lVar = a2;
                            message = null;
                            j = inputStream;
                        } catch (IOException e2) {
                            e = e2;
                            message = e.getMessage();
                            com.shieldtunnel.svpn.common.c.a((Closeable) inputStream);
                            j = inputStream;
                            c(message);
                            return lVar;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        inputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        j = 0;
                        com.shieldtunnel.svpn.common.c.a((Closeable) j);
                        throw th;
                    }
                } else {
                    message = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        c(message);
        return lVar;
    }

    protected k(b bVar, h hVar) {
        this.c = new Object();
        this.f5818a = bVar;
        this.d = hVar;
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

    private void c(String str) {
        if (str != null) {
            Log.w(LogTag.DATA, a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        com.shieldtunnel.svpn.common.g.b j = j();
        synchronized (this.c) {
            j.b();
        }
    }

    URL c() {
        String format = String.format("/api/%s/%s/%s", e(), this.f5818a.f5811a, l());
        q qVar = this.f5818a.c;
        return new URL(qVar.f5827a, qVar.b, qVar.c, format);
    }

    private String a(String str) {
        return "Portal." + i() + ": " + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(l lVar) {
        return lVar != null && com.shieldtunnel.svpn.common.c.a(this.f5818a.b, lVar.e());
    }

    private boolean a() {
        boolean z;
        String i2 = i();
        synchronized (e) {
            if (e.contains(i2)) {
                z = false;
            } else {
                e.add(i2);
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(l lVar) {
        String message;
        OutputStream a2;
        if (m()) {
            b("Save data, expire time: " + com.shieldtunnel.svpn.common.k.a.a(com.shieldtunnel.svpn.common.k.a.a(lVar.d()), 7));
        }
        com.shieldtunnel.svpn.common.g.b j = j();
        synchronized (this.c) {
            OutputStream outputStream = null;
            try {
                try {
                    a2 = j.a(false);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                lVar.a(a2);
                com.shieldtunnel.svpn.common.c.a(a2);
                message = null;
            } catch (IOException e3) {
                e = e3;
                outputStream = a2;
                message = e.getMessage();
                com.shieldtunnel.svpn.common.c.a(outputStream);
                c(message);
            } catch (Throwable th2) {
                th = th2;
                outputStream = a2;
                com.shieldtunnel.svpn.common.c.a(outputStream);
                throw th;
            }
        }
        c(message);
    }

    c a(l lVar, boolean z) {
        boolean m = m();
        if (z) {
            lVar = n();
            if (m) {
                b("Load from file: " + com.shieldtunnel.svpn.common.k.e.a(lVar));
            }
        } else if (m) {
            b("Use init data: " + com.shieldtunnel.svpn.common.k.e.a(lVar));
        }
        boolean z2 = lVar != null && c(lVar);
        if (z2) {
            long currentTimeMillis = System.currentTimeMillis() - lVar.d();
            if (currentTimeMillis < 0) {
                if (currentTimeMillis > -3600000) {
                    if (m) {
                        b("Data not expired: " + (currentTimeMillis / 1000));
                    }
                    return new c(lVar, 0);
                }
                if (m) {
                    b("Too large cache alive time: " + (currentTimeMillis / 1000));
                }
            }
        }
        if (m) {
            b("Try download from network ...");
        }
        d a2 = new f(z2 ? lVar.a() : null, m).a();
        if (a2 == null) {
            return new c(lVar, 0);
        }
        e eVar = new e();
        if (!z2) {
            lVar = null;
        }
        return eVar.a(a2, lVar, m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e {
        private e() {
        }

        private l b(d dVar, l lVar, boolean z) {
            if (z) {
                k.this.b("Portal data not modified.");
            }
            if (lVar != null) {
                lVar.a(dVar.c);
                k.this.d(lVar);
            }
            return lVar;
        }

        private c c(d dVar, l lVar, boolean z) {
            l lVar2 = new l(dVar.b, dVar.c, k.this.f5818a.b, dVar.f5820a.b, true);
            if (k.this.a(lVar2)) {
                if (z) {
                    k.this.b("Serialize download data " + lVar2);
                }
                k.this.d(lVar2);
                return new c(lVar2, dVar.f5820a.f5841a);
            }
            k.this.b("Invalid download data " + lVar2);
            return new c(lVar, dVar.f5820a.f5841a);
        }

        c a(d dVar, l lVar, boolean z) {
            int i = dVar.f5820a.f5841a;
            if (i == 200) {
                return c(dVar, lVar, z);
            }
            if (i == 304) {
                return new c(b(dVar, lVar, z), i);
            }
            if (i != 404) {
                if (z) {
                    k.this.b("Server response: " + i);
                }
                return new c(lVar, i);
            }
            a(z);
            return new c(null, i);
        }

        private void a(boolean z) {
            if (z) {
                k.this.b("Response 404 not found, remove local cache.");
            }
            k.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        if (str != null) {
            Log.d(LogTag.DATA, a(str));
        }
    }

    private String b() {
        return i() + ".portal2";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(l lVar) {
        return b(lVar, false);
    }

    protected boolean b(l lVar, boolean z) {
        boolean a2 = a();
        if (a2) {
            com.shieldtunnel.svpn.common.j.c.a(new i(this, lVar, z));
        }
        if (m()) {
            b("execute() return: " + a2);
        }
        return a2;
    }
}
