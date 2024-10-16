package com.subao.common.e;

import android.content.Context;
import android.util.Log;
import com.subao.common.e.ad;
import com.subao.common.e.ah;
import com.subao.common.e.d;
import com.subao.common.e.e;
import com.subao.common.e.r;
import com.subao.common.e.y;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f5950a = null;
    private final r.a b;
    private final ad.a c;
    private final com.subao.common.g.c d;
    private final ah.a e;
    private e.a f;
    private byte[] g;

    public a(r.a aVar, ad.a aVar2, com.subao.common.g.c cVar, ah.a aVar3) {
        this.b = aVar;
        this.c = aVar2;
        this.d = cVar;
        this.e = aVar3;
    }

    public static aq a(Context context, List<b> list, boolean z, com.subao.common.g.c cVar) {
        aq a2 = aq.a(list, x.a(context, z));
        if (a2 != null && a2.a() != 0) {
            Iterator<ap> it = a2.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                if (!next.a()) {
                    cVar.a(next.f5973a, next.b, next.c, next.e, next.d);
                }
            }
        }
        return a2;
    }

    public synchronized void a(e.a aVar) {
        this.f = aVar;
    }

    private synchronized e.a f() {
        return this.f;
    }

    public synchronized void a(byte[] bArr) {
        this.g = bArr;
    }

    private synchronized byte[] g() {
        return this.g;
    }

    private String a(String str, y.a aVar) {
        String a2 = y.a(this.c, this.d, aVar);
        if (com.subao.common.d.a("SubaoData")) {
            Locale locale = r.f6001a;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(a2 != null ? a2.length() : 0);
            Log.d("SubaoData", String.format(locale, "%s = %d chars", objArr));
        }
        return a2;
    }

    public byte[] a(int i) {
        ae a2 = aj.a(this.c, i);
        byte[] a3 = a2 != null ? a2.a() : null;
        if (com.subao.common.d.a("SubaoData")) {
            Log.d("SubaoData", "PCode: " + com.subao.common.n.h.a(a3));
        }
        return a3;
    }

    public e.a a() {
        e.a a2 = e.a(this.c);
        e.a f = f();
        if (f != null) {
            Log.w("SubaoData", "Use Debug Nodes: " + f);
            return f;
        }
        if (!com.subao.common.d.a("SubaoData")) {
            return a2;
        }
        Log.d("SubaoData", "Accel Nodes: " + com.subao.common.n.h.a(a2));
        return a2;
    }

    public aq a(Context context, boolean z) {
        if (this.b == r.a.SDK) {
            return null;
        }
        byte[] g = g();
        if (g == null || g.length == 0) {
            g = f5950a;
        }
        List<b> a2 = d.a(this.c, this.b == r.a.ROM ? 16 : 500, new d.b() { // from class: com.subao.common.e.a.1
            @Override // com.subao.common.e.d.b
            public void a(List<b> list) {
                com.subao.common.h.a.a(list);
            }
        }, g);
        com.subao.common.h.a.a(a2);
        return a(context, a2, z, this.d);
    }

    public String b() {
        return a("Convergence IP (CIP)", m.e());
    }

    public String c() {
        return a("Game Server IP (GIP)", s.e());
    }

    public void d() {
        af.a(this.c, this.d);
        ak.a(this.c, this.d);
        ah.a(this.c, this.e);
        ai.a(this.c, this.d);
    }

    public void e() {
        aa.a(this.c, this.d);
    }

    public aq b(Context context, boolean z) {
        com.subao.common.d.a("SubaoData", "AccelDataRefresher.refreshAll()");
        e();
        a(this.d.b());
        a();
        b();
        c();
        d();
        return a(context, z);
    }
}
