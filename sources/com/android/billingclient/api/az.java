package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class az implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadFactory f959a = Executors.defaultThreadFactory();
    private final AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(e eVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f959a.newThread(runnable);
        int andIncrement = this.b.getAndIncrement();
        StringBuilder sb = new StringBuilder(30);
        sb.append("PlayBillingLibrary-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
