package com.ihoc.mgpa.b;

import android.os.SystemClock;
import com.helpshift.BuildConfig;
import com.ihoc.mgpa.f.C0240f;
import com.ihoc.mgpa.f.C0242h;
import com.ihoc.mgpa.j.z;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class p implements h {

    /* renamed from: a, reason: collision with root package name */
    private long f5491a = 0;

    private void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("setting", String.valueOf(str));
        hashMap.put("haptic_support", String.valueOf(com.ihoc.mgpa.c.f.a().d()));
        hashMap.put("am_support", String.valueOf(com.ihoc.mgpa.c.f.a().f()));
        hashMap.put(BuildConfig.FLAVOR_supportDimension, String.valueOf(com.ihoc.mgpa.c.f.a().e()));
        com.ihoc.mgpa.i.m.c(hashMap);
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        if (System.currentTimeMillis() - this.f5491a < 20) {
            SystemClock.sleep(20L);
        }
        this.f5491a = System.currentTimeMillis();
        if (i == com.ihoc.mgpa.a.e.HapticMode.a()) {
            a(str);
        }
        try {
            if (i == com.ihoc.mgpa.a.e.SCENE.a() && com.ihoc.mgpa.i.f.fa()) {
                int a2 = C0242h.a().a(str);
                if (a2 == -2) {
                    com.ihoc.mgpa.n.m.b("TGPA_VendorObserver", "can't get scene type config from cloud, ple check it.");
                } else if (a2 == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("do not need send scene to vendor. id: ");
                    sb.append(str);
                    com.ihoc.mgpa.n.m.a("TGPA_VendorObserver", sb.toString());
                } else {
                    str = String.valueOf(a2);
                }
            }
            if (com.ihoc.mgpa.i.f.aa()) {
                C0240f.b().a(i, str);
            } else {
                z.c().b().a(i, str);
            }
        } catch (Throwable unused) {
            com.ihoc.mgpa.n.m.a("TGPA_VendorObserver", "VendorObserver key data run exception. ");
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
        if (com.ihoc.mgpa.i.f.aa()) {
            C0240f.b().a();
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
        if (System.currentTimeMillis() - this.f5491a < 20) {
            SystemClock.sleep(20L);
        }
        this.f5491a = System.currentTimeMillis();
        try {
            if (com.ihoc.mgpa.i.f.aa()) {
                C0240f.b().a(hashMap);
            } else {
                z.c().b().a(hashMap);
            }
        } catch (Throwable unused) {
            com.ihoc.mgpa.n.m.a("TGPA_VendorObserver", "VendorObserver map data run exception. ");
        }
    }
}
