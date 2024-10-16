package com.ihoc.mgpa.c;

import com.ihoc.mgpa.f.H;
import com.ihoc.mgpa.f.RunnableC0236b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f5498a;
    private com.ihoc.mgpa.g.n b;

    private e() {
    }

    public static e a() {
        if (f5498a == null) {
            synchronized (e.class) {
                if (f5498a == null) {
                    f5498a = new e();
                }
            }
        }
        return f5498a;
    }

    private float b(int i, ArrayList<Float> arrayList) {
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        int i3;
        for (int i4 = 0; i4 < this.b.c; i4++) {
            arrayList.remove(0);
        }
        for (int i5 = 0; i5 < this.b.d; i5++) {
            arrayList.remove(arrayList.size() - 1);
        }
        int size = arrayList.size();
        int i6 = size / this.b.e;
        int i7 = 1;
        float f5 = 0.0f;
        int i8 = 0;
        float f6 = 0.0f;
        while (true) {
            int i9 = this.b.e;
            if (i7 >= i9 + 1) {
                break;
            }
            if (i7 == i9) {
                f3 = 0.0f;
                f4 = 0.0f;
                i3 = 0;
                while (i8 < size) {
                    float floatValue = arrayList.get(i8).floatValue();
                    f4 += floatValue * floatValue;
                    f3 += floatValue;
                    f5 += floatValue;
                    i3++;
                    i8++;
                }
            } else {
                float f7 = f5;
                f3 = 0.0f;
                f4 = 0.0f;
                i3 = 0;
                for (int i10 = 0; i10 < i6 && i8 < size; i10++) {
                    float floatValue2 = arrayList.get(i8).floatValue();
                    f4 += floatValue2 * floatValue2;
                    f3 += floatValue2;
                    f7 += floatValue2;
                    i3++;
                    i8++;
                }
                f5 = f7;
            }
            if (i3 == 0) {
                i3 = 1;
            }
            float f8 = i3;
            float f9 = f3 / f8;
            float f10 = (f4 / f8) - (f9 * f9);
            com.ihoc.mgpa.g.n nVar = this.b;
            float f11 = nVar.f;
            if (f10 > f11) {
                f6 += Math.min(nVar.h, nVar.g * (f10 - f11));
            }
            i7++;
        }
        float size2 = f5 / arrayList.size();
        com.ihoc.mgpa.g.n nVar2 = this.b;
        float f12 = nVar2.i;
        if (size2 < f12) {
            f2 = nVar2.j;
        } else {
            if (size2 < f12 || size2 >= nVar2.k) {
                f = r1.n * size2;
                i2 = this.b.o;
            } else {
                f = nVar2.l * size2;
                i2 = nVar2.m;
            }
            f2 = f - i2;
        }
        return Math.max(1.0f, Math.min(this.b.p, f2) * this.b.q * (100.0f - f6));
    }

    private void c(int i, ArrayList<Float> arrayList) {
        float b;
        int i2;
        if (!com.ihoc.mgpa.i.f.P()) {
            com.ihoc.mgpa.n.m.a("TGPA_FPS", "check fps score, func is not open.");
            return;
        }
        if (com.ihoc.mgpa.g.o.b().c.k == null) {
            com.ihoc.mgpa.n.m.a("TGPA_FPS", "check fps score, no fps config, ple check.");
            return;
        }
        this.b = com.ihoc.mgpa.g.o.b().c.k;
        if (!this.b.f5572a) {
            com.ihoc.mgpa.n.m.a("TGPA_FPS", "check fps score, available is false, ple check.");
            return;
        }
        com.ihoc.mgpa.n.m.a("TGPA_FPS", "check fps score, start to check fps score. ");
        HashMap hashMap = new HashMap();
        if (i < this.b.b) {
            com.ihoc.mgpa.n.m.a("TGPA_FPS", "check fps score, fps count is too less. size is " + i);
            b = 1000.0f;
        } else {
            b = b(i, arrayList);
        }
        if (b < this.b.r) {
            i2 = 2;
            H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.FPSSTRATEGY, "{\"1\":\"4\"}"));
        } else {
            i2 = 0;
        }
        com.ihoc.mgpa.n.m.a("TGPA_FPS", "fps score: " + b + " , fps level: " + i2);
        hashMap.put("fps_score", String.format(Locale.CHINA, "%.2f", Float.valueOf(b)));
        hashMap.put("fps_level", String.valueOf(i2));
        com.ihoc.mgpa.i.m.m(hashMap);
    }

    public void a(int i, ArrayList<Float> arrayList) {
        com.ihoc.mgpa.n.m.a("TGPA_FPS", "post all game match fps. ");
        try {
            if (com.ihoc.mgpa.i.f.Y()) {
                com.ihoc.mgpa.i.m.a(arrayList);
            }
            if (com.ihoc.mgpa.i.f.P()) {
                c(i, arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA_FPS", "check/report game match fps exception. ");
        }
    }
}
