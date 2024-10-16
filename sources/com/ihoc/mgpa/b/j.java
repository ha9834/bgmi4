package com.ihoc.mgpa.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class j implements h {
    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        com.ihoc.mgpa.c.m c;
        String str2;
        String str3;
        try {
            if (com.ihoc.mgpa.i.f.W()) {
                if (i == com.ihoc.mgpa.a.e.SUB_VERCODE.a()) {
                    com.ihoc.mgpa.i.f.u(str);
                    if (!com.ihoc.mgpa.n.p.a(com.ihoc.mgpa.i.f.j())) {
                        c = com.ihoc.mgpa.c.m.c();
                        c.a(com.ihoc.mgpa.i.f.j(), com.ihoc.mgpa.i.f.u());
                        return;
                    } else {
                        str2 = "TGPA_Predownload";
                        str3 = "no main version , do not need save/report version info.";
                        com.ihoc.mgpa.n.m.a(str2, str3);
                        return;
                    }
                }
                if (i == com.ihoc.mgpa.a.e.MAIN_VERCODE.a()) {
                    com.ihoc.mgpa.i.f.m(str);
                    if (!com.ihoc.mgpa.n.p.a(com.ihoc.mgpa.i.f.u())) {
                        c = com.ihoc.mgpa.c.m.c();
                        c.a(com.ihoc.mgpa.i.f.j(), com.ihoc.mgpa.i.f.u());
                        return;
                    } else {
                        str2 = "TGPA_Predownload";
                        str3 = "no sub version , do not need save/report version info.";
                        com.ihoc.mgpa.n.m.a(str2, str3);
                        return;
                    }
                }
                if (i == com.ihoc.mgpa.a.e.SCENE.a() && com.ihoc.mgpa.g.o.b().b.R) {
                    if (com.ihoc.mgpa.a.g.MAIN_UI.a().equals(str)) {
                        com.ihoc.mgpa.c.m.c().f();
                    } else if (com.ihoc.mgpa.a.g.PLAYING.a().equals(str)) {
                        com.ihoc.mgpa.c.m.c().e();
                    }
                }
            }
        } catch (Throwable unused) {
            com.ihoc.mgpa.n.m.b("TGPA_Predownload", "Predownload observer key data run exception, ple check it!");
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                a(Integer.parseInt(entry.getKey()), entry.getValue());
            }
        } catch (Throwable unused) {
            com.ihoc.mgpa.n.m.b("TGPA_Predownload", "Predownload observer map data run exception, ple check it!");
        }
    }
}
