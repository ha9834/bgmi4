package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class LockOnGetVariable<T> {
    private CountDownLatch initLatch;
    private T storedValue;

    public final T getValue() {
        waitOnInit();
        return this.storedValue;
    }

    public LockOnGetVariable(T t) {
        this.storedValue = t;
    }

    public LockOnGetVariable(final Callable<T> callable) {
        h.b(callable, "callable");
        this.initLatch = new CountDownLatch(1);
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable<Void>() { // from class: com.facebook.internal.LockOnGetVariable.1
            @Override // java.util.concurrent.Callable
            public final Void call() {
                try {
                    LockOnGetVariable.this.storedValue = callable.call();
                } finally {
                    CountDownLatch countDownLatch = LockOnGetVariable.this.initLatch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            }
        }));
    }

    private final void waitOnInit() {
        CountDownLatch countDownLatch = this.initLatch;
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }
}
