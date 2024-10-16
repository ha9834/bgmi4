package com.tencent.msdk.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f6315a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f6315a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Handler handler;
        Handler handler2;
        handler = this.f6315a.e;
        if (handler != null) {
            handler2 = this.f6315a.e;
            handler2.post(new c(this));
        }
    }
}
