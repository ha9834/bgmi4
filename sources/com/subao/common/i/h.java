package com.subao.common.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.Log;
import com.subao.common.e.aa;
import com.subao.common.e.al;
import com.subao.common.e.an;
import com.subao.common.e.ao;
import com.subao.common.i.d;
import com.subao.common.i.f;
import com.subao.common.i.n;
import com.subao.common.i.o;
import com.subao.common.i.p;
import com.subao.common.j.b;
import com.subao.common.j.l;
import com.subao.vpn.VPNJni;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public class h implements g {

    /* renamed from: a, reason: collision with root package name */
    final a f6031a;

    static boolean a() {
        return false;
    }

    private h(an anVar, i iVar) {
        this.f6031a = new a(anVar, iVar);
        this.f6031a.b();
    }

    public static g a(an anVar, i iVar) {
        h hVar = new h(anVar, iVar);
        a aVar = hVar.f6031a;
        aVar.getClass();
        aVar.post(new a.p());
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(com.subao.common.c cVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream));
        try {
            cVar.serialize(jsonWriter);
            com.subao.common.e.a(jsonWriter);
            if (com.subao.common.d.a("SubaoMessage")) {
                Log.d("SubaoMessage", byteArrayOutputStream.toString());
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            com.subao.common.e.a(jsonWriter);
            throw th;
        }
    }

    static boolean b() {
        int accelerationStatus = VPNJni.getAccelerationStatus(0);
        return accelerationStatus == 0 || accelerationStatus == 1 || accelerationStatus == 3 || accelerationStatus == 5 || !VPNJni.getProxyIsStart(0);
    }

    @Override // com.subao.common.i.g
    public void a(int i, int i2, List<l> list) {
        a aVar = this.f6031a;
        aVar.getClass();
        aVar.post(new a.n(i, i2, list));
    }

    @Override // com.subao.common.i.g
    public void a(String str, String str2) {
        a aVar = this.f6031a;
        aVar.getClass();
        aVar.post(new a.g(str, str2));
    }

    @Override // com.subao.common.i.g
    public void a(n nVar) {
        a aVar = this.f6031a;
        aVar.getClass();
        aVar.post(new a.C0170h(nVar));
    }

    @Override // com.subao.common.i.g
    public void a(n.a aVar) {
        if (aVar != null) {
            a aVar2 = this.f6031a;
            aVar2.getClass();
            aVar2.post(new a.f(aVar));
        }
    }

    @Override // com.subao.common.i.g
    public void a(String str) {
        a aVar = this.f6031a;
        aVar.getClass();
        aVar.post(new a.i(str));
    }

    @Override // com.subao.common.i.g
    public void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Log.w("SubaoMessage", "Empty or Null message id");
            return;
        }
        if (str2 == null) {
            Log.w("SubaoMessage", "Null Message Body");
            return;
        }
        if (com.subao.common.d.a("SubaoMessage")) {
            Log.d("SubaoMessage", String.format("onLinkMsg, id=%s, finish=%b, body:\n%s", str, Boolean.valueOf(z), str2));
        }
        byte[] bytes = str2.getBytes();
        try {
            this.f6031a.a().f().a(str, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (z) {
            a aVar = this.f6031a;
            aVar.getClass();
            aVar.post(new a.k(str, bytes));
        }
    }

    @Override // com.subao.common.i.g
    public void b(String str) {
        if (str != null && str.length() > 0) {
            a aVar = this.f6031a;
            aVar.getClass();
            aVar.post(new a.l(str));
            return;
        }
        Log.w("SubaoMessage", "Empty or Null Qos from JNI");
    }

    @Override // com.subao.common.i.g
    public void a(p.c cVar) {
        if (a()) {
            a aVar = this.f6031a;
            aVar.getClass();
            aVar.post(new a.d(cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final com.subao.common.i.i f6033a;
        final an b;
        final com.subao.common.i.m c;
        private final com.subao.common.i.l d;
        private int e;

        a(an anVar, com.subao.common.i.i iVar) {
            super(c());
            this.e = 15000;
            this.b = anVar;
            this.f6033a = iVar;
            this.d = com.subao.common.i.a.a(iVar.a());
            this.c = new com.subao.common.i.m(iVar.a());
        }

        private static Looper c() {
            HandlerThread handlerThread = new HandlerThread("subao_mu");
            handlerThread.start();
            return handlerThread.getLooper();
        }

        com.subao.common.i.i a() {
            return this.f6033a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public p.d d() {
            return new p.d(e(), com.subao.common.j.m.a(this.f6033a.a(), this.f6033a.b()));
        }

        private p.e e() {
            l.a a2 = this.f6033a.b().a();
            if (a2 == null) {
                return p.e.UNKNOWN_NETWORKTYPE;
            }
            switch (a2) {
                case MOBILE_2G:
                    return p.e.MOBILE_2G;
                case MOBILE_3G:
                    return p.e.MOBILE_3G;
                case MOBILE_4G:
                    return p.e.MOBILE_4G;
                case WIFI:
                    return p.e.WIFI;
                default:
                    return p.e.UNKNOWN_NETWORKTYPE;
            }
        }

        public void b() {
            if (ao.a(ao.b().c())) {
                return;
            }
            this.f6033a.a(new q(UUID.randomUUID().toString()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class q implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final String f6038a;

            q(String str) {
                this.f6038a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ao.b().b(this.f6038a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.subao.common.i.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public abstract class AbstractRunnableC0169a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final String f6034a;
            private byte[] c;
            private URL d;

            protected abstract void a(b.c cVar);

            protected abstract String b();

            protected abstract byte[] c();

            boolean d() {
                return true;
            }

            protected abstract void e();

            AbstractRunnableC0169a(String str) {
                this.f6034a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.c b;
                byte[] c;
                b.EnumC0172b a2 = a();
                if (a2 == null) {
                    throw new NullPointerException("Null HTTP method");
                }
                try {
                    HttpURLConnection a3 = new com.subao.common.j.b(a.this.e, a.this.e).a(f(), a2, b.a.JSON.e);
                    try {
                        com.subao.common.j.b.a(a3, b.a.JSON.e);
                        switch (a2) {
                            case DELETE:
                            case GET:
                                b = com.subao.common.j.b.b(a3);
                                break;
                            default:
                                if (d()) {
                                    if (this.c == null) {
                                        this.c = c();
                                    }
                                    c = this.c;
                                } else {
                                    c = c();
                                }
                                b = com.subao.common.j.b.a(a3, c);
                                break;
                        }
                        a(b);
                        a3.disconnect();
                    } catch (Throwable th) {
                        a3.disconnect();
                        throw th;
                    }
                } catch (IOException | RuntimeException unused) {
                    e();
                }
            }

            private URL f() {
                if (this.d == null) {
                    String b = b();
                    String str = a.this.b.f5971a;
                    String str2 = a.this.b.b;
                    int i = a.this.b.c;
                    if (b == null) {
                        b = "";
                    }
                    this.d = new URL(str, str2, i, b);
                }
                return this.d;
            }

            final void a(long j) {
                a.this.postDelayed(this, j);
            }

            protected b.EnumC0172b a() {
                return b.EnumC0172b.POST;
            }
        }

        /* loaded from: classes2.dex */
        class p implements Runnable {
            p() {
            }

            @Override // java.lang.Runnable
            public void run() {
                List<f.a> a2 = a.this.a().f().a(50);
                if (a2 == null || a2.isEmpty()) {
                    com.subao.common.d.a("SubaoMessage", "No cached link message(s)");
                    return;
                }
                for (f.a aVar : a2) {
                    a.this.post(new k(aVar.f6030a, aVar.b));
                }
                if (com.subao.common.d.a("SubaoMessage")) {
                    Log.d("SubaoMessage", String.format(com.subao.common.e.r.f6001a, "There are %d missed link(s)", Integer.valueOf(a2.size())));
                }
                a aVar2 = a.this;
                aVar2.postDelayed(new o(a2.size()), LogUtils.LOG_FUSE_TIME);
            }
        }

        /* loaded from: classes2.dex */
        class o implements Runnable {
            private final int b;

            o(int i) {
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.a.c()) {
                    a.this.post(new g("missed_link", Integer.toString(((this.b + 4) / 5) * 5)));
                    return;
                }
                Log.d("SubaoMessage", "Missed-Links event report is not allowed");
            }
        }

        /* loaded from: classes2.dex */
        class j extends AbstractRunnableC0169a {
            private final com.subao.common.i.o d;
            private int e;

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected String b() {
                return "/v3/report/client/installation/android";
            }

            j(com.subao.common.i.o oVar) {
                super("Installation");
                this.e = 10;
                this.d = oVar;
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                return h.b(this.d);
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected void e() {
                f();
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected void a(b.c cVar) {
                int i = cVar.f6066a;
                if (i != 500) {
                    switch (i) {
                        case 200:
                        case 201:
                            String a2 = com.subao.common.i.e.a(cVar.b);
                            if (a2 != null) {
                                a.this.f6033a.a(new q(a2));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                f();
            }

            private void f() {
                if (this.e <= 320) {
                    if (com.subao.common.d.a("SubaoMessage")) {
                        Log.d("SubaoMessage", String.format(com.subao.common.e.r.f6001a, "Installation message post failed, retry after %d seconds", Integer.valueOf(this.e)));
                    }
                    a(this.e * 1000);
                    this.e *= 2;
                    return;
                }
                com.subao.common.d.a("SubaoMessage", "Retry stopped");
            }
        }

        /* loaded from: classes2.dex */
        private abstract class b extends AbstractRunnableC0169a {
            private final int d;
            private final boolean e;
            private long f;
            private int g;

            b(a aVar, String str, int i) {
                this(aVar, str, i, LogUtils.LOG_FUSE_TIME);
            }

            b(a aVar, String str, int i, long j) {
                this(str, i, j, false);
            }

            b(String str, int i, long j, boolean z) {
                super(str);
                this.d = i;
                this.f = j;
                this.e = z;
            }

            final boolean f() {
                this.g++;
                if (this.g > this.d) {
                    return false;
                }
                a(this.f);
                if (this.e) {
                    this.f *= 2;
                }
                if (com.subao.common.d.a("SubaoMessage")) {
                    Log.d("SubaoMessage", String.format(com.subao.common.e.r.f6001a, "[%s] retry after %d milliseconds (%d/%d)", this.f6034a, Long.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.d)));
                }
                return true;
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected void e() {
                f();
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected void a(b.c cVar) {
                if (cVar.f6066a == 500) {
                    f();
                }
            }
        }

        /* loaded from: classes2.dex */
        private abstract class m extends b {
            m(String str) {
                super(a.this, str, 1, LogUtils.LOG_FUSE_TIME);
            }
        }

        /* loaded from: classes2.dex */
        class n extends m {
            private final int e;
            private final int g;
            private final List<com.subao.common.i.l> h;

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected String b() {
                return "/v3/report/client/start/android";
            }

            n(int i, int i2, List<com.subao.common.i.l> list) {
                super("Start");
                this.e = i;
                this.g = i2;
                this.h = list;
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                com.subao.common.i.q a2 = a.this.f6033a.e().a(com.subao.common.i.k.a(), this.e, this.g);
                if (h.b()) {
                    a2.a();
                }
                return h.b(a2);
            }

            private void a(byte[] bArr) {
                a.this.f6033a.d();
                String a2 = com.subao.common.i.e.a(bArr);
                if (ao.a(a2)) {
                    if (com.subao.common.d.a("SubaoMessage")) {
                        Log.d("SubaoMessage", "Response of 'start': subaoId=" + a2);
                    }
                    a.this.f6033a.a(new q(a2));
                    return;
                }
                com.subao.common.d.a("SubaoMessage", "Response of 'start', subaoId is invalid");
                a.this.f6033a.a(new Runnable() { // from class: com.subao.common.i.h.a.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ao.b().b((String) null);
                        a.this.post(new j(a.this.f6033a.e().a(System.currentTimeMillis() / 1000, o.a.a(a.this.f6033a.a()))));
                    }
                });
            }

            @Override // com.subao.common.i.h.a.b, com.subao.common.i.h.a.AbstractRunnableC0169a
            protected void a(b.c cVar) {
                if (cVar.f6066a == 201) {
                    a(cVar.b);
                } else {
                    super.a(cVar);
                }
            }
        }

        /* loaded from: classes2.dex */
        class l extends m {
            private final String e;

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected String b() {
                return "/v3/report/client/qos";
            }

            l(String str) {
                super("Qos");
                this.e = str;
                if (com.subao.common.d.a("SubaoMessage")) {
                    Log.d("SubaoMessage", "Perform Qos Message:\n" + this.e);
                }
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                return this.e.getBytes();
            }
        }

        /* loaded from: classes2.dex */
        class k extends m {
            final String d;
            private final byte[] g;

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected String b() {
                return "/v3/report/client/gaming/link";
            }

            k(String str, byte[] bArr) {
                super("Link");
                this.d = str;
                this.g = bArr;
                if (com.subao.common.d.a("SubaoMessage")) {
                    Log.d("SubaoMessage", String.format("Perform Link Message: id=%s, body:\n%s", str, new String(bArr)));
                }
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                return this.g;
            }

            @Override // com.subao.common.i.h.a.b, com.subao.common.i.h.a.AbstractRunnableC0169a
            protected void a(b.c cVar) {
                if (cVar.f6066a == 500) {
                    f();
                } else if (cVar.f6066a == 201 || cVar.f6066a == 400) {
                    a.this.f6033a.f().b(this.d);
                }
            }
        }

        /* loaded from: classes2.dex */
        private abstract class c extends m {
            private final com.subao.common.c e;
            private final long g;

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected String b() {
                return "/v3/report/client/feedback";
            }

            c(String str, com.subao.common.c cVar) {
                super(str);
                this.e = cVar;
                this.g = System.currentTimeMillis();
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                com.subao.common.i.k a2 = com.subao.common.i.k.a();
                StringWriter stringWriter = new StringWriter(1024);
                JsonWriter jsonWriter = new JsonWriter(stringWriter);
                jsonWriter.beginObject();
                com.subao.common.n.g.a(jsonWriter, "id", a2);
                jsonWriter.name("time").value(this.g / 1000);
                com.subao.common.i.e.a(jsonWriter, "type", a.this.f6033a.c());
                com.subao.common.n.g.a(jsonWriter, "game", a.this.d);
                com.subao.common.n.g.a(jsonWriter, "device", a.this.c);
                com.subao.common.n.g.a(jsonWriter, "version", a.this.f6033a.e().a());
                com.subao.common.n.g.a(jsonWriter, "network", a.this.d());
                com.subao.common.n.g.a(jsonWriter, "feedback", this.e);
                com.subao.common.n.g.a(jsonWriter, "accelInfo", new p.a(g(), a(com.subao.common.i.k.f()), null));
                jsonWriter.endObject();
                com.subao.common.e.a(jsonWriter);
                String stringWriter2 = stringWriter.toString();
                if (com.subao.common.d.a("SubaoMessage")) {
                    Log.d("SubaoMessage", this.f6034a);
                    Log.d("SubaoMessage", stringWriter2);
                }
                return stringWriter2.getBytes();
            }

            private p.f g() {
                if (a.this.f6033a.b().a() != l.a.MOBILE_4G) {
                    return null;
                }
                com.subao.common.l.c a2 = com.subao.common.l.c.a();
                return new p.f(a2.d() != null, false, null, al.a(a2.c()));
            }

            private p.g a(String str) {
                return new p.g(aa.e(), str != null && str.length() >= 2 && str.charAt(1) == '1', null, null);
            }
        }

        /* loaded from: classes2.dex */
        private class d extends c {
            d(p.c cVar) {
                super("DelayQualityV2Feedback", cVar);
            }
        }

        /* loaded from: classes2.dex */
        abstract class e extends b {
            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected String b() {
                return "/v3/report/client/event";
            }

            protected e() {
                super(a.this, "Event", 10);
            }
        }

        /* renamed from: com.subao.common.i.h$a$h, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0170h extends e {
            private com.subao.common.i.n f;

            C0170h(com.subao.common.i.n nVar) {
                super();
                this.f = nVar;
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                if (this.f == null) {
                    return null;
                }
                if (h.b()) {
                    this.f.b();
                }
                byte[] b = h.b(this.f);
                this.f = null;
                if (com.subao.common.d.a("SubaoMessage")) {
                    Log.d("SubaoMessage", "MessageEvent: " + new String(b));
                }
                return b;
            }
        }

        /* loaded from: classes2.dex */
        class g extends e {
            private final String f;
            private final String g;
            private boolean h;

            g(String str, String str2) {
                super();
                this.f = str;
                this.g = str2;
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                if (this.h || this.f == null || this.g == null) {
                    return null;
                }
                this.h = true;
                com.subao.common.i.n a2 = a.this.f6033a.e().a(com.subao.common.i.k.a(), this.f, this.g);
                if (h.b()) {
                    a2.b();
                }
                byte[] b = h.b(a2);
                if (com.subao.common.d.a("SubaoMessage")) {
                    Log.d("SubaoMessage", "MessageEvent: " + new String(b));
                }
                return b;
            }
        }

        /* loaded from: classes2.dex */
        class i extends e {
            private final byte[] f;

            i(String str) {
                super();
                this.f = TextUtils.isEmpty(str) ? null : str.getBytes();
                if (com.subao.common.d.a("SubaoMessage")) {
                    Log.d("SubaoMessage", "MessageEvent: " + str);
                }
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                return this.f;
            }
        }

        /* loaded from: classes2.dex */
        class f extends e {
            private n.a f;

            f(n.a aVar) {
                super();
                this.f = aVar;
            }

            @Override // com.subao.common.i.h.a.AbstractRunnableC0169a
            protected byte[] c() {
                if (this.f == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(this.f);
                com.subao.common.i.n a2 = a.this.f6033a.e().a(com.subao.common.i.k.a(), arrayList);
                this.f = null;
                if (h.b()) {
                    a2.b();
                }
                return h.b(a2);
            }
        }
    }
}
