package com.ihoc.mgpa.j;

import com.ihoc.mgpa.vendorsdk.v1_0.ServerBindCallback;

/* loaded from: classes2.dex */
class J implements ServerBindCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC0250b f5629a;
    final /* synthetic */ L b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(L l, InterfaceC0250b interfaceC0250b) {
        this.b = l;
        this.f5629a = interfaceC0250b;
    }

    @Override // com.ihoc.mgpa.vendorsdk.v1_0.ServerBindCallback
    public void bindCallBack() {
        com.ihoc.mgpa.n.m.a("TGPA", "TgpaServerProxy:bindCallBack: success.");
        InterfaceC0250b interfaceC0250b = this.f5629a;
        if (interfaceC0250b != null) {
            interfaceC0250b.a();
        }
    }
}
