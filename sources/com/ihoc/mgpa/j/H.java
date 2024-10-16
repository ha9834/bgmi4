package com.ihoc.mgpa.j;

/* loaded from: classes2.dex */
class H implements InterfaceC0250b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f5627a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(L l) {
        this.f5627a = l;
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void a() {
        if (this.f5627a.i() == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder sdk is available.");
            com.ihoc.mgpa.i.f.c(true);
            z.c = this.f5627a.b();
            this.f5627a.j();
            com.ihoc.mgpa.f.G.a(this.f5627a.h());
            this.f5627a.c();
            this.f5627a.a(com.ihoc.mgpa.a.e.EVENT_REPORT_PERIOD.a(), String.valueOf(1000));
        }
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void b() {
    }
}
