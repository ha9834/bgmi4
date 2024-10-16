package com.ihoc.mgpa.j;

import com.ihoc.mgpa.vendorsdk.v2_0.ICallBack;

/* loaded from: classes2.dex */
class F extends ICallBack.Stub {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ G f5626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(G g) {
        this.f5626a = g;
    }

    @Override // com.ihoc.mgpa.vendorsdk.v2_0.ICallBack
    public void systemCallBack(String str, String str2) {
        try {
            this.f5626a.a(str, String.valueOf(str2));
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder2: systemCallBack: exception.");
        }
    }
}
