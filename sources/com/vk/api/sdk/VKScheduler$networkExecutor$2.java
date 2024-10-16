package com.vk.api.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
final class VKScheduler$networkExecutor$2 extends Lambda implements kotlin.jvm.a.a<ExecutorService> {

    /* renamed from: a, reason: collision with root package name */
    public static final VKScheduler$networkExecutor$2 f6856a = new VKScheduler$networkExecutor$2();

    VKScheduler$networkExecutor$2() {
        super(0);
    }

    @Override // kotlin.jvm.a.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ExecutorService b() {
        return Executors.newFixedThreadPool(32, new ThreadFactory() { // from class: com.vk.api.sdk.-$$Lambda$VKScheduler$networkExecutor$2$rHiYBMs_jQdkv6M2mOzOHVFnp50
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread a2;
                a2 = VKScheduler$networkExecutor$2.a(runnable);
                return a2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread a(Runnable runnable) {
        AtomicInteger atomicInteger;
        atomicInteger = q.b;
        return new Thread(runnable, kotlin.jvm.internal.h.a("vk-api-network-thread-", (Object) Integer.valueOf(atomicInteger.getAndIncrement())));
    }
}
