package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes2.dex */
public final class zzr {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4957a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(Context context) {
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
