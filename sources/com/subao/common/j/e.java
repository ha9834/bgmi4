package com.subao.common.j;

import android.os.ConditionVariable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.subao.common.e.an;
import com.subao.common.e.f;
import com.subao.common.j.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static c f6072a;
    private static InterfaceC0173e b = new f();
    private static final com.subao.common.m.c c = new com.subao.common.m.c();

    /* loaded from: classes2.dex */
    public interface a {
        void a(Object obj, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.subao.common.j.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0173e {
        c a(String str);

        boolean a();
    }

    private e() {
    }

    public static void a() {
        a(null);
    }

    public static synchronized c b() {
        c cVar;
        synchronized (e.class) {
            synchronized (e.class) {
                cVar = f6072a;
            }
            return cVar;
        }
        if (com.subao.common.d.a("SubaoNet")) {
            Log.d("SubaoNet", "getMyInfo(): " + com.subao.common.n.h.a(cVar));
        }
        return cVar;
    }

    static synchronized void a(c cVar) {
        synchronized (e.class) {
            f6072a = cVar;
        }
    }

    public static void a(boolean z, an anVar) {
        boolean a2 = b.a();
        if (z) {
            b = new g(anVar);
            if (a2) {
                return;
            }
            a();
            return;
        }
        b = new f();
    }

    public static void a(String str, a aVar, Object obj) {
        a(str, aVar, obj, (InterfaceC0173e) null);
    }

    public static void a(String str, a aVar, Object obj, an anVar) {
        a(str, aVar, obj, new g(anVar));
    }

    private static void a(String str, a aVar, Object obj, InterfaceC0173e interfaceC0173e) {
        c.execute(new d(interfaceC0173e, str, new b(aVar, obj)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final a f6073a;
        final Object b;

        b(a aVar, Object obj) {
            this.f6073a = aVar;
            this.b = obj;
        }

        void a(c cVar) {
            a aVar = this.f6073a;
            if (aVar != null) {
                aVar.a(this.b, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0173e f6075a;
        private final String b;
        private final b c;

        d(InterfaceC0173e interfaceC0173e, String str, b bVar) {
            this.f6075a = interfaceC0173e == null ? e.b : interfaceC0173e;
            this.b = str;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            try {
                cVar = this.f6075a.a(this.b);
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
                cVar = null;
            }
            if (TextUtils.isEmpty(this.b)) {
                e.a(cVar);
            }
            if (com.subao.common.d.a("SubaoNet")) {
                com.subao.common.d.a("SubaoNet", "IPInfoQuery Result: " + com.subao.common.n.h.a(cVar));
            }
            a(cVar);
        }

        private void a(c cVar) {
            this.c.a(cVar);
        }
    }

    public static String c() {
        c b2 = b();
        return (b2 == null || TextUtils.isEmpty(b2.f6074a)) ? "" : b2.f6074a;
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f6074a;
        public final int b;
        public final int c;
        public final String d;

        public c(String str, int i, int i2, String str2) {
            this.f6074a = str;
            this.b = i;
            this.c = i2;
            this.d = str2;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b == cVar.b && this.c == cVar.c && com.subao.common.e.a(this.f6074a, cVar.f6074a) && com.subao.common.e.a(this.d, cVar.d);
        }

        public String toString() {
            com.subao.common.e.j a2 = a();
            Locale locale = com.subao.common.e.r.f6001a;
            Object[] objArr = new Object[5];
            objArr[0] = this.f6074a;
            objArr[1] = Integer.valueOf(this.b);
            objArr[2] = Integer.valueOf(this.c);
            objArr[3] = a2 == null ? "unknown" : Integer.toString(a2.d);
            objArr[4] = this.d;
            return String.format(locale, "[%s, (%d.%d (%s)) (%s)]", objArr);
        }

        public com.subao.common.e.j a() {
            int i = this.c;
            if (i == 2) {
                return com.subao.common.e.j.CHINA_MOBILE;
            }
            if (i == 4) {
                return com.subao.common.e.j.CHINA_UNICOM;
            }
            if (i != 8) {
                return null;
            }
            return com.subao.common.e.j.CHINA_TELECOM;
        }
    }

    /* loaded from: classes2.dex */
    static class f implements InterfaceC0173e {
        @Override // com.subao.common.j.e.InterfaceC0173e
        public boolean a() {
            return false;
        }

        f() {
        }

        @Override // com.subao.common.j.e.InterfaceC0173e
        public c a(String str) {
            if (str != null && str.length() > 0) {
                throw new UnsupportedOperationException();
            }
            InetAddress a2 = a.a(com.subao.common.e.f.b(f.g.ISP));
            if (a2 == null) {
                throw new UnknownHostException();
            }
            byte[] address = a2.getAddress();
            if (address != null) {
                int i = 4;
                if (address.length < 4 || address[0] != -84 || address[1] != 16) {
                    return null;
                }
                switch (address[3]) {
                    case 10:
                        i = 8;
                        break;
                    case 11:
                        break;
                    case 12:
                        i = 2;
                        break;
                    default:
                        i = 0;
                        break;
                }
                return new c(null, address[2], i, null);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class a {
            static InetAddress a(String str) {
                return InetAddress.getByName(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class g implements InterfaceC0173e {

        /* renamed from: a, reason: collision with root package name */
        private final an f6076a;

        @Override // com.subao.common.j.e.InterfaceC0173e
        public boolean a() {
            return true;
        }

        g(an anVar) {
            this.f6076a = anVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.subao.common.j.e.InterfaceC0173e
        public c a(String str) {
            a aVar;
            c cVar = null;
            Object[] objArr = 0;
            if (TextUtils.isEmpty(str)) {
                aVar = new a();
                com.subao.common.m.d.a(aVar);
            } else {
                aVar = null;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                cVar = b(str);
            } catch (IOException | RuntimeException unused) {
            }
            return (cVar != null || aVar == null) ? cVar : aVar.a(4000 - (SystemClock.elapsedRealtime() - elapsedRealtime));
        }

        private c b(String str) {
            b.c a2 = new com.subao.common.j.b(2000, 2000).a(c(str), (String) null);
            if (a2.f6066a != 200) {
                return null;
            }
            if (a2.b == null || a2.b.length == 0) {
                throw new IOException("Response Code is 200, but body is null");
            }
            return a(new ByteArrayInputStream(a2.b));
        }

        private URL c(String str) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("/resolve");
            if (!TextUtils.isEmpty(str)) {
                sb.append("?ip=");
                sb.append(str);
            }
            return new URL(this.f6076a.f5971a, this.f6076a.b, this.f6076a.c, sb.toString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private c a(InputStream inputStream) {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
            try {
                jsonReader.beginObject();
                String str = null;
                int i = -1;
                int i2 = 0;
                String str2 = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if ("ip".equals(nextName)) {
                        str = com.subao.common.n.g.b(jsonReader);
                    } else if ("ipLib".equals(nextName)) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            if ("province".equals(nextName2)) {
                                i = jsonReader.nextInt();
                            } else if ("operators".equals(nextName2)) {
                                i2 = jsonReader.nextInt();
                            } else if (ProductAction.ACTION_DETAIL.equals(nextName2)) {
                                str2 = com.subao.common.n.g.b(jsonReader);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                com.subao.common.e.a(jsonReader);
                return new c(str, i, i2, str2);
            } catch (Throwable th) {
                com.subao.common.e.a(jsonReader);
                throw th;
            }
        }

        /* loaded from: classes2.dex */
        private static class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final ConditionVariable f6077a;
            private volatile c b;

            private a() {
                this.f6077a = new ConditionVariable();
            }

            c a(long j) {
                c cVar;
                this.f6077a.block(j);
                synchronized (this) {
                    cVar = this.b;
                }
                return cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        c a2 = new f().a(null);
                        synchronized (this) {
                            this.b = a2;
                        }
                    } finally {
                        this.f6077a.open();
                    }
                } catch (IOException | RuntimeException unused) {
                }
            }
        }
    }
}
