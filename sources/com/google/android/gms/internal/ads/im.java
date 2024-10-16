package com.google.android.gms.internal.ads;

import android.os.Looper;

/* loaded from: classes2.dex */
final class im implements Runnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public im(il ilVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
