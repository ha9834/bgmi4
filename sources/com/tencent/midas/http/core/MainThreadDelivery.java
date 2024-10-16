package com.tencent.midas.http.core;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class MainThreadDelivery implements Delivery {
    private MainThreadExecutor executor = new MainThreadExecutor();

    @Override // com.tencent.midas.http.core.Delivery
    public void deliverResult(final Response response, final Callback callback) {
        if (callback == null) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.tencent.midas.http.core.MainThreadDelivery.1
            @Override // java.lang.Runnable
            public void run() {
                callback.onResponse(response);
            }
        });
    }

    /* loaded from: classes.dex */
    private static class MainThreadExecutor implements Executor {
        private final Handler handler;

        private MainThreadExecutor() {
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.handler.post(runnable);
        }
    }
}
