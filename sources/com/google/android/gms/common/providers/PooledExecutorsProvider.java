package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
/* loaded from: classes.dex */
public class PooledExecutorsProvider {

    /* renamed from: a, reason: collision with root package name */
    private static PooledExecutorFactory f1483a;

    /* loaded from: classes.dex */
    public interface PooledExecutorFactory {
        @KeepForSdk
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    @KeepForSdk
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (f1483a == null) {
                f1483a = new a();
            }
            pooledExecutorFactory = f1483a;
        }
        return pooledExecutorFactory;
    }

    private PooledExecutorsProvider() {
    }
}
