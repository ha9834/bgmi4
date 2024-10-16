package com.ihoc.mgpa.j;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.ihoc.mgpa.f.RunnableC0236b;
import com.ihoc.mgpa.vendorsdk.v1_0.TGPAManager;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class L extends C0249a {
    private static volatile L b;
    private TGPAManager c = new TGPAManager();
    private boolean d = false;
    private int e = -1;

    private L() {
    }

    private int a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
            case 4:
            case 5:
            case 6:
                return 2;
            default:
                return 0;
        }
    }

    private void a(Context context, InterfaceC0250b interfaceC0250b) {
        this.c.bind(context, new J(this, interfaceC0250b));
    }

    private void a(String str, int i) {
        if (com.ihoc.mgpa.i.f.J()) {
            if (this.e == i) {
                com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder: frequecy level is same to last.");
                return;
            }
            if (i == 0) {
                com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder: frequecy level is 0, do not need notify.");
                return;
            }
            this.e = i;
            com.ihoc.mgpa.f.H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VENDOR, (("{\"" + com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a() + "\":\"" + str + "\",") + "\"" + com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a() + "\":\"" + i + "\"") + "}"));
        }
    }

    private void b(String str) {
        if (com.ihoc.mgpa.i.f.J() && this.e != 2) {
            this.e = 2;
            com.ihoc.mgpa.f.H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VENDOR, "{\"1\":\"" + str + "\"}"));
        }
    }

    public static L g() {
        if (b == null) {
            synchronized (L.class) {
                if (b == null) {
                    b = new L();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.c.registerGameCallback(new K(this));
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        a(com.ihoc.mgpa.n.a.a(), new H(this));
        new Thread(new I(this)).start();
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(int i, String str) {
        if (this.d) {
            a(com.ihoc.mgpa.f.G.a(i, str, b()));
        }
    }

    public void a(String str) {
        TGPAManager tGPAManager;
        if (!this.d || (tGPAManager = this.c) == null) {
            return;
        }
        tGPAManager.updateGameInfo(str);
    }

    public void a(String str, String str2) {
        char c;
        StringBuilder sb;
        String str3;
        com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder: callback type: " + String.valueOf(str) + " , value: " + String.valueOf(str2));
        HashMap hashMap = new HashMap();
        hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a(), String.valueOf(str));
        hashMap.put(com.ihoc.mgpa.a.f.VENDOR_LEVEL.a(), String.valueOf(str2));
        int hashCode = str.hashCode();
        if (hashCode == -1349544041) {
            if (str.equals("thermal")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode == 100358090) {
            if (str.equals(EvaluateItemInfo.ACTIONTYPE_INPUT)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 552887330) {
            if (hashCode == 1671764162 && str.equals(ServerProtocol.DIALOG_PARAM_DISPLAY)) {
                c = 3;
            }
            c = 65535;
        } else {
            if (str.equals("low_battery")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                com.ihoc.mgpa.i.f.z(String.valueOf(str2));
                int a2 = a(Integer.parseInt(str2));
                hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a(), String.valueOf(a2));
                a("2", a2);
                break;
            case 1:
                b("1");
                break;
            case 2:
                sb = new StringBuilder();
                str3 = "input=";
                sb.append(str3);
                sb.append(str2);
                com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
                break;
            case 3:
                sb = new StringBuilder();
                str3 = "display=";
                sb.append(str3);
                sb.append(str2);
                com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
                break;
        }
        com.ihoc.mgpa.i.m.o(hashMap);
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(HashMap<String, String> hashMap) {
        if (this.d) {
            a(com.ihoc.mgpa.f.G.a(hashMap, b()));
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.TGPABINDER;
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void b(int i, String str) {
        a(i, str);
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void b(HashMap<String, String> hashMap) {
        a(hashMap);
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public String d() {
        return (this.d && this.c == null) ? "ERROR" : "ERROR";
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public boolean e() {
        return true;
    }

    public String h() {
        String supportStrategy;
        TGPAManager tGPAManager = this.c;
        return (tGPAManager == null || (supportStrategy = tGPAManager.getSupportStrategy()) == null) ? "ERROR" : supportStrategy;
    }

    public com.ihoc.mgpa.i.g i() {
        int supportState = this.c.getSupportState();
        if (supportState == 0) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder sdk is support.");
            this.d = true;
            return com.ihoc.mgpa.i.g.VMP_SUCCESS;
        }
        if (supportState == 1) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder sdk auth failed.");
            return com.ihoc.mgpa.i.g.TGPA_BINDER_AUTH_FAILED;
        }
        if (supportState == -1) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder sdk is not support.");
            return com.ihoc.mgpa.i.g.TGPA_BINDER_NOT_SUPPORT;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder sdk check failed.");
        return com.ihoc.mgpa.i.g.VMP_FAILED;
    }
}
