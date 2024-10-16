package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public class zap extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zaq f3852a;

    public zap() {
    }

    public zap(Looper looper) {
        super(looper);
    }

    public zap(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }
}
