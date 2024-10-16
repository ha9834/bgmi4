package com.subao.common.b;

import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.subao.common.b.b;
import com.subao.common.b.f;
import com.subao.common.e.an;
import com.subao.common.e.ao;
import com.subao.common.e.o;
import com.subao.common.e.v;
import com.subao.common.intf.UserStateListener;
import java.io.IOException;
import java.io.StringReader;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class d implements com.subao.common.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final a f5918a;
    private final String b;
    private final com.subao.common.g.c c;
    private final v.a d;
    private final an e;
    private final q f;
    private final c g;

    /* loaded from: classes2.dex */
    public interface a {
        UserStateListener f();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(long j);
    }

    static int a(boolean z, int i) {
        if (z) {
            return 0;
        }
        if (i == 401) {
            return 1009;
        }
        switch (i) {
            case -3:
                return 1008;
            case -2:
                return 1006;
            case -1:
                return 1005;
            default:
                return 1008;
        }
    }

    private static boolean a(int i) {
        return i == 2 || i == 4 || i == 6;
    }

    public d(a aVar, String str, com.subao.common.g.c cVar, v.a aVar2, an anVar, q qVar, c cVar2) {
        this.f5918a = aVar;
        this.b = str;
        this.c = cVar;
        this.d = aVar2;
        this.e = anVar;
        this.f = qVar;
        this.g = cVar2;
    }

    private void b(int i) {
        com.subao.common.j.e.a(a(i), this.e);
    }

    @Override // com.subao.common.b.c
    public void a(int i, int i2, String str, long j, String str2, int i3, String str3, boolean z, int i4, String str4, long j2, int i5, long j3, int i6, int i7, String str5, String str6) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(j2);
        }
        b(i3);
        this.c.a(i, z, i4, str, (int) j, str2, i3, str3, str4, i5, j3, i6, i7, str5, str6);
        a(str);
        this.f.a(i2, a(z, i4), i3, str3);
        a(i3, str3);
    }

    private void a(int i, String str) {
        UserStateListener f = this.f5918a.f();
        if (f != null) {
            f.onUserStateUpdate(i, str);
        }
    }

    private void a(String str) {
        if ("3F14CB7C-6B1E-4E05-ACF8-57F11ED1A81C".equals(this.b) || "EBE43518-4093-4502-9763-0E5E6151C925".equals(this.b)) {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            this.c.b(0, "key_set_user_id", b2);
        }
    }

    private static String b(String str) {
        String a2 = com.subao.common.n.f.a(str);
        if (a2 == null) {
            return null;
        }
        try {
            f.a aVar = f.a(new JsonReader(new StringReader(a2))).f5923a;
            if (aVar != null) {
                return aVar.f5924a;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.subao.common.b.c
    public void a(int i, int i2, String str, int i3, String str2, boolean z, int i4) {
        b(i3);
        this.c.a(i, z, i4, i3, str, str2);
        this.f.a(i2, a(z, i4), i3, str2);
        a(i3, str2);
    }

    @Override // com.subao.common.b.c
    public void a(int i, String str, byte[] bArr, int i2, boolean z, int i3) {
        this.c.a(i, z, i3, str, bArr, i2);
    }

    @Override // com.subao.common.b.c
    public void a(int i, String str, String str2, b.C0163b c0163b, int i2, boolean z) {
        this.c.a(i, z, i2, c0163b == null ? null : c0163b.f5916a);
        if (!z || c0163b == null || TextUtils.isEmpty(c0163b.c)) {
            return;
        }
        if (com.subao.common.d.a("SubaoData")) {
            Log.d("SubaoData", "Has customer script need download, script-id: " + c0163b.c);
        }
        b.a(this.d, this.c, str, str2);
    }

    /* loaded from: classes2.dex */
    static class b extends com.subao.common.e.o {
        private static volatile boolean d;
        private final com.subao.common.g.c e;

        private b(v.a aVar, com.subao.common.g.c cVar, String str, String str2) {
            super(aVar, new v.d(str2, str), new o.b(com.subao.common.i.k.d(), ao.b().c()));
            this.e = cVar;
        }

        public static boolean a(v.a aVar, com.subao.common.g.c cVar, String str, String str2) {
            if (d) {
                e();
                return false;
            }
            new b(aVar, cVar, str, str2).a(com.subao.common.m.d.a());
            return true;
        }

        private static void e() {
            com.subao.common.d.a("SubaoData", "Previous customer script already injected, do not download again.");
        }

        static void a(o.a aVar, com.subao.common.g.c cVar) {
            boolean z;
            boolean a2 = com.subao.common.d.a("SubaoData");
            if (aVar == null) {
                if (a2) {
                    Log.d("SubaoData", "Download customer script failed, IO or runtime exception");
                    return;
                }
                return;
            }
            if (aVar.f5997a == null || aVar.f5997a.length() != 32) {
                if (a2) {
                    Log.d("SubaoData", "Invalid digest in download customer script");
                    return;
                }
                return;
            }
            if (aVar.b == null) {
                if (a2) {
                    Log.d("SubaoData", "Invalid response in download customer script");
                    return;
                }
                return;
            }
            if (a2) {
                Log.d("SubaoData", "Download customer script, response code: " + aVar.b.f6066a);
            }
            if (aVar.b.f6066a != 200) {
                return;
            }
            byte[] bArr = aVar.b.b;
            if (bArr == null || bArr.length == 0) {
                Log.w("SubaoData", "Customer script downloaded, but pcode is null !!!");
                return;
            }
            try {
                if (!aVar.f5997a.equalsIgnoreCase(com.subao.common.n.h.a(com.subao.common.n.b.a(bArr), false))) {
                    if (a2) {
                        Log.w("SubaoData", "Download customer script, digest verify failed");
                        return;
                    }
                    return;
                }
                synchronized (b.class) {
                    z = d;
                    d = true;
                }
                if (z) {
                    e();
                    return;
                }
                if (a2) {
                    Log.d("SubaoData", "Inject customer scripts ...");
                }
                cVar.a(bArr);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                if (a2) {
                    Log.w("SubaoData", "Download customer script, calc digest failed");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.subao.common.e.v
        public void a(v.b bVar) {
            a(b(bVar), this.e);
        }
    }
}
