package com.ihoc.mgpa.j;

import android.content.Context;
import com.xiaomi.boostersdk.GameBoosterManager;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class V extends C0249a {
    private static volatile V b;
    private boolean c = false;
    private int d = -1;

    private V() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    private boolean a(Context context) {
        T t = new T(this);
        U u = new U(this);
        try {
            GameBoosterManager.registerThermalControlListener(context, t);
            GameBoosterManager.registerSystemCallback(context, u);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static V g() {
        if (b == null) {
            synchronized (V.class) {
                if (b == null) {
                    b = new V();
                }
            }
        }
        return b;
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        if (i() == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "xiaomi sdk is available.");
            z.c = b();
            com.ihoc.mgpa.i.f.c(true);
            if (!a(com.ihoc.mgpa.n.a.a())) {
                com.ihoc.mgpa.n.m.a("TGPA", "registerGame: xiaomi callback register failed.");
            }
            String h = h();
            if (h != null) {
                com.ihoc.mgpa.f.G.a(h);
            }
        }
        c();
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(int i, String str) {
        if (this.c) {
            a(com.ihoc.mgpa.f.G.a(i, str, b()));
        }
    }

    public void a(String str) {
        if (!this.c || str == null || str.length() <= 2) {
            return;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "updateGameInfo: xiaomi json: " + String.valueOf(str));
        GameBoosterManager.updateGameInfo(str);
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(HashMap<String, String> hashMap) {
        if (this.c) {
            a(com.ihoc.mgpa.f.G.a(hashMap, b()));
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.XIAOMI;
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
        return "ERROR";
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public boolean e() {
        return true;
    }

    public String h() {
        return GameBoosterManager.getPlatformShareGameData(1003, null);
    }

    public com.ihoc.mgpa.i.g i() {
        com.ihoc.mgpa.n.m.a("TGPA", "checking xiaomi sdk available....");
        this.c = GameBoosterManager.checkIfSupportGameBooster();
        if (this.c) {
            com.ihoc.mgpa.n.m.a("TGPA", "xiaomi sdk is support.");
            return com.ihoc.mgpa.i.g.VMP_SUCCESS;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "xiaomi sdk is not support.");
        return com.ihoc.mgpa.i.g.XIAOMI_MOBILE_NOT_SUPPORT_SDK;
    }
}
