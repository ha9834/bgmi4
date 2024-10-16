package com.ihoc.mgpa.j;

import com.ihoc.mgpa.vendorsdk.v2_0.ServerBindCallback;

/* loaded from: classes2.dex */
class E implements ServerBindCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC0250b f5625a;
    final /* synthetic */ G b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(G g, InterfaceC0250b interfaceC0250b) {
        this.b = g;
        this.f5625a = interfaceC0250b;
    }

    @Override // com.ihoc.mgpa.vendorsdk.v2_0.ServerBindCallback
    public void bindCallBack() {
        com.ihoc.mgpa.n.m.a("TGPA", "TgpaServer2Proxy:bindCallBack: success.");
        InterfaceC0250b interfaceC0250b = this.f5625a;
        if (interfaceC0250b != null) {
            interfaceC0250b.a();
        }
    }
}
