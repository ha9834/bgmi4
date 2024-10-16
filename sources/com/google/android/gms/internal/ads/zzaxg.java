package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzard
/* loaded from: classes2.dex */
public final class zzaxg {
    public static final zzbbl zzdvp = zzbbm.zza(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), a("Default")));
    public static final zzbbl zzdvq;
    public static final ScheduledExecutorService zzdvr;

    public static <T> zzbbh<T> zza(Callable<T> callable) {
        return zzdvp.submit(callable);
    }

    private static ThreadFactory a(String str) {
        return new fm(str);
    }

    public static zzbbh<?> zzc(Runnable runnable) {
        return zzdvp.submit(runnable);
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), a("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        zzdvq = zzbbm.zza(threadPoolExecutor);
        zzdvr = new ScheduledThreadPoolExecutor(3, a(AppEventsConstants.EVENT_NAME_SCHEDULE));
    }
}
