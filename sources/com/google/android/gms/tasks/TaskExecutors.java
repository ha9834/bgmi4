package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new a();

    /* renamed from: a, reason: collision with root package name */
    static final Executor f5178a = new u();

    private TaskExecutors() {
    }

    /* loaded from: classes2.dex */
    private static final class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f5179a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f5179a.post(runnable);
        }
    }
}
