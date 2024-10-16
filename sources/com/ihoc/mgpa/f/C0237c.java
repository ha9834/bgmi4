package com.ihoc.mgpa.f;

/* renamed from: com.ihoc.mgpa.f.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0237c {
    public static String a(String str) {
        return null;
    }

    public static String a(String str, com.ihoc.mgpa.j.A a2) {
        if (!com.ihoc.mgpa.i.f.ea()) {
            com.ihoc.mgpa.n.m.a("TGPA", "do not need transform scene for vendor/game/channel.");
            return str;
        }
        if (com.ihoc.mgpa.g.o.b().c.c == null) {
            com.ihoc.mgpa.n.m.b("TGPA", "can't get transform scene config from cloud, ple check it.");
            return str;
        }
        String a3 = com.ihoc.mgpa.g.o.b().c.c.a(str);
        return a3 != null ? a3 : str;
    }
}
