package com.ihoc.mgpa.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e implements com.ihoc.mgpa.g.m {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f5488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.f5488a = fVar;
    }

    @Override // com.ihoc.mgpa.g.m
    public boolean a(com.ihoc.mgpa.i.g gVar, String str) {
        if (gVar == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            if (str != null) {
                return new com.ihoc.mgpa.g.i().a(str) == com.ihoc.mgpa.i.g.VMP_SUCCESS;
            }
            com.ihoc.mgpa.n.m.b("download config failed, data is null.", new Object[0]);
            return false;
        }
        com.ihoc.mgpa.n.m.b("download config failed, result: " + gVar.a(), new Object[0]);
        return false;
    }
}
