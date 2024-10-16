package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

@zzard
/* loaded from: classes2.dex */
public final class zzbbm {
    public static final Executor zzeae = new ho();
    public static final Executor zzeaf = new hp();
    public static final zzbbl zzeag = zza(zzeae);

    /* renamed from: a, reason: collision with root package name */
    private static final zzbbl f2850a = zza(zzeaf);

    public static zzbbl zza(Executor executor) {
        return new hq(executor, null);
    }
}
