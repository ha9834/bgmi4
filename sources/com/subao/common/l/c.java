package com.subao.common.l;

import android.util.Log;
import com.subao.common.d;
import com.subao.common.e.ak;
import com.subao.common.e.al;
import com.subao.common.e.j;
import com.subao.common.f;
import com.subao.common.j.e;
import com.subao.common.n.h;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final c f6125a = new c();
    private al b;

    private c() {
    }

    public static c a() {
        return f6125a;
    }

    static boolean a(f fVar, b bVar) {
        if (fVar == null) {
            return false;
        }
        fVar.a(0, "key_enable_qos", bVar != null ? 1 : 0);
        if (bVar != null) {
            fVar.a("QOS.AccelTime", Integer.toString(bVar.d));
            fVar.a("QOS.AccelThreshold", Integer.toString(bVar.c));
            fVar.a("QOS.DropThreshold", Integer.toString(bVar.e));
            fVar.a("QOS.StandardThreshold", Integer.toString(bVar.e));
        }
        return true;
    }

    public void b() {
        a(f.a.a(), f6125a.d());
    }

    public final al c() {
        return this.b;
    }

    void a(al alVar) {
        if (d.a("SubaoQos")) {
            Log.d("SubaoQos", String.format("Current=%s, setTo=%s", h.a(this.b), h.a(alVar)));
        }
        if (this.b != alVar) {
            this.b = alVar;
            b();
        }
    }

    public b d() {
        boolean a2 = d.a("SubaoQos");
        if (!ak.e()) {
            if (a2) {
                Log.d("SubaoQos", "Qos switch off, getQosParam() return null");
            }
            return null;
        }
        al c = c();
        if (a2) {
            Log.d("SubaoQos", "Current Region-ISP: " + h.a(c));
        }
        b a3 = c != null ? ak.a(c.f5968a, c.b) : null;
        if (a2) {
            Log.d("SubaoQos", "User region and ISP qos param is: " + h.a(a3));
        }
        return a3;
    }

    public void e() {
        a((al) null);
    }

    public void f() {
        d.a("SubaoQos", "Network change to 4G");
        e.c b = e.b();
        if (b != null) {
            a(b);
        } else {
            e.a(null, new e.a() { // from class: com.subao.common.l.c.1
                @Override // com.subao.common.j.e.a
                public void a(Object obj, e.c cVar) {
                    com.subao.common.m.b.a().a(new a(cVar));
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.c cVar) {
        j a2;
        a((cVar == null || (a2 = cVar.a()) == null) ? null : new al(cVar.b, a2.d));
    }

    /* loaded from: classes2.dex */
    private class a implements Runnable {
        private final e.c b;

        private a(e.c cVar) {
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.b);
        }
    }
}
