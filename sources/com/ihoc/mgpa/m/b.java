package com.ihoc.mgpa.m;

import com.ihoc.mgpa.IMGPAService;
import com.ihoc.mgpa.f.H;
import com.ihoc.mgpa.g.C;
import com.ihoc.mgpa.g.o;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.n.p;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f5661a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j = false;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private boolean n = false;
    private IMGPAService.TouchEventWrapper o;

    private b() {
    }

    private void a(boolean z) {
        this.n = z;
        IMGPAService.TouchEventWrapper touchEventWrapper = this.o;
        if (touchEventWrapper != null) {
            touchEventWrapper.onTuringTouchIsCollecting(z);
        }
    }

    public static b b() {
        if (f5661a == null) {
            synchronized (b.class) {
                if (f5661a == null) {
                    f5661a = new b();
                }
            }
        }
        return f5661a;
    }

    private void c() {
        String str;
        String str2;
        if (!this.j) {
            str = "TGPA_TuringShield";
            str2 = "Warning, turing shield sdk is not available, ple check!.";
        } else if (com.ihoc.mgpa.i.f.q() == null || p.b(com.ihoc.mgpa.i.f.q())) {
            str = "TGPA_TuringShield";
            str2 = "no openid, you should set openid first before turing shield start!";
        } else if (this.n) {
            str = "TGPA_TuringShield";
            str2 = "Is collecting data now, ignore this start!";
        } else {
            this.m++;
            if (this.m <= this.i) {
                if (this.o != null) {
                    m.a("TGPA_TuringShield", "TuringShield start with wrapper!");
                    f.a(com.ihoc.mgpa.i.f.q(), this.b, this.o);
                } else {
                    m.a("TGPA_TuringShield", "TuringShield start with activity!");
                    f.a(com.ihoc.mgpa.i.f.q(), this.b, com.ihoc.mgpa.n.h.a());
                }
                a(true);
                if (this.h != 0) {
                    m.a("TGPA_TuringShield", "This collect action will be stopped after " + this.h);
                    H.b().a("stop", (long) (this.h * 1000));
                    return;
                }
                return;
            }
            str = "TGPA_TuringShield";
            str2 = "Collected count > limited count, can't start to collect again in this match.";
        }
        m.a(str, str2);
    }

    private void d() {
        if (!this.j) {
            m.a("TGPA_TuringShield", "Warning, turing shield sdk is not available, ple check!.");
        } else {
            f.a();
            a(false);
        }
    }

    private void e() {
        if (this.j) {
            f.a(this.b);
        } else {
            m.a("TGPA_TuringShield", "Warning, turing shield sdk is not available, ple check!.");
        }
    }

    public void a() {
        String str;
        String str2;
        if (!com.ihoc.mgpa.i.f.ma()) {
            m.a("TGPA_TuringShield", "turing shield func is not open, ple check!");
            return;
        }
        if (com.ihoc.mgpa.n.a.a() == null) {
            m.a("TGPA_TuringShield", "no context, you should init first!");
            return;
        }
        if (com.ihoc.mgpa.n.h.a() == null) {
            m.a("TGPA_TuringShield", "can't get app main activity, maybe you should init sdk by interface init:Activity!");
            return;
        }
        if (o.b().c.n == null) {
            m.a("TGPA_TuringShield", "no turing config exist, ple check cloud config.");
            return;
        }
        C c = o.b().c.n;
        if (!c.f5553a) {
            m.d("TGPA_TuringShield", "turing config available is false, ple ensure cloud config.");
            return;
        }
        try {
            this.b = c.b;
            this.c = c.c;
            this.d = c.d;
            this.e = c.e;
            this.f = c.f;
            this.g = c.g;
            this.h = c.h;
            this.i = c.i;
            this.j = f.a(com.ihoc.mgpa.n.a.a(), com.ihoc.mgpa.i.f.M());
        } catch (Throwable th) {
            th.printStackTrace();
            m.b("TGPA_TuringShield", "turing shield sdk init failed, ple check!");
            this.j = false;
        }
        if (this.j) {
            str = "TGPA_TuringShield";
            str2 = "turing shield sdk is available & init success.";
        } else {
            str = "TGPA_TuringShield";
            str2 = "turing shield sdk is not available!";
        }
        m.c(str, str2);
    }

    public void a(int i, String str) {
        String str2;
        String str3;
        if (!com.ihoc.mgpa.i.f.ma()) {
            str2 = "TGPA_TuringShield";
            str3 = "Warning, turing shield func is not open, ple check!.";
        } else {
            if (this.j) {
                int i2 = a.f5660a[com.ihoc.mgpa.a.e.a(i).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    this.k = Integer.parseInt(str);
                    int i3 = this.c;
                    if (i3 == 0 || this.l != i3) {
                        return;
                    }
                    int i4 = this.f;
                    if (i4 != 0 && this.k <= i4) {
                        m.a("TGPA_TuringShield", "Start to collect data by usercount.");
                        c();
                    }
                    if (this.g == 0 || this.k < this.d) {
                        return;
                    }
                    m.a("TGPA_TuringShield", "Stop collecting data by usercount.");
                    d();
                    return;
                }
                this.l = Integer.parseInt(str);
                if (this.l == 4) {
                    m.a("TGPA_TuringShield", "Game now enter into lobby, reset collect count.");
                    this.m = 0;
                }
                if (this.f != 0 && this.g != 0) {
                    int i5 = this.c;
                    if (i5 == 0 || this.l != i5) {
                        int i6 = this.d;
                        if (i6 != 0 && this.l == i6) {
                            m.a("TGPA_TuringShield", "Stop collecting data by scene and usercount.");
                            d();
                        }
                    } else if (this.k < i5) {
                        m.a("TGPA_TuringShield", "Start to collect data by scene and usercount.");
                        c();
                    }
                }
                if (this.f == 0 && this.g == 0) {
                    int i7 = this.c;
                    if (i7 == 0 || this.l != i7) {
                        int i8 = this.d;
                        if (i8 != 0 && this.l == i8) {
                            m.a("TGPA_TuringShield", "Stop collecting data by only scene.");
                            d();
                        }
                    } else {
                        m.a("TGPA_TuringShield", "Start to collect data by only scene.");
                        c();
                    }
                }
                int i9 = this.e;
                if (i9 == 0 || this.l != i9) {
                    return;
                }
                m.a("TGPA_TuringShield", "Report collected data by scene.");
                e();
                return;
            }
            str2 = "TGPA_TuringShield";
            str3 = "Warning, turing shield sdk is not available, ple check!.";
        }
        m.a(str2, str3);
    }

    public void a(IMGPAService.TouchEventWrapper touchEventWrapper) {
        this.o = touchEventWrapper;
    }

    public void a(String str) {
        if (!com.ihoc.mgpa.i.f.ma()) {
            m.a("TGPA_TuringShield", "turing shield func is not open, ple check!");
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -838595071) {
            if (hashCode != 3237136) {
                if (hashCode != 3540994) {
                    if (hashCode == 109757538 && str.equals("start")) {
                        c = 1;
                    }
                } else if (str.equals("stop")) {
                    c = 2;
                }
            } else if (str.equals("init")) {
                c = 0;
            }
        } else if (str.equals("upload")) {
            c = 3;
        }
        switch (c) {
            case 0:
                m.a("TGPA_TuringShield", "Start to init turing sdk by string command.");
                a();
                return;
            case 1:
                m.a("TGPA_TuringShield", "Start to collect data by string command.");
                c();
                return;
            case 2:
                m.a("TGPA_TuringShield", "Stop collecting data by string command.");
                d();
                return;
            case 3:
                m.a("TGPA_TuringShield", "Upload collected data by string command.");
                e();
                return;
            default:
                return;
        }
    }

    public void a(HashMap<String, String> hashMap) {
        if (hashMap == null || !hashMap.containsKey(com.ihoc.mgpa.a.e.SCENE.b())) {
            return;
        }
        a(com.ihoc.mgpa.a.e.SCENE.a(), hashMap.get(com.ihoc.mgpa.a.e.SCENE.b()));
    }
}
