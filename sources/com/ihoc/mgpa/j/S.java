package com.ihoc.mgpa.j;

import android.net.LocalSocket;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ihoc.mgpa.f.RunnableC0236b;
import com.tencent.connect.common.Constants;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class S extends C0249a {
    private static volatile S b;
    public Thread h;
    public boolean c = false;
    public LocalSocket d = null;
    public InputStream e = null;
    public OutputStream f = null;
    public PrintWriter g = null;
    private int i = -1;
    public final int j = 5;
    public int k = 0;
    public String l = "";

    public static S g() {
        if (b == null) {
            synchronized (S.class) {
                if (b == null) {
                    b = new S();
                }
            }
        }
        return b;
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        a(new P(this));
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(int i, String str) {
        if (this.c) {
            c(com.ihoc.mgpa.f.G.a(i, str, b()));
        }
    }

    public void a(InterfaceC0250b interfaceC0250b) {
        Thread thread = this.h;
        if (thread != null && thread.isAlive()) {
            com.ihoc.mgpa.n.m.a("TGPA", "VmpSocketClient: tgpa_socket_connect thread is already created!");
        } else {
            this.h = new Thread(new Q(this, interfaceC0250b), "tgpa_socket_connect");
            this.h.start();
        }
    }

    public void a(String str) {
        if (com.ihoc.mgpa.i.f.J() && this.i != 2) {
            this.i = 2;
            com.ihoc.mgpa.f.H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VENDOR, "{\"1\":\"" + str + "\"}"));
        }
    }

    public void a(String str, int i) {
        if (com.ihoc.mgpa.i.f.J()) {
            if (this.i == i) {
                com.ihoc.mgpa.n.m.a("TGPA", "socket: frequecy level is same to last.");
                return;
            }
            if (i == 0) {
                com.ihoc.mgpa.n.m.a("TGPA", "socket: frequecy level is 0, do not need notify.");
                return;
            }
            this.i = i;
            com.ihoc.mgpa.f.H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VENDOR, (("{\"" + com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a() + "\":\"" + str + "\",") + "\"" + com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a() + "\":\"" + i + "\"") + "}"));
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(HashMap<String, String> hashMap) {
        if (this.c) {
            c(com.ihoc.mgpa.f.G.a(hashMap, b()));
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.SOCKET;
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void b(int i, String str) {
        a(i, str);
    }

    public void b(String str) {
        boolean z;
        com.ihoc.mgpa.n.m.a("TGPA", "socket: content: " + String.valueOf(str));
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CONTENT, String.valueOf(str));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("2")) {
                this.l = jSONObject.getString("2");
                com.ihoc.mgpa.i.f.a(com.ihoc.mgpa.a.f.SOC_TEMP.a(), this.l);
            }
            if (jSONObject.has("1")) {
                String string = jSONObject.getString("1");
                hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a(), string);
                if (jSONObject.has("4")) {
                    String string2 = jSONObject.getString("4");
                    com.ihoc.mgpa.i.f.z(string2);
                    hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a(), string2);
                    hashMap.put(com.ihoc.mgpa.a.f.VENDOR_LEVEL.a(), string2);
                    a(string, Integer.parseInt(string2));
                } else {
                    a(string);
                }
                z = true;
            } else {
                z = false;
            }
            if (jSONObject.has("IsSupport")) {
                com.ihoc.mgpa.f.G.a(jSONObject);
            }
            if (jSONObject.has("5")) {
                hashMap.put(com.ihoc.mgpa.a.h.STRATEGY_SUPPORT.a(), jSONObject.getString("5"));
                com.ihoc.mgpa.f.G.a(jSONObject);
                z = true;
            }
            if (jSONObject.has(Constants.VIA_SHARE_TYPE_INFO)) {
                hashMap.put(com.ihoc.mgpa.a.h.SCENE_SUPPORT.a(), jSONObject.getString(Constants.VIA_SHARE_TYPE_INFO));
            }
            if (jSONObject.has(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                com.ihoc.mgpa.i.f.y(jSONObject.getString(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE));
            }
            if (z && com.ihoc.mgpa.i.f.Y()) {
                hashMap.put(com.ihoc.mgpa.a.h.DEVICE_TEMP.a(), String.valueOf(this.l));
                com.ihoc.mgpa.i.m.o(hashMap);
            }
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "socket: parse json exception.");
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void b(HashMap<String, String> hashMap) {
        a(hashMap);
    }

    public void c(String str) {
        if (this.c) {
            com.ihoc.mgpa.n.m.a("TGPA", "VmpSocketClient:updateGameInfo: json: " + str);
            OutputStream outputStream = this.f;
            if (outputStream == null || str == null) {
                return;
            }
            try {
                outputStream.write(str.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
                int i = this.k;
                if (i < 5) {
                    this.k = i + 1;
                } else {
                    this.c = false;
                }
            }
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public String d() {
        return "ERROR";
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public boolean e() {
        return true;
    }

    public String h() {
        return "resmon";
    }
}
