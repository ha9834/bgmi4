package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ais implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadFactory f1897a = Executors.defaultThreadFactory();
    private final AtomicInteger b = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f1897a.newThread(runnable);
        int andIncrement = this.b.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
