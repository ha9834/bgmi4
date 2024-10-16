package com.ihoc.mgpa.j;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class O extends S {
    private static volatile O m;

    private O() {
    }

    private int a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    public static O g() {
        if (m == null) {
            synchronized (O.class) {
                if (m == null) {
                    m = new O();
                }
            }
        }
        return m;
    }

    @Override // com.ihoc.mgpa.j.S, com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        a(new M(this));
    }

    @Override // com.ihoc.mgpa.j.S, com.ihoc.mgpa.j.C0249a
    public void a(int i, String str) {
        if (this.c) {
            c(com.ihoc.mgpa.f.G.a(i, str, b()));
        }
    }

    @Override // com.ihoc.mgpa.j.S
    public void a(InterfaceC0250b interfaceC0250b) {
        Thread thread = this.h;
        if (thread != null && thread.isAlive()) {
            com.ihoc.mgpa.n.m.a("TGPA", "VIVOSocketClient: tgpa_vivo_socket_connect thread is already created!");
        } else {
            this.h = new Thread(new N(this, interfaceC0250b), "tgpa_vivo_socket_connect");
            this.h.start();
        }
    }

    @Override // com.ihoc.mgpa.j.S, com.ihoc.mgpa.j.C0249a
    public void a(HashMap<String, String> hashMap) {
        if (this.c) {
            c(com.ihoc.mgpa.f.G.a(hashMap, b()));
        }
    }

    @Override // com.ihoc.mgpa.j.S, com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.VIVO2;
    }

    @Override // com.ihoc.mgpa.j.S, com.ihoc.mgpa.j.C0249a
    public void b(int i, String str) {
        a(i, str);
    }

    @Override // com.ihoc.mgpa.j.S
    public void b(String str) {
        com.ihoc.mgpa.n.m.a("TGPA", "vivo2_socket: content: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CONTENT, String.valueOf(str));
        boolean z = true;
        boolean z2 = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("1")) {
                this.l = jSONObject.getString("1");
                com.ihoc.mgpa.i.f.a(com.ihoc.mgpa.a.f.SOC_TEMP.a(), this.l);
            }
            if (jSONObject.has("2")) {
                String string = jSONObject.getString("2");
                int a2 = a(Integer.parseInt(string));
                com.ihoc.mgpa.i.f.z(string);
                hashMap.put(com.ihoc.mgpa.a.f.VENDOR_LEVEL.a(), string);
                hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a(), "2");
                hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a(), String.valueOf(a2));
                a("2", a2);
                z2 = true;
            }
            try {
                if (jSONObject.has("IsSupport")) {
                    com.ihoc.mgpa.f.G.a(jSONObject);
                }
                if (jSONObject.has("5")) {
                    hashMap.put(com.ihoc.mgpa.a.h.STRATEGY_SUPPORT.a(), jSONObject.getString("5"));
                    try {
                        com.ihoc.mgpa.f.G.a(jSONObject);
                    } catch (Exception unused) {
                        com.ihoc.mgpa.n.m.a("TGPA", "vivo2_socket: parse json exception.");
                        if (z) {
                            return;
                        } else {
                            return;
                        }
                    }
                } else {
                    z = z2;
                }
                if (jSONObject.has(Constants.VIA_SHARE_TYPE_INFO)) {
                    hashMap.put(com.ihoc.mgpa.a.h.SCENE_SUPPORT.a(), jSONObject.getString(Constants.VIA_SHARE_TYPE_INFO));
                }
                if (jSONObject.has(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                    com.ihoc.mgpa.i.f.y(jSONObject.getString(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE));
                }
            } catch (Exception unused2) {
                z = z2;
            }
        } catch (Exception unused3) {
            z = false;
        }
        if (z || !com.ihoc.mgpa.i.f.Y()) {
            return;
        }
        hashMap.put(com.ihoc.mgpa.a.h.DEVICE_TEMP.a(), String.valueOf(this.l));
        com.ihoc.mgpa.i.m.o(hashMap);
    }

    @Override // com.ihoc.mgpa.j.S, com.ihoc.mgpa.j.C0249a
    public void b(HashMap<String, String> hashMap) {
        a(hashMap);
    }

    @Override // com.ihoc.mgpa.j.S
    public void c(String str) {
        if (!this.c || str == null || str.length() <= 2) {
            return;
        }
        super.c(str);
    }

    @Override // com.ihoc.mgpa.j.S
    public String h() {
        return "perfsdkmon";
    }
}
