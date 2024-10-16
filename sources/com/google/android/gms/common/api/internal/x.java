package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends zap {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zabe f1379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(zabe zabeVar, Looper looper) {
        super(looper);
        this.f1379a = zabeVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((w) message.obj).a(this.f1379a);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                int i = message.what;
                StringBuilder sb = new StringBuilder(31);
                sb.append("Unknown message id: ");
                sb.append(i);
                Log.w("GACStateManager", sb.toString());
                return;
        }
    }
}
