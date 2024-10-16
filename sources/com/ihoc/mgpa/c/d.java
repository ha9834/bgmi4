package com.ihoc.mgpa.c;

import android.content.Context;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.ServerProtocol;
import com.uqm.crashsight.CrashSight;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Context f5497a;
    private com.ihoc.mgpa.g.l b;

    public d(Context context) {
        this.f5497a = context;
    }

    private void a(com.ihoc.mgpa.i.g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", gVar.a());
        hashMap.put("available", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("prop_match", String.valueOf(z));
        hashMap.put("package_match", String.valueOf(z2));
        hashMap.put("cpu_match", String.valueOf(z3));
        hashMap.put("gpu_match", String.valueOf(z4));
        for (String str : this.b.d.f5571a.keySet()) {
            hashMap.put(str, com.ihoc.mgpa.n.q.a(str, Constants.NULL_VERSION_ID));
        }
        for (String str2 : this.b.d.b.keySet()) {
            hashMap.put(str2, com.ihoc.mgpa.n.q.a(str2, Constants.NULL_VERSION_ID));
        }
        Iterator<String> it = this.b.e.b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            hashMap.put(next, String.valueOf(com.ihoc.mgpa.n.f.a(next, this.f5497a)));
        }
        Iterator<String> it2 = this.b.e.f5570a.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            hashMap.put(next2, String.valueOf(com.ihoc.mgpa.n.f.a(next2, this.f5497a)));
        }
        hashMap.put("cpu", String.valueOf(com.ihoc.mgpa.n.f.a()));
        hashMap.put("gpu", String.valueOf(com.ihoc.mgpa.i.f.p()));
        hashMap.put("root", String.valueOf(com.ihoc.mgpa.n.f.e()));
        if (com.ihoc.mgpa.i.f.sa()) {
            hashMap.put("rom_version", String.valueOf(n.a()));
            hashMap.put("software_version", String.valueOf(n.b()));
        }
        hashMap.put("read_sd", com.ihoc.mgpa.n.f.a("android.permission.READ_EXTERNAL_STORAGE") ? "0" : "1");
        hashMap.put("write_sd", com.ihoc.mgpa.n.f.a("android.permission.WRITE_EXTERNAL_STORAGE") ? "0" : "1");
        hashMap.put("read_phone", com.ihoc.mgpa.n.f.a("android.permission.READ_PHONE_STATE") ? "0" : "1");
        hashMap.put("internal_total", String.valueOf(g.c().e()));
        hashMap.put("internal_available", String.valueOf(g.c().b()));
        hashMap.put("external_total", String.valueOf(g.c().d()));
        hashMap.put("external_available", String.valueOf(g.c().a()));
        com.ihoc.mgpa.i.m.a((HashMap<String, String>) hashMap);
    }

    private int c() {
        com.ihoc.mgpa.i.g d = d();
        if (d == com.ihoc.mgpa.i.g.DEVICE_CONFIG_GET_EXCEPTION || d == com.ihoc.mgpa.i.g.DEVICE_CONFIG_AVAILABLE_IS_FALSE || d == com.ihoc.mgpa.i.g.DEVICE_IS_REAL) {
            return 0;
        }
        return (d == com.ihoc.mgpa.i.g.DEVICE_IS_NOT_REAL || d == com.ihoc.mgpa.i.g.DEVICE_IS_UNKOWN) ? 1 : 0;
    }

    private com.ihoc.mgpa.i.g d() {
        com.ihoc.mgpa.i.g gVar;
        String str;
        String str2;
        com.ihoc.mgpa.g.l lVar = this.b;
        if (lVar == null) {
            com.ihoc.mgpa.n.m.a("TGPA", "device_check: globalconfig is null.");
            return com.ihoc.mgpa.i.g.DEVICE_CONFIG_GET_EXCEPTION;
        }
        if (!lVar.f5568a) {
            com.ihoc.mgpa.n.m.a("TGPA", "device_check: available is false, do not check device, only report.");
            b();
            return com.ihoc.mgpa.i.g.DEVICE_CONFIG_AVAILABLE_IS_FALSE;
        }
        boolean e = com.ihoc.mgpa.n.f.e();
        boolean h = h();
        boolean f = f();
        boolean g = g();
        boolean e2 = e();
        if (!h && e) {
            str = "TGPA";
            str2 = "device_check: prop info is not matched and device is rooted.";
        } else {
            if (e2 || !e || !h || !f || !g) {
                gVar = (h && f && g && e2) ? com.ihoc.mgpa.i.g.DEVICE_IS_REAL : com.ihoc.mgpa.i.g.DEVICE_IS_NOT_REAL;
                a(gVar, h, e2, f, g);
                com.ihoc.mgpa.n.m.a("TGPA", "device_check: device info match result, prop: " + String.valueOf(h));
                com.ihoc.mgpa.n.m.a("TGPA", "device_check: device info match result, cpu: " + String.valueOf(f));
                com.ihoc.mgpa.n.m.a("TGPA", "device_check: device info match result, gpu: " + String.valueOf(g));
                com.ihoc.mgpa.n.m.a("TGPA", "device_check: device info match result, package: " + String.valueOf(e2));
                return gVar;
            }
            str = "TGPA";
            str2 = "device_check: package is not installed and device is rooted.";
        }
        com.ihoc.mgpa.n.m.a(str, str2);
        gVar = com.ihoc.mgpa.i.g.DEVICE_IS_UNKOWN;
        a(gVar, h, e2, f, g);
        com.ihoc.mgpa.n.m.a("TGPA", "device_check: device info match result, prop: " + String.valueOf(h));
        com.ihoc.mgpa.n.m.a("TGPA", "device_check: device info match result, cpu: " + String.valueOf(f));
        com.ihoc.mgpa.n.m.a("TGPA", "device_check: device info match result, gpu: " + String.valueOf(g));
        com.ihoc.mgpa.n.m.a("TGPA", "device_check: device info match result, package: " + String.valueOf(e2));
        return gVar;
    }

    private boolean e() {
        ArrayList<String> arrayList = this.b.e.b;
        if (arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (com.ihoc.mgpa.n.f.a(next, this.f5497a)) {
                    com.ihoc.mgpa.n.m.a("TGPA", "device_check:isAppPackageInstalled: package exist, package: " + next);
                    return true;
                }
            }
            com.ihoc.mgpa.n.m.a("TGPA", "device_check:isAppPackageInstalled: not found package in exsit. ");
        }
        ArrayList<String> arrayList2 = this.b.e.f5570a;
        if (arrayList2.size() > 0) {
            Iterator<String> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!com.ihoc.mgpa.n.f.a(next2, this.f5497a)) {
                    com.ihoc.mgpa.n.m.a("TGPA", "device_check:isAppPackageInstalled: package: " + next2 + " not exsit.");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean f() {
        String a2 = com.ihoc.mgpa.n.f.a();
        String[] strArr = this.b.f.f5569a;
        if (a2 == null) {
            com.ihoc.mgpa.n.m.a("TGPA", "device_check:isCPUMatched: cpu hardware is null. result is matched.");
            return true;
        }
        if (strArr.length <= 0) {
            com.ihoc.mgpa.n.m.a("TGPA", "device_check:isCPUMatched: cpu arr lenth <= 0. result is matched.");
            return true;
        }
        for (String str : strArr) {
            if (a2.contains(str)) {
                com.ihoc.mgpa.n.m.a("TGPA", "device_check:isCPUMatched: cpu: " + a2 + " is matched. ");
                return true;
            }
        }
        com.ihoc.mgpa.n.m.a("TGPA", "device_check:isCPUMatched: cpu is not matched.");
        return false;
    }

    private boolean g() {
        String p = com.ihoc.mgpa.i.f.p();
        String[] strArr = this.b.f.b;
        if (p == null) {
            com.ihoc.mgpa.n.m.a("TGPA", "DeviceChecker:isGPUMatched: gpu is null. result is matched.");
            return true;
        }
        if (strArr.length <= 0) {
            com.ihoc.mgpa.n.m.a("TGPA", "DeviceChecker:isGPUMatched: gpu arr lenth <= 0. result is matched.");
            return true;
        }
        for (String str : strArr) {
            if (str.contains(p)) {
                com.ihoc.mgpa.n.m.a("TGPA", "DeviceChecker:isGPUMatched: gpu: " + p + " is matched.");
                return true;
            }
        }
        com.ihoc.mgpa.n.m.a("TGPA", "DeviceChecker:checkDeviceMatchConfig: gpu is not matched.");
        return false;
    }

    private boolean h() {
        StringBuilder sb;
        String str;
        Iterator<Map.Entry<String, String[]>> it = this.b.d.f5571a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator<Map.Entry<String, String[]>> it2 = this.b.d.b.entrySet().iterator();
                while (it2.hasNext()) {
                    String key = it2.next().getKey();
                    String a2 = com.ihoc.mgpa.n.q.a(key, Constants.NULL_VERSION_ID);
                    com.ihoc.mgpa.n.m.a("TGPA", "device_check:isPropValueMatched: exist prop: " + key + " = " + String.valueOf(a2));
                    if (a2 == null || a2.equals(Constants.NULL_VERSION_ID)) {
                        sb = new StringBuilder();
                        sb.append("device_check:isPropValueMatched: propKey: ");
                        sb.append(key);
                        str = " not exsit.";
                    }
                }
                com.ihoc.mgpa.n.m.a("TGPA", "device_check:isPropValueMatched: prop all matched. ");
                return true;
            }
            Map.Entry<String, String[]> next = it.next();
            String key2 = next.getKey();
            String[] value = next.getValue();
            String a3 = com.ihoc.mgpa.n.q.a(key2, Constants.NULL_VERSION_ID);
            if (a3 == null) {
                com.ihoc.mgpa.n.m.a("TGPA", "device_check:isPropValueMatched: get prop exception. prop: " + key2);
            } else if (!com.ihoc.mgpa.n.b.a(value, a3)) {
                sb = new StringBuilder();
                sb.append("device_check:isPropValueMatched: not matched. propKey: ");
                sb.append(key2);
                str = " not match. ";
                break;
            }
        }
        sb.append(str);
        com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
        return false;
    }

    public void a() {
        if (com.ihoc.mgpa.i.f.N()) {
            this.b = com.ihoc.mgpa.g.o.b().c.j;
            if (this.b != null) {
                com.ihoc.mgpa.i.f.a(c());
            } else {
                com.ihoc.mgpa.n.m.a("TGPA", "device_check: no device check config.");
            }
        }
    }

    public void b() {
        if (this.b.f5568a) {
            com.ihoc.mgpa.n.m.a("TGPA", "device_check: device config available is true, do not need report again. ");
            return;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "device_check: start to get device info to report.");
        HashMap hashMap = new HashMap();
        hashMap.put("result", com.ihoc.mgpa.i.g.DEVICE_CONFIG_AVAILABLE_IS_FALSE.a());
        hashMap.put("available", CrashSight.SDK_IS_DEV);
        for (String str : this.b.d.f5571a.keySet()) {
            hashMap.put(str, com.ihoc.mgpa.n.q.a(str, Constants.NULL_VERSION_ID));
        }
        for (String str2 : this.b.d.b.keySet()) {
            hashMap.put(str2, com.ihoc.mgpa.n.q.a(str2, Constants.NULL_VERSION_ID));
        }
        Iterator<String> it = this.b.e.b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            hashMap.put(next, String.valueOf(com.ihoc.mgpa.n.f.a(next, this.f5497a)));
        }
        Iterator<String> it2 = this.b.e.f5570a.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            hashMap.put(next2, String.valueOf(com.ihoc.mgpa.n.f.a(next2, this.f5497a)));
        }
        hashMap.put("cpu", String.valueOf(com.ihoc.mgpa.n.f.a()));
        hashMap.put("gpu", String.valueOf(com.ihoc.mgpa.i.f.p()));
        hashMap.put("root", String.valueOf(com.ihoc.mgpa.n.f.e()));
        if (com.ihoc.mgpa.i.f.sa()) {
            hashMap.put("rom_version", String.valueOf(n.a()));
            hashMap.put("software_version", String.valueOf(n.b()));
        }
        hashMap.put("read_sd", com.ihoc.mgpa.n.f.a("android.permission.READ_EXTERNAL_STORAGE") ? "0" : "1");
        hashMap.put("write_sd", com.ihoc.mgpa.n.f.a("android.permission.WRITE_EXTERNAL_STORAGE") ? "0" : "1");
        hashMap.put("read_phone", com.ihoc.mgpa.n.f.a("android.permission.READ_PHONE_STATE") ? "0" : "1");
        hashMap.put("internal_total", String.valueOf(g.c().e()));
        hashMap.put("internal_available", String.valueOf(g.c().b()));
        hashMap.put("external_total", String.valueOf(g.c().d()));
        hashMap.put("external_available", String.valueOf(g.c().a()));
        hashMap.put("package_installer_version", String.valueOf(com.ihoc.mgpa.n.f.e(this.f5497a)));
        com.ihoc.mgpa.i.m.a((HashMap<String, String>) hashMap);
    }
}
