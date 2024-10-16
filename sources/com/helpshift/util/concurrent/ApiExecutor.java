package com.helpshift.util.concurrent;

/* loaded from: classes2.dex */
public interface ApiExecutor {
    void awaitForSyncExecution();

    void runAsync(Runnable runnable);

    void runOnUiThread(Runnable runnable);

    void runSync(Runnable runnable);
}
