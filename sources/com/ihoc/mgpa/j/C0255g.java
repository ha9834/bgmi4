package com.ihoc.mgpa.j;

/* renamed from: com.ihoc.mgpa.j.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0255g implements InterfaceC0250b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0257i f5639a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0255g(C0257i c0257i) {
        this.f5639a = c0257i;
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void a() {
        com.ihoc.mgpa.n.m.a("TGPA", "kogsocket is available. sdk_type: " + this.f5639a.b().a());
        z.c = this.f5639a.b();
        com.ihoc.mgpa.i.f.c(true);
        this.f5639a.c();
    }

    @Override // com.ihoc.mgpa.j.InterfaceC0250b
    public void b() {
        com.ihoc.mgpa.n.m.a("TGPA", "kogsocket is not available. sdk_type: " + this.f5639a.b().a());
        this.f5639a.c();
    }
}
