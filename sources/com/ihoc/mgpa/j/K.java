package com.ihoc.mgpa.j;

import com.ihoc.mgpa.vendorsdk.v1_0.IVendorCallback;

/* loaded from: classes2.dex */
class K extends IVendorCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f5630a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(L l) {
        this.f5630a = l;
    }

    @Override // com.tencent.tgpa.v1_0.ICallBack
    public void systemCallBack(String str, String str2) {
        try {
            this.f5630a.a(str, String.valueOf(str2));
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder: systemCallBack: exception.");
        }
    }
}
