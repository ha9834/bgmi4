package com.ihoc.mgpa.j;

/* loaded from: classes2.dex */
class r implements InterfaceC0250b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f5648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(w wVar) {
        this.f5648a = wVar;
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void a() {
        String k;
        if (this.f5648a.i() == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung2 sdk is available. ");
            z.c = this.f5648a.b();
            com.ihoc.mgpa.i.f.c(true);
            this.f5648a.l();
            if (w.g().e()) {
                com.ihoc.mgpa.n.m.a("TGPA", "samsung2 sdk spa is available. ");
                this.f5648a.a(60.0f);
                com.ihoc.mgpa.i.f.h(1);
            }
            k = this.f5648a.k();
            com.ihoc.mgpa.i.f.aa = k;
            com.ihoc.mgpa.f.G.a(this.f5648a.h());
        }
        this.f5648a.c();
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void b() {
    }
}
