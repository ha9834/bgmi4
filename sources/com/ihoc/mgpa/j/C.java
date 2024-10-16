package com.ihoc.mgpa.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class C implements InterfaceC0250b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ G f5623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(G g) {
        this.f5623a = g;
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void a() {
        if (this.f5623a.i() == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder2 sdk is available.");
            com.ihoc.mgpa.i.f.c(true);
            z.c = this.f5623a.b();
            this.f5623a.j();
            com.ihoc.mgpa.f.G.a(this.f5623a.h());
            this.f5623a.a(com.ihoc.mgpa.a.e.EVENT_REPORT_PERIOD.a(), String.valueOf(1000));
        }
        this.f5623a.c();
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void b() {
    }
}
