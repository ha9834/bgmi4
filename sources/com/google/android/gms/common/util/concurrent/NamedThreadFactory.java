package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
/* loaded from: classes.dex */
public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final String f1510a;
    private final int b;
    private final ThreadFactory c;

    @KeepForSdk
    public NamedThreadFactory(String str) {
        this(str, 0);
    }

    private NamedThreadFactory(String str, int i) {
        this.c = Executors.defaultThreadFactory();
        this.f1510a = (String) Preconditions.checkNotNull(str, "Name must not be null");
        this.b = 0;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.c.newThread(new a(runnable, 0));
        newThread.setName(this.f1510a);
        return newThread;
    }
}
