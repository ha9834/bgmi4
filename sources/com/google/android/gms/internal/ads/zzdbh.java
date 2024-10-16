package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public class zzdbh extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzdbi f3534a;

    public zzdbh() {
    }

    public zzdbh(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        a(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Message message) {
        super.dispatchMessage(message);
    }
}
