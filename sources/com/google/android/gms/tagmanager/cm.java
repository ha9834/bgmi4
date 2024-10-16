package com.google.android.gms.tagmanager;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cm implements cn {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ck f5105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ck ckVar) {
        this.f5105a = ckVar;
    }

    @Override // com.google.android.gms.tagmanager.cn
    public final cj a(k kVar) {
        Context context;
        String str;
        context = this.f5105a.b;
        str = this.f5105a.f5104a;
        return new cj(context, str, kVar);
    }
}
