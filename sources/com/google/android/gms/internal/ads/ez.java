package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ez implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f2163a = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(zzavg zzavgVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f2163a.getAndIncrement();
        StringBuilder sb = new StringBuilder(42);
        sb.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
