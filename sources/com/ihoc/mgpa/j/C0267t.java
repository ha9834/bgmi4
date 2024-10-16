package com.ihoc.mgpa.j;

import com.samsung.android.game.gamelib.GameServiceHelper;

/* renamed from: com.ihoc.mgpa.j.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0267t implements GameServiceHelper.BindListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC0250b f5650a;
    final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0267t(w wVar, InterfaceC0250b interfaceC0250b) {
        this.b = wVar;
        this.f5650a = interfaceC0250b;
    }

    @Override // com.samsung.android.game.gamelib.GameServiceHelper.BindListener
    public void bindCallBack() {
        com.ihoc.mgpa.n.m.a("TGPA", "SamSungSdkProxy2:bindCallBack: success.");
        InterfaceC0250b interfaceC0250b = this.f5650a;
        if (interfaceC0250b != null) {
            interfaceC0250b.a();
        }
    }
}
