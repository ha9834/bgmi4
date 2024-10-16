package com.ihoc.mgpa.i;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    public int f5618a;
    public int c = 0;
    public HashMap<String, String> b = new HashMap<>();

    public k(int i) {
        this.f5618a = i;
    }

    public int a() {
        return this.c;
    }

    public void a(String str, String str2) {
        this.c++;
        f.h.put(com.ihoc.mgpa.a.f.TIME_RELATIVE.a(), m.a());
        f.h.put(com.ihoc.mgpa.a.e.FPS.b(), str);
        f.h.put(com.ihoc.mgpa.a.f.FPS_AVG.a(), str2);
        f.h.put(com.ihoc.mgpa.a.f.MATCH_MARK.a(), String.valueOf(f.l()));
        f.h.put(com.ihoc.mgpa.a.f.SDK_SCENEID_SUPPORT.a(), String.valueOf(f.a(f.d())));
        String n = f.n();
        String H = f.H();
        String e = f.e();
        if (n != null) {
            f.h.put(com.ihoc.mgpa.a.f.MATCH_STATE.a(), n);
        }
        if (H != null) {
            f.h.put(com.ihoc.mgpa.a.f.TEMP_LEVEL.a(), H);
        }
        if (e != null) {
            f.h.put(com.ihoc.mgpa.a.f.DYNAMIC_SETTING.a(), e);
        }
        for (Map.Entry<String, String> entry : f.h.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            String str3 = this.b.get(key);
            if (str3 == null) {
                for (int i = 0; i < this.c - 1; i++) {
                    sb.append("|");
                }
            } else {
                sb.append(str3);
                sb.append("|");
            }
            sb.append(value);
            this.b.put(key, sb.toString());
            f.b(key);
        }
    }
}
