package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class DefaultClock implements Clock {

    /* renamed from: a, reason: collision with root package name */
    private static final DefaultClock f1501a = new DefaultClock();

    @KeepForSdk
    public static Clock getInstance() {
        return f1501a;
    }

    @Override // com.google.android.gms.common.util.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long nanoTime() {
        return System.nanoTime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    private DefaultClock() {
    }
}
