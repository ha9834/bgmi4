package com.ihoc.mgpa.j;

/* renamed from: com.ihoc.mgpa.j.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0254f extends C0252d {
    private static volatile C0254f h;

    private C0254f() {
    }

    public static C0254f g() {
        if (h == null) {
            synchronized (C0254f.class) {
                if (h == null) {
                    h = new C0254f();
                }
            }
        }
        return h;
    }

    @Override // com.ihoc.mgpa.j.C0252d, com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        if (h() == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "koghuawei sdk is available.");
            z.c = b();
            com.ihoc.mgpa.i.f.c(true);
        }
        c();
    }

    @Override // com.ihoc.mgpa.j.C0252d, com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.KOGHUAWEI;
    }
}
