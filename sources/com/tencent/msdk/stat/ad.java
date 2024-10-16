package com.tencent.msdk.stat;

import android.content.Context;

/* loaded from: classes.dex */
final class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6299a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Context context) {
        this.f6299a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatServiceImpl.flushDataToDB(this.f6299a);
    }
}
