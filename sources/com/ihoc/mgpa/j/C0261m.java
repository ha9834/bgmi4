package com.ihoc.mgpa.j;

/* renamed from: com.ihoc.mgpa.j.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0261m implements InterfaceC0250b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f5643a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0261m(x xVar) {
        this.f5643a = xVar;
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void a() {
        String k;
        if (this.f5643a.i() == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk is available. ");
            z.c = this.f5643a.b();
            com.ihoc.mgpa.i.f.c(true);
            this.f5643a.l();
            if (x.g().e()) {
                com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk spa is available. ");
                this.f5643a.a(60.0f);
                com.ihoc.mgpa.i.f.h(1);
            }
            k = this.f5643a.k();
            com.ihoc.mgpa.i.f.aa = k;
            com.ihoc.mgpa.f.G.a(this.f5643a.h());
        }
        this.f5643a.c();
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void b() {
    }
}
