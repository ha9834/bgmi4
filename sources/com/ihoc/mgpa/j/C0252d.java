package com.ihoc.mgpa.j;

import com.huawei.game.gamekit.GameManager;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ihoc.mgpa.j.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0252d extends C0249a {
    private static volatile C0252d b;
    private GameManager c = GameManager.getGameManager();
    private GameManager.GameCallBack d = null;
    private boolean e = false;
    private int f = -1;
    private boolean g = false;

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    private String c(int i, String str) {
        StringBuilder sb = new StringBuilder("{");
        if (com.ihoc.mgpa.a.e.SCENE.a() == i) {
            if (str.equals(com.ihoc.mgpa.a.g.PLAYING.a()) && !this.g) {
                sb.append("\"");
                sb.append(com.ihoc.mgpa.a.d.STATUS.a());
                sb.append("\":");
                sb.append("1,");
                this.g = true;
            }
            if ((str.equals(com.ihoc.mgpa.a.g.MAIN_UI.a()) || str.equals(com.ihoc.mgpa.a.g.SCENE_LOAD.a()) || str.equals(com.ihoc.mgpa.a.g.DEFAULT.a())) && this.g) {
                sb.append("\"");
                sb.append(com.ihoc.mgpa.a.d.STATUS.a());
                sb.append("\":");
                sb.append("0,");
                this.g = false;
            }
        }
        if (sb.length() <= 2) {
            return null;
        }
        sb.append("\"MessageType\":");
        sb.append(com.ihoc.mgpa.a.d.STATUS.c());
        sb.append("}");
        return sb.toString();
    }

    public static C0252d g() {
        if (b == null) {
            synchronized (C0252d.class) {
                if (b == null) {
                    b = new C0252d();
                }
            }
        }
        return b;
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        if (h() == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "huaweikit sdk is available.");
            z.c = b();
            com.ihoc.mgpa.i.f.c(true);
            this.c.updateGameAppInfo("{\"MessageType\": 10001}");
        }
        c();
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(int i, String str) {
        if (this.e) {
            String a2 = com.ihoc.mgpa.f.G.a(i, str, b());
            a(a2);
            if (a2 == null || a2.length() <= 2) {
                return;
            }
            a(c(i, str));
        }
    }

    public void a(String str) {
        if (!this.e || str == null || str.length() <= 2) {
            return;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "updateGameInfo: huawei json: " + str);
        this.c.updateGameAppInfo(str);
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(HashMap<String, String> hashMap) {
        if (this.e) {
            for (Map<String, String> map : com.ihoc.mgpa.a.d.a(hashMap)) {
                a(com.ihoc.mgpa.f.G.a(hashMap, b()));
            }
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.HUAWEI;
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
        return false;
    }

    public com.ihoc.mgpa.i.g h() {
        this.d = new C0251c(this);
        if (this.c.registerGame(com.ihoc.mgpa.n.a.c(), this.d, com.ihoc.mgpa.n.a.a())) {
            this.e = true;
            return com.ihoc.mgpa.i.g.VMP_SUCCESS;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "huawei sdk is not available.");
        this.e = false;
        return com.ihoc.mgpa.i.g.HUAWEI2_MOBILE_NOT_SUPPORT_SDK;
    }
}
