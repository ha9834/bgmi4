package com.ihoc.mgpa.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class u implements m {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f5582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(v vVar) {
        this.f5582a = vVar;
    }

    @Override // com.ihoc.mgpa.g.m
    public boolean a(com.ihoc.mgpa.i.g gVar, String str) {
        v vVar;
        com.ihoc.mgpa.i.g a2;
        com.ihoc.mgpa.i.g gVar2;
        if (gVar != com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.b("predownload download config failed, result: " + gVar.a(), new Object[0]);
            this.f5582a.d = gVar;
        } else {
            if (str == null) {
                com.ihoc.mgpa.n.m.b("predownload download config failed, data is null.", new Object[0]);
                vVar = this.f5582a;
                a2 = com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_DATA_IS_NULL;
            } else {
                vVar = this.f5582a;
                a2 = vVar.a(str);
            }
            vVar.d = a2;
        }
        gVar2 = this.f5582a.d;
        return gVar2 == com.ihoc.mgpa.i.g.VMP_SUCCESS;
    }
}
