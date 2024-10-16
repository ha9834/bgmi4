package com.ihoc.mgpa.j;

import com.samsung.android.game.gamelibnew.GameServiceHelper;

/* renamed from: com.ihoc.mgpa.j.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0263o implements GameServiceHelper.BindListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC0250b f5645a;
    final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0263o(x xVar, InterfaceC0250b interfaceC0250b) {
        this.b = xVar;
        this.f5645a = interfaceC0250b;
    }

    @Override // com.samsung.android.game.gamelibnew.GameServiceHelper.BindListener
    public void bindCallBack() {
        com.ihoc.mgpa.n.m.a("TGPA", "SamSungSdkProxy:bindCallBack: success.");
        InterfaceC0250b interfaceC0250b = this.f5645a;
        if (interfaceC0250b != null) {
            interfaceC0250b.a();
        }
    }
}
