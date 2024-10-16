package com.subao.common.b;

import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import com.subao.common.b.e;
import com.subao.common.c.f;
import com.subao.common.e.an;
import com.subao.common.e.r;
import com.subao.common.e.u;
import com.subao.common.e.v;
import com.subao.common.i.d;
import com.subao.common.intf.RequestTrialCallback;
import com.subao.common.intf.XunyouTokenStateListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class b {
    private static com.subao.common.b.a b;

    /* renamed from: a, reason: collision with root package name */
    private static final p f5910a = new p();
    private static a c = new a();
    private static volatile byte[] d = null;
    private static XunyouTokenStateListener e = null;

    /* loaded from: classes2.dex */
    public interface c {
        boolean a();

        d.b b();

        String c();
    }

    public static void a(String str) {
        if (com.subao.common.d.a("SubaoAuth")) {
            Log.d("SubaoAuth", "Clear cache: " + str);
        }
        b.a(str, (g) null);
    }

    public static boolean a(String str, an anVar, String str2, RequestTrialCallback requestTrialCallback) {
        g b2 = b(str2);
        if (b2 == null) {
            if (requestTrialCallback != null) {
                requestTrialCallback.onRequestTrialResult(1009);
            }
            return false;
        }
        if (1 == b2.d) {
            return b(str, anVar, b2.f5925a, requestTrialCallback);
        }
        if (requestTrialCallback != null) {
            requestTrialCallback.onRequestTrialResult(1010);
        }
        return false;
    }

    public static boolean b(String str, an anVar, String str2, RequestTrialCallback requestTrialCallback) {
        com.subao.common.m.d.a(new com.subao.common.c.f(str, anVar, str2, new d(requestTrialCallback)));
        return true;
    }

    public static void a(v.a aVar, String str, u.a aVar2, boolean z) {
        g b2 = b(str);
        if (b2 == null) {
            aVar2.a(1009, null);
        } else if (aVar.d != null && !aVar.d.b()) {
            aVar2.a(1005, null);
        } else {
            new u(aVar, new v.d(str, b2.f5925a), aVar2, z).a(com.subao.common.m.d.a());
        }
    }

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f5915a;
        private String b;
        private int c;
        private byte[] d;

        private a() {
            this.f5915a = false;
        }

        void a() {
            this.f5915a = false;
            this.b = null;
            this.c = 0;
            this.d = null;
        }
    }

    static boolean a(boolean z, com.subao.common.j.p pVar) {
        if (z) {
            return true;
        }
        pVar.c();
        return false;
    }

    public static void a(an anVar, String str, com.subao.common.f.c cVar) {
        e.a(anVar, str);
        b = new com.subao.common.b.a(cVar);
    }

    public static void a(boolean z) {
        e.a(z);
    }

    public static void a(c cVar, int i, int i2, final String str, String str2, String str3, final com.subao.common.b.c cVar2) {
        g a2;
        if (i2 == 50) {
            byte[] a3 = a();
            if (a3 != null && (a2 = h.a(System.currentTimeMillis(), a3)) != null) {
                b(i, i2, a2, 201, str, cVar2);
                return;
            }
        } else if (i2 > 0) {
            g a4 = b.a(str);
            if (a4 != null) {
                com.subao.common.d.a("SubaoAuth", "JWTToken cache got. call key: " + i2);
                b(i, i2, a4, 201, str, cVar2);
                return;
            }
        } else {
            b.a(str, (g) null);
        }
        com.subao.common.j.p pVar = new com.subao.common.j.p(cVar.b(), i, i2) { // from class: com.subao.common.b.b.1
            @Override // com.subao.common.j.p
            protected String a() {
                return "auth_get_jwt_token";
            }

            @Override // com.subao.common.j.p
            protected void a(int i3, byte[] bArr) {
                if (bArr != null && bArr.length > 2) {
                    try {
                        g a5 = g.a(new ByteArrayInputStream(bArr));
                        b.a(h.a(a5, System.currentTimeMillis()));
                        b.b.a(str, a5);
                        b.b(this.d, this.e, a5, i3, str, cVar2);
                        d();
                        return;
                    } catch (IOException unused) {
                    }
                }
                d(-3, null);
            }

            @Override // com.subao.common.j.p
            protected void b(int i3, byte[] bArr) {
                b.b.a(str, (g) null);
                com.subao.common.i.k.b(str);
                com.subao.common.b.c cVar3 = cVar2;
                if (cVar3 != null) {
                    cVar3.a(this.d, this.e, null, -1L, null, 0, null, false, i3, null, 0L, -1, 0L, 0, 0, "", null);
                }
            }
        };
        if (c.f5915a && str.equals(c.b)) {
            pVar.c(c.c, c.d);
            c.a();
        } else if (a(cVar.a(), pVar)) {
            e.a(new e.c(str, str2, e.a(), str3, pVar), cVar.c());
        }
    }

    public static synchronized byte[] a() {
        byte[] bArr;
        synchronized (b.class) {
            bArr = d;
        }
        return bArr;
    }

    public static synchronized void a(byte[] bArr) {
        synchronized (b.class) {
            d = bArr;
        }
    }

    public static synchronized void a(XunyouTokenStateListener xunyouTokenStateListener) {
        synchronized (b.class) {
            e = xunyouTokenStateListener;
        }
    }

    public static synchronized XunyouTokenStateListener b() {
        XunyouTokenStateListener xunyouTokenStateListener;
        synchronized (b.class) {
            xunyouTokenStateListener = e;
        }
        return xunyouTokenStateListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, int i2, g gVar, int i3, String str, com.subao.common.b.c cVar) {
        String str2 = gVar.c;
        if (com.subao.common.d.a("SubaoAuth")) {
            Log.d("SubaoAuth", String.format(r.f6001a, "userId=[%s], expire=[%d], serviceId=[%s], status=[%s], time=[%s], serverTime=[%d][%s], scopes=[%s], credit=[%s, %s, %d]", str, Long.valueOf(gVar.b), str2, Integer.valueOf(gVar.d), gVar.e, Long.valueOf(gVar.i), com.subao.common.n.c.a(com.subao.common.n.c.b(gVar.i), 7), k.a(gVar.h, gVar.i), Long.valueOf(gVar.k), Integer.valueOf(gVar.l), Integer.valueOf(gVar.m)));
        }
        com.subao.common.i.k.a(str, str2, gVar.d, gVar.e, new com.subao.common.i.b(gVar.k, gVar.l, gVar.m, gVar.n));
        if (cVar != null) {
            cVar.a(i, i2, gVar.f5925a, gVar.b, str2, gVar.d, gVar.e, true, i3, k.a(gVar.h, gVar.i), gVar.i, gVar.j, gVar.k, gVar.l, gVar.m, gVar.n, gVar.o);
        }
    }

    public static void a(c cVar, int i, final String str, final String str2, final com.subao.common.b.c cVar2) {
        com.subao.common.j.p pVar = new com.subao.common.j.p(cVar.b(), i, 0) { // from class: com.subao.common.b.b.2
            @Override // com.subao.common.j.p
            protected String a() {
                return "auth_get_node_token";
            }

            @Override // com.subao.common.j.p
            protected void a(int i2, byte[] bArr) {
                m a2 = m.a(new String(bArr));
                if (a2 != null) {
                    if (com.subao.common.d.a("SubaoAuth")) {
                        Log.d("SubaoAuth", String.format(r.f6001a, "token=%s, expire=%d", a2.f5931a, Integer.valueOf(a2.b)));
                    }
                    cVar2.a(this.d, str, a2.f5931a != null ? a2.f5931a.getBytes() : null, a2.b, true, i2);
                    d();
                    return;
                }
                d(-3, null);
            }

            @Override // com.subao.common.j.p
            protected void b(int i2, byte[] bArr) {
                if (i2 == 401) {
                    com.subao.common.d.a("SubaoAuth", "GetToken failed, clear cache.");
                    b.b.b(str2);
                }
                cVar2.a(this.d, str, (byte[]) null, -1, false, i2);
                b.e();
            }
        };
        if (a(cVar.a(), pVar)) {
            e.a(str.replace('.', '-') + "-node.xunyou.mobi", str2, pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        XunyouTokenStateListener b2 = b();
        if (b2 != null) {
            b2.onXunyouTokenInvalid();
        }
    }

    public static void a(c cVar, int i, int i2, final String str, String str2, final com.subao.common.b.c cVar2) {
        com.subao.common.j.p pVar = new com.subao.common.j.p(cVar.b(), i, 0) { // from class: com.subao.common.b.b.3
            @Override // com.subao.common.j.p
            protected String a() {
                return "auth_get_user_status";
            }

            @Override // com.subao.common.j.p
            protected void a(int i3, byte[] bArr) {
                n a2 = n.a(new String(bArr));
                if (a2 != null) {
                    int i4 = a2.b;
                    String str3 = a2.f5932a;
                    com.subao.common.i.k.a(str, str3, i4, a2.c, com.subao.common.i.k.g());
                    cVar2.a(this.d, this.e, str3, i4, a2.c, true, i3);
                    d();
                    return;
                }
                d(-3, null);
            }

            @Override // com.subao.common.j.p
            protected void b(int i3, byte[] bArr) {
                if (i3 == 401) {
                    com.subao.common.d.a("SubaoAuth", "GetUserAccelStatus failed, clear cache.");
                    b.b.a(str, (g) null);
                }
                com.subao.common.i.k.b(str);
                cVar2.a(this.d, this.e, null, -1, null, false, i3);
            }
        };
        if (a(cVar.a(), pVar)) {
            e.b(str, str2, pVar);
        }
    }

    public static void b(c cVar, int i, final String str, final String str2, final com.subao.common.b.c cVar2) {
        com.subao.common.j.p pVar = new com.subao.common.j.p(cVar.b(), i, 0) { // from class: com.subao.common.b.b.4
            @Override // com.subao.common.j.p
            protected String a() {
                return "auth_get_config";
            }

            @Override // com.subao.common.j.p
            protected void a(int i2, byte[] bArr) {
                if (bArr == null) {
                    Log.w("SubaoAuth", "Configs: (null)");
                    d(-3, null);
                    return;
                }
                if (com.subao.common.d.a("SubaoAuth")) {
                    Log.d("SubaoAuth", "Configs: " + new String(bArr));
                }
                C0163b a2 = C0163b.a(bArr);
                if (a2 != null) {
                    o a3 = o.a(a2.f5916a);
                    if (a3 != null) {
                        b.b(str2, a3);
                    }
                    cVar2.a(this.d, str, str2, a2, i2, true);
                    d();
                    return;
                }
                d(-3, null);
            }

            @Override // com.subao.common.j.p
            protected void b(int i2, byte[] bArr) {
                if (i2 == 401) {
                    com.subao.common.d.a("SubaoAuth", "GetUserConfig failed, clear cache.");
                    b.b.a(str2, (g) null);
                }
                cVar2.a(this.d, (String) null, str2, (C0163b) null, i2, false);
            }
        };
        if (a(cVar.a(), pVar)) {
            e.a(str, str2, cVar.c(), pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, o oVar) {
        f5910a.a(str, oVar);
        com.subao.common.i.k.a(str, oVar.f5933a);
    }

    public static void a(c cVar, int i, String str, String str2, String str3) {
        g a2;
        if (str == null && (a2 = b.a(str2)) != null) {
            str = a2.f5925a;
        }
        com.subao.common.j.p pVar = new com.subao.common.j.p(cVar.b(), i, 0) { // from class: com.subao.common.b.b.5
            @Override // com.subao.common.j.p
            protected String a() {
                return "auth_set_config";
            }

            @Override // com.subao.common.j.p
            protected void b(int i2, byte[] bArr) {
            }

            @Override // com.subao.common.j.p
            protected void a(int i2, byte[] bArr) {
                if (i2 != 201) {
                    Log.w("SubaoAuth", "Try upload user config, response code: " + i2);
                    d(i2, bArr);
                }
                d();
            }
        };
        if (a(cVar.a(), pVar)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
            JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream));
            try {
                jsonWriter.beginObject();
                com.subao.common.n.g.a(jsonWriter, "userConfig", str3);
                jsonWriter.endObject();
                com.subao.common.e.a(jsonWriter);
                e.a(str, str2, byteArrayOutputStream.toByteArray(), pVar);
            } catch (IOException unused) {
                com.subao.common.e.a(jsonWriter);
            } catch (Throwable th) {
                com.subao.common.e.a(jsonWriter);
                throw th;
            }
        }
    }

    public static void a(c cVar, int i, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.subao.common.d.b("SubaoAuth", "Empty or Null userId");
            return;
        }
        o a2 = f5910a.a(str);
        if (a2 == null) {
            com.subao.common.d.b("SubaoAuth", "No user config exists");
            return;
        }
        g a3 = b.a(str);
        if (a3 == null || a3.f5925a == null || a3.f5925a.length() == 0) {
            com.subao.common.d.b("SubaoAuth", "Set user config failed (#1)");
            return;
        }
        o oVar = new o(a2.b, z, a2.d);
        b(str, oVar);
        a(cVar, i, a3.f5925a, str, oVar.f5933a);
    }

    /* renamed from: com.subao.common.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0163b {
        private static final String[] d = {"userConfig", "serviceConfig", "scriptId"};

        /* renamed from: a, reason: collision with root package name */
        public final String f5916a;
        public final String b;
        public final String c;

        C0163b(String str, String str2, String str3) {
            this.f5916a = str;
            this.b = str2;
            this.c = str3;
        }

        static C0163b a(byte[] bArr) {
            if (bArr == null || bArr.length < 2) {
                return null;
            }
            String[] strArr = new String[3];
            JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr)));
            try {
                jsonReader.beginObject();
                while (true) {
                    boolean z = false;
                    if (jsonReader.hasNext()) {
                        String nextName = jsonReader.nextName();
                        int length = d.length - 1;
                        while (true) {
                            if (length < 0) {
                                break;
                            }
                            if (d[length].equals(nextName)) {
                                strArr[length] = com.subao.common.n.g.b(jsonReader);
                                z = true;
                                break;
                            }
                            length--;
                        }
                        if (!z) {
                            jsonReader.skipValue();
                        }
                    } else {
                        jsonReader.endObject();
                        com.subao.common.e.a(jsonReader);
                        return new C0163b(strArr[0], strArr[1], strArr[2]);
                    }
                }
            } catch (IOException unused) {
                com.subao.common.e.a(jsonReader);
                return null;
            } catch (RuntimeException unused2) {
                com.subao.common.e.a(jsonReader);
                return null;
            } catch (Throwable th) {
                com.subao.common.e.a(jsonReader);
                throw th;
            }
        }
    }

    public static void a(String str, int i, String str2, com.subao.common.j.p pVar) {
        e.a(str, i, str2, pVar);
    }

    public static g b(String str) {
        return b.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements f.a {

        /* renamed from: a, reason: collision with root package name */
        private final RequestTrialCallback f5917a;

        private d(RequestTrialCallback requestTrialCallback) {
            this.f5917a = requestTrialCallback;
        }

        @Override // com.subao.common.c.f.a
        public void a(f.a.EnumC0166a enumC0166a, int i) {
            int i2;
            if (this.f5917a == null) {
                return;
            }
            if (i < 0) {
                i2 = 1006;
            } else {
                i2 = (i == 201 && f.a.EnumC0166a.ORDER == enumC0166a) ? 0 : 1008;
            }
            this.f5917a.onRequestTrialResult(i2);
        }
    }
}
