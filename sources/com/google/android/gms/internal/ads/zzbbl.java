package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public interface zzbbl extends ExecutorService {
    <T> zzbbh<T> zza(Callable<T> callable);

    zzbbh<?> zze(Runnable runnable);
}
