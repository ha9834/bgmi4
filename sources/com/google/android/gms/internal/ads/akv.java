package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
final class akv extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ aku f1942a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public akv(aku akuVar, Looper looper) {
        super(looper);
        this.f1942a = akuVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f1942a.a(message);
    }
}
