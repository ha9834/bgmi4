package com.subao.common.a;

import android.os.ConditionVariable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.subao.common.a.c;
import com.subao.common.b.b;
import com.subao.common.e.an;
import com.subao.common.e.ar;
import com.subao.common.e.h;
import com.subao.common.e.j;
import com.subao.common.e.t;
import com.subao.common.e.v;
import com.subao.common.j.e;
import com.subao.common.j.f;
import com.subao.common.j.g;
import com.subao.common.j.l;
import com.subao.common.j.m;
import com.subao.common.k.g;
import com.subao.vpn.JniCallback;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class d implements JniCallback {

    /* renamed from: a, reason: collision with root package name */
    private final c f5898a;
    private final com.subao.common.g.c b;
    private final l c;
    private final b.c d;
    private final an e;
    private final v.a f;
    private final com.subao.common.j.a g = new com.subao.common.j.a();

    @Override // com.subao.vpn.JniCallback
    public void a(int i, String str, int i2, int i3, int i4) {
    }

    @Override // com.subao.vpn.JniCallback
    public void a(String str, int i) {
    }

    public d(c cVar, com.subao.common.g.c cVar2, l lVar, c.a aVar, an anVar, v.a aVar2) {
        this.f5898a = cVar;
        this.b = cVar2;
        this.c = lVar;
        this.d = aVar;
        this.e = anVar;
        this.f = aVar2;
        this.g.a(cVar.j());
    }

    @Override // com.subao.vpn.JniCallback
    public void a(boolean z) {
        this.f5898a.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.subao.common.b.d a() {
        v.a aVar = new v.a(this.f5898a.l(), this.f5898a.b, this.f5898a.e().i(), this.f5898a.d);
        c cVar = this.f5898a;
        return new com.subao.common.b.d(cVar, cVar.f5867a, this.b, aVar, this.e, this.f5898a.g, this.f5898a);
    }

    @Override // com.subao.vpn.JniCallback
    public void a(final int i, final int i2, final String str, final String str2, final String str3) {
        com.subao.common.m.b.a().a(new Runnable() { // from class: com.subao.common.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.subao.common.b.b.a(d.this.d, i, i2, str, str2, str3, d.this.a());
            }
        });
    }

    @Override // com.subao.vpn.JniCallback
    public void a(final int i, final String str, final String str2) {
        com.subao.common.m.b.a().a(new Runnable() { // from class: com.subao.common.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.subao.common.b.b.a(d.this.d, i, str, str2, d.this.a());
            }
        });
    }

    @Override // com.subao.vpn.JniCallback
    public void b(final int i, final String str, final String str2) {
        com.subao.common.m.b.a().a(new Runnable() { // from class: com.subao.common.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                com.subao.common.b.b.b(d.this.d, i, str2, str, d.this.a());
            }
        });
    }

    @Override // com.subao.vpn.JniCallback
    public void a(final int i, final int i2, final String str, final String str2) {
        com.subao.common.m.b.a().a(new Runnable() { // from class: com.subao.common.a.d.4
            @Override // java.lang.Runnable
            public void run() {
                com.subao.common.b.b.a(d.this.d, i, i2, str, str2, d.this.a());
            }
        });
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i) {
        com.subao.common.d.a("SubaoParallel", "Proxy request mobile fd ...");
        this.f5898a.b(i);
    }

    @Override // com.subao.vpn.JniCallback
    public void b(final int i) {
        com.subao.common.d.a("SubaoParallel", "Proxy request dual-wifi fd ...");
        com.subao.common.m.d.a(new Runnable() { // from class: com.subao.common.a.d.5
            @Override // java.lang.Runnable
            public void run() {
                int d = com.subao.common.k.d.d();
                d.this.b.a(i, d, d > 0 ? 0 : 2005, g.DUAL_WIFI, com.subao.common.k.d.a());
            }
        });
    }

    @Override // com.subao.vpn.JniCallback
    public void c(int i) {
        com.subao.common.d.a("SubaoData", "Proxy request region and isp ...");
        e.c b = com.subao.common.j.e.b();
        if (b != null || this.c.a() == l.a.DISCONNECT) {
            a(i, b);
        } else {
            com.subao.common.j.e.a(null, new e.a() { // from class: com.subao.common.a.d.6
                @Override // com.subao.common.j.e.a
                public void a(Object obj, e.c cVar) {
                    d.this.a(((Integer) obj).intValue(), cVar);
                }
            }, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, e.c cVar) {
        if (cVar != null) {
            j a2 = cVar.a();
            String num = a2 == null ? "1" : Integer.toString(a2.d);
            this.b.b(i, "key_isp", Integer.toString(cVar.b) + '.' + num);
        }
    }

    @Override // com.subao.vpn.JniCallback
    public void a(String str, String str2, boolean z) {
        this.f5898a.f.a(str, str2, z);
    }

    @Override // com.subao.vpn.JniCallback
    public void a(String str) {
        this.f5898a.f.a(str);
    }

    @Override // com.subao.vpn.JniCallback
    public void b(String str) {
        this.f5898a.f.a("lua_error", str);
    }

    @Override // com.subao.vpn.JniCallback
    public void c(String str) {
        this.f5898a.f.b(str);
    }

    @Override // com.subao.vpn.JniCallback
    public void a(String str, String str2, String str3) {
        if (com.subao.common.d.a("SubaoData")) {
            Log.d("SubaoData", "Accel-Info: " + str);
        }
        ar.a(this.f, new v.d(str2, str3), str.getBytes());
    }

    @Override // com.subao.vpn.JniCallback
    public void a(String str, String str2) {
        try {
            this.f5898a.e.a(str, TextUtils.isEmpty(str2) ? null : str2.getBytes());
        } catch (IOException e) {
            Log.w("SubaoProxy", String.format("onCacheData(%s, ...) throw %s", str, e.getClass().getName()));
        }
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i, String str) {
        try {
            this.b.a(i, this.f5898a.e.a(str));
        } catch (IOException unused) {
        }
    }

    @Override // com.subao.vpn.JniCallback
    public void b(final int i, String str) {
        h.a(this.f.f6011a, this.f.c, str, new h.a() { // from class: com.subao.common.a.d.7
            @Override // com.subao.common.e.h.a
            public void a(boolean z) {
                d.this.b.a(i, "key_beacon_counter_result", z ? 1 : 0);
            }
        });
    }

    @Override // com.subao.vpn.JniCallback
    public int d(int i) {
        return this.f5898a.c(i);
    }

    @Override // com.subao.vpn.JniCallback
    public void b(String str, String str2, String str3) {
        t.a(this.f, new v.d(str, str2), str3);
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i, String str, int i2, String str2) {
        com.subao.common.b.b.a(str, i2, str2, new c.n(null, i, str, i2, str2));
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i, int i2, String str, String str2, String str3, String str4) {
        new com.subao.common.j.c(this.b, i).a(i2, str, str2, TextUtils.isEmpty(str3) ? null : str3.getBytes(), str4);
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i, String str, String str2, String str3, int i2) {
        com.subao.common.m.d.a(new a(this.b, i, str, str2, str3, i2));
    }

    @Override // com.subao.vpn.JniCallback
    public void e(final int i) {
        com.subao.common.j.g.a(this.f5898a.j(), new g.a() { // from class: com.subao.common.a.d.8
            @Override // com.subao.common.j.g.a
            public void a(String str, int i2) {
                d.this.b.b(i, i2, str);
            }
        });
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i, String str, String str2, String str3) {
        this.f5898a.a(i, str, str2, str3);
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i, int i2, String str, String str2, int i3, int i4) {
        this.f5898a.a(i, i2, str, str2, i3, i4);
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i, int i2) {
        this.f5898a.a(i, i2);
    }

    @Override // com.subao.vpn.JniCallback
    public void b(int i, int i2) {
        this.f5898a.b(i, i2);
    }

    @Override // com.subao.vpn.JniCallback
    public void f(int i) {
        this.f5898a.J();
    }

    @Override // com.subao.vpn.JniCallback
    public void g(int i) {
        this.f5898a.n(i);
    }

    @Override // com.subao.vpn.JniCallback
    public void h(int i) {
        this.f5898a.o(i);
    }

    @Override // com.subao.vpn.JniCallback
    public void i(int i) {
        this.f5898a.p(i);
    }

    @Override // com.subao.vpn.JniCallback
    public void a(int i, String str, int i2, String str2, int i3, int i4) {
        this.f5898a.a(i, str, i2, str2, i3, i4);
    }

    /* loaded from: classes2.dex */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.subao.common.g.c f5907a;
        private final int b;
        private final String c;
        private final String d;
        private final String e;
        private final int f;

        private a(com.subao.common.g.c cVar, int i, String str, String str2, String str3, int i2) {
            this.f5907a = cVar;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = i2;
        }

        static String a(String str, String str2, String str3, int i) {
            try {
                byte[] a2 = com.subao.common.n.b.a(str2, str.getBytes());
                if ("BASE64".compareToIgnoreCase(str3) == 0) {
                    return Base64.encodeToString(a2, i);
                }
                return com.subao.common.n.h.a(a2, i != 0);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return "";
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5907a.a(this.b, a(this.c, this.d, this.e, this.f), a());
        }

        private static String a() {
            C0162a c0162a = new C0162a();
            m.b(null, c0162a);
            byte[] a2 = c0162a.a();
            if (a2 == null) {
                C0162a c0162a2 = new C0162a();
                m.a((m.c) null, c0162a2);
                a2 = c0162a2.a();
            }
            return f.a(a2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.subao.common.a.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0162a implements m.a {

            /* renamed from: a, reason: collision with root package name */
            private final ConditionVariable f5908a;
            private byte[] b;

            private C0162a() {
                this.f5908a = new ConditionVariable();
            }

            @Override // com.subao.common.j.m.a
            public void a(byte[] bArr) {
                this.b = bArr;
                this.f5908a.open();
            }

            public byte[] a() {
                this.f5908a.block();
                return this.b;
            }
        }
    }
}
