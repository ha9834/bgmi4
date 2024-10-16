package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import android.os.Process;

/* loaded from: classes2.dex */
public final class zzko extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    private final int f3673a;

    public zzko(String str, int i) {
        super(str);
        this.f3673a = -16;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f3673a);
        super.run();
    }
}
