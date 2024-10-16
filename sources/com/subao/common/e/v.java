package com.subao.common.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.subao.common.e.f;
import com.subao.common.j.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private final b.EnumC0172b f6006a;
    protected final a b;
    protected final d c;
    private final byte[] d;

    protected abstract int a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
    }

    protected abstract String b();

    protected boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(a aVar, d dVar, b.EnumC0172b enumC0172b, byte[] bArr) {
        this.b = aVar;
        this.c = dVar;
        this.f6006a = enumC0172b;
        this.d = bArr;
    }

    private static void a(URLConnection uRLConnection, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        uRLConnection.setRequestProperty(str, str2);
    }

    public void a(Executor executor) {
        executor.execute(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(URL url) {
        HttpURLConnection httpURLConnection;
        b.c cVar = null;
        try {
            httpURLConnection = new com.subao.common.j.b(15000, 15000).a(url, this.f6006a, b.a.JSON.e);
            try {
                if (d() && !TextUtils.isEmpty(this.c.b)) {
                    httpURLConnection.addRequestProperty("Authorization", "Bearer " + this.c.b);
                }
                a(httpURLConnection, "userId", this.c.f6010a);
                a(httpURLConnection, SDKConstants.PARAM_ACCESS_TOKEN, this.c.c);
                switch (this.f6006a) {
                    case GET:
                    case DELETE:
                        cVar = com.subao.common.j.b.b(httpURLConnection);
                        break;
                    default:
                        cVar = com.subao.common.j.b.a(httpURLConnection, this.d);
                        break;
                }
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                return new b(httpURLConnection, cVar);
            } catch (RuntimeException e2) {
                e = e2;
                e.printStackTrace();
                return new b(httpURLConnection, cVar);
            }
        } catch (IOException | RuntimeException e3) {
            e = e3;
            httpURLConnection = null;
        }
        return new b(httpURLConnection, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public URL e() {
        return new URL(c(), this.b.c.b, this.b.c.c, b());
    }

    protected String c() {
        return this.b.c.f5971a;
    }

    /* loaded from: classes2.dex */
    public static class a extends w {
        public a(String str, String str2, an anVar, com.subao.common.j.l lVar) {
            super(str, str2, a(anVar), lVar);
        }

        private static an a(an anVar) {
            return anVar == null ? f.a(f.g.HR) : anVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f6010a;
        public final String b;
        public final String c;

        public d(String str, String str2) {
            this(str, str2, null);
        }

        public d(String str, String str2, String str3) {
            this.f6010a = str;
            this.b = str2;
            this.c = str3;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return com.subao.common.e.a(this.f6010a, dVar.f6010a) && com.subao.common.e.a(this.b, dVar.b) && com.subao.common.e.a(this.c, dVar.c);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final HttpURLConnection f6008a;
        public final b.c b;

        public b(HttpURLConnection httpURLConnection, b.c cVar) {
            this.f6008a = httpURLConnection;
            this.b = cVar;
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private c() {
        }

        private b a() {
            try {
                URL e = v.this.e();
                int a2 = v.this.a();
                int i = 10000;
                while (true) {
                    b a3 = v.this.a(e);
                    if (a2 <= 0) {
                        return a3;
                    }
                    if (a3.b != null && a3.b.f6066a != 500) {
                        return a3;
                    }
                    SystemClock.sleep(i);
                    a2--;
                    i *= 2;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(a());
        }
    }
}
