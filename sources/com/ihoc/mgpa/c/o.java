package com.ihoc.mgpa.c;

import android.os.Build;
import com.ihoc.mgpa.TGPANative;
import com.ihoc.mgpa.f.H;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static volatile o f5508a;

    private o() {
    }

    public static o a() {
        if (f5508a == null) {
            synchronized (o.class) {
                if (f5508a == null) {
                    f5508a = new o();
                }
            }
        }
        return f5508a;
    }

    private boolean a(int i, int[] iArr, int i2) {
        if (Build.VERSION.SDK_INT < 19 || !TGPANative.isTgpaLibLoad()) {
            return false;
        }
        return TGPANative.setThreadAffinity(i, iArr, i2);
    }

    private long b(int i, int i2) {
        if (Build.VERSION.SDK_INT < 19 || !TGPANative.isTgpaLibLoad()) {
            return -1L;
        }
        return TGPANative.getThreadAffinity(i, i2);
    }

    private void c(int i, int i2) {
        int[] iArr;
        if (com.ihoc.mgpa.g.o.b().c.l != null) {
            if (i == com.ihoc.mgpa.a.e.LIGHT_THREAD_TID.a()) {
                iArr = com.ihoc.mgpa.g.o.b().c.l.b;
            } else if (i == com.ihoc.mgpa.a.e.THREAD_TID.a()) {
                iArr = com.ihoc.mgpa.g.o.b().c.l.c;
            } else if (i == com.ihoc.mgpa.a.e.RESET_THREAD_TID.a()) {
                d(i2, com.ihoc.mgpa.g.o.b().c.l.f5566a);
            }
            a(i2, iArr, com.ihoc.mgpa.g.o.b().c.l.f5566a);
        }
        H.b().a(i, i2);
    }

    private boolean d(int i, int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = i3;
        }
        return a(i, iArr, i2);
    }

    public void a(int i, int i2) {
        long b = b(i2, com.ihoc.mgpa.g.o.b().c.l != null ? com.ihoc.mgpa.g.o.b().c.l.f5566a : 10);
        HashMap hashMap = new HashMap();
        hashMap.put("affinity", String.valueOf(b));
        hashMap.put("tid", String.valueOf(i2));
        hashMap.put("key", String.valueOf(i));
        com.ihoc.mgpa.i.m.n(hashMap);
    }

    public void a(int i, String str) {
        if (i == com.ihoc.mgpa.a.e.LIGHT_THREAD_TID.a() || i == com.ihoc.mgpa.a.e.THREAD_TID.a() || i == com.ihoc.mgpa.a.e.RESET_THREAD_TID.a()) {
            c(i, Integer.parseInt(str));
        }
    }

    public void a(HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            a(Integer.parseInt(entry.getKey()), entry.getValue());
        }
    }
}
