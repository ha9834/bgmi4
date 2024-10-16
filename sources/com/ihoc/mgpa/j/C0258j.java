package com.ihoc.mgpa.j;

import com.oppo.oiface.COSAServiceConnectCallback;

/* renamed from: com.ihoc.mgpa.j.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0258j implements COSAServiceConnectCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0260l f5641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0258j(C0260l c0260l) {
        this.f5641a = c0260l;
    }

    @Override // com.oppo.oiface.COSAServiceConnectCallback
    public void onServiceConnectFail() {
        com.ihoc.mgpa.n.m.a("TGPA", "oppo sdk is not available, bind service failed.");
        this.f5641a.c();
    }

    @Override // com.oppo.oiface.COSAServiceConnectCallback
    public void onServiceConnected() {
        if (com.ihoc.mgpa.i.g.VMP_SUCCESS == this.f5641a.h()) {
            com.ihoc.mgpa.n.m.a("TGPA", "oppo sdk is available, bind service sucess.");
            z.c = this.f5641a.b();
            com.ihoc.mgpa.i.f.c(true);
            this.f5641a.i();
        }
        this.f5641a.c();
    }
}
