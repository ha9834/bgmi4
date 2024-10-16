package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes2.dex */
final class aje extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ajd f1909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aje(ajd ajdVar) {
        this.f1909a = ajdVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f1909a.a(message);
    }
}
