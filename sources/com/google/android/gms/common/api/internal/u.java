package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends zap {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaaw f1376a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(zaaw zaawVar, Looper looper) {
        super(looper);
        this.f1376a = zaawVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f1376a.g();
                return;
            case 2:
                this.f1376a.f();
                return;
            default:
                int i = message.what;
                StringBuilder sb = new StringBuilder(31);
                sb.append("Unknown message id: ");
                sb.append(i);
                Log.w("GoogleApiClientImpl", sb.toString());
                return;
        }
    }
}
