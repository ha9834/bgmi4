package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbuz<T> {
    public Executor zzffi;
    public T zzflc;

    public static <T> zzbuz<T> zzb(T t, Executor executor) {
        return new zzbuz<>(t, executor);
    }

    public zzbuz(T t, Executor executor) {
        this.zzflc = t;
        this.zzffi = executor;
    }
}
