package com.vk.api.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f6908a = new q();
    private static final AtomicInteger b = new AtomicInteger();
    private static final kotlin.c c = kotlin.d.a(new kotlin.jvm.a.a<Handler>() { // from class: com.vk.api.sdk.VKScheduler$handler$2
        @Override // kotlin.jvm.a.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler b() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private static final kotlin.c d = kotlin.d.a(VKScheduler$networkExecutor$2.f6856a);

    private q() {
    }

    private final Handler c() {
        return (Handler) c.a();
    }

    public final ExecutorService a() {
        Object a2 = d.a();
        kotlin.jvm.internal.h.a(a2, "<get-networkExecutor>(...)");
        return (ExecutorService) a2;
    }

    public static /* synthetic */ void a(Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        a(runnable, j);
    }

    public static final void a(Runnable runnable, long j) {
        kotlin.jvm.internal.h.b(runnable, "runnable");
        if (kotlin.jvm.internal.h.a(Looper.myLooper(), Looper.getMainLooper()) && j == 0) {
            runnable.run();
        } else {
            f6908a.c().postDelayed(runnable, j);
        }
    }
}
