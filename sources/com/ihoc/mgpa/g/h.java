package com.ihoc.mgpa.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements m {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f5564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar) {
        this.f5564a = iVar;
    }

    @Override // com.ihoc.mgpa.g.m
    public boolean a(com.ihoc.mgpa.i.g gVar, String str) {
        i iVar;
        com.ihoc.mgpa.i.g a2;
        com.ihoc.mgpa.i.g gVar2;
        if (gVar != com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.b("download config failed, result: " + gVar.a(), new Object[0]);
            this.f5564a.b = gVar;
        } else {
            if (str == null) {
                com.ihoc.mgpa.n.m.b("download config failed, data is null.", new Object[0]);
                iVar = this.f5564a;
                a2 = com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_DATA_IS_NULL;
            } else {
                iVar = this.f5564a;
                a2 = iVar.a(str);
            }
            iVar.b = a2;
        }
        gVar2 = this.f5564a.b;
        return gVar2 == com.ihoc.mgpa.i.g.VMP_SUCCESS;
    }
}
