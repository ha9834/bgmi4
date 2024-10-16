package com.ihoc.mgpa.j;

/* loaded from: classes2.dex */
class P implements InterfaceC0250b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f5633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(S s) {
        this.f5633a = s;
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void a() {
        com.ihoc.mgpa.n.m.a("TGPA", "common socket is available. sdk_type: " + this.f5633a.b().a());
        z.c = this.f5633a.b();
        com.ihoc.mgpa.i.f.c(true);
        this.f5633a.c();
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void b() {
        this.f5633a.c();
    }
}
