package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class aak implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f1760a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f1760a.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
