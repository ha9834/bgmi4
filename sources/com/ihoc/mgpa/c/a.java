package com.ihoc.mgpa.c;

import com.ihoc.mgpa.f.H;
import com.ihoc.mgpa.f.I;
import com.ihoc.mgpa.f.RunnableC0236b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f5492a = 500;
    private static int b = 1000;
    private static int c = 5;
    private static int d = 5;
    private static int e;
    private static volatile a f;
    private int g;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;

    private a() {
        this.g = 0;
        this.g = com.ihoc.mgpa.n.f.b();
        if (com.ihoc.mgpa.g.o.b().c.u != null) {
            b = com.ihoc.mgpa.g.o.b().c.u.b;
            c = com.ihoc.mgpa.g.o.b().c.u.d;
            d = com.ihoc.mgpa.g.o.b().c.u.e;
            e = com.ihoc.mgpa.g.o.b().c.u.c;
            f5492a = com.ihoc.mgpa.g.o.b().c.u.f5559a;
        }
    }

    private void a(int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.ihoc.mgpa.a.h.CPU_LOCK_STATUS.a(), String.valueOf(i));
            jSONObject.put(com.ihoc.mgpa.a.h.CPU_LOCK_NUM.a(), String.valueOf(i2));
            H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.CPU_LOCK, jSONObject.toString()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static a c() {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new a();
                }
            }
        }
        return f;
    }

    private int e() {
        int i;
        int i2 = this.j;
        if (i2 <= 0) {
            return 0;
        }
        int i3 = e;
        if (i3 == 0) {
            i = this.i + this.h;
            i2 *= 2;
        } else if (i3 == 1) {
            i = this.h;
        } else {
            if (i3 != 2) {
                return 0;
            }
            i = this.i;
        }
        return i / i2;
    }

    private boolean f() {
        int i = 0;
        for (int i2 = 0; i2 < this.g; i2++) {
            if (com.ihoc.mgpa.n.f.a(i2) < f5492a) {
                i++;
            }
        }
        if (i <= 0) {
            return false;
        }
        this.i += i;
        return true;
    }

    private boolean g() {
        int i = 0;
        for (int i2 = 0; i2 < this.g; i2++) {
            if (!com.ihoc.mgpa.n.f.b(i2)) {
                i++;
            }
        }
        if (i <= 0) {
            return false;
        }
        this.h += i;
        return true;
    }

    public void a() {
        if (com.ihoc.mgpa.g.o.b().b.f) {
            com.ihoc.mgpa.n.m.a("[CheckCpuLock]: checkCPUCoreLock feature is close.", new Object[0]);
            return;
        }
        if (!d()) {
            this.j = 0;
            this.k++;
            com.ihoc.mgpa.n.m.a("[CheckCpuLock]: cpu is online, onlineCount: " + this.k, new Object[0]);
            if (this.k >= d) {
                if (this.l != 0) {
                    this.l = 0;
                    com.ihoc.mgpa.n.m.a("[CheckCpuLock]: cpu is all online!", new Object[0]);
                    a(this.l, this.g);
                }
                this.k = 0;
                return;
            }
            return;
        }
        this.k = 0;
        this.j++;
        com.ihoc.mgpa.n.m.a("[CheckCpuLock]: cpu is locked, offlineCount: " + this.j, new Object[0]);
        if (this.j >= c) {
            if (this.l != 1) {
                this.l = 1;
                int e2 = e();
                com.ihoc.mgpa.n.m.d("[CheckCpuLock]: cpu is locked, locked num: " + e2, new Object[0]);
                a(this.l, e2);
            }
            this.j = 0;
        }
    }

    public void b() {
        int i = 5000 / b;
        if (this.l == 1) {
            i = 1;
        }
        for (int i2 = 0; i2 < i; i2++) {
            I.a().a(2, "", b * i2);
        }
    }

    public boolean d() {
        if (this.g <= 0) {
            com.ihoc.mgpa.n.m.d("[CheckCpuLock]: cpu num <= 0! num: " + this.g, new Object[0]);
            return false;
        }
        int i = e;
        if (i == 0) {
            return f() || g();
        }
        if (i == 1) {
            return g();
        }
        if (i != 2) {
            return false;
        }
        return f();
    }
}
