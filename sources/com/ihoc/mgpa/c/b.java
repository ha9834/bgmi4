package com.ihoc.mgpa.c;

import com.ihoc.mgpa.dataforwardsdk.ICallBack;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends ICallBack.Stub {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f5493a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f5493a = cVar;
    }

    @Override // com.ihoc.mgpa.dataforwardsdk.ICallBack
    public void reportInfo(String str) {
        this.f5493a.b(str);
    }
}
