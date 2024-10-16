package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public class zze extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzf f3867a;

    public zze() {
    }

    public zze(Looper looper) {
        super(looper);
    }

    public zze(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }
}
