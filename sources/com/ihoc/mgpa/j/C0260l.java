package com.ihoc.mgpa.j;

import com.oppo.oiface.OifaceManager;
import java.util.HashMap;

/* renamed from: com.ihoc.mgpa.j.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0260l extends C0249a {
    private static volatile C0260l b;
    private OifaceManager c = new OifaceManager();
    private boolean d = false;
    private int e = -1;

    private C0260l() {
    }

    public static C0260l g() {
        if (b == null) {
            synchronized (C0260l.class) {
                if (b == null) {
                    b = new C0260l();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.ihoc.mgpa.n.m.a("TGPA", "oppo: register callback after init.");
        this.c.systemStatus(new BinderC0259k(this));
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        this.c.bind(com.ihoc.mgpa.n.a.a(), new C0258j(this));
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(int i, String str) {
        if (this.d) {
            a(com.ihoc.mgpa.f.G.a(i, str, b()));
        }
    }

    public void a(String str) {
        if (!this.d || str == null || str.length() <= 2) {
            return;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "updateGameInfo: oppo json:  " + str);
        this.c.updateGameInfo(str);
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(HashMap<String, String> hashMap) {
        if (this.d) {
            a(com.ihoc.mgpa.f.G.a(hashMap, b()));
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.OPPO;
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

    public com.ihoc.mgpa.i.g h() {
        if (this.c.getSdkVersion() == null) {
            return com.ihoc.mgpa.i.g.OPPO_MOBILE_NOT_SUPPORT_SDK;
        }
        this.d = true;
        return com.ihoc.mgpa.i.g.VMP_SUCCESS;
    }
}
