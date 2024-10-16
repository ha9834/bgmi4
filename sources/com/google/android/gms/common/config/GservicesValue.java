package com.google.android.gms.common.config;

import android.content.Context;
import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GservicesValue<T> {
    private static final Object c = new Object();
    private static a d = null;
    private static int e = 0;
    private static Context f;

    @GuardedBy("sLock")
    private static HashSet<String> g;

    /* renamed from: a, reason: collision with root package name */
    protected final String f1411a;
    protected final T b;
    private T h = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        Boolean a(String str, Boolean bool);

        Float a(String str, Float f);

        Integer a(String str, Integer num);

        Long a(String str, Long l);

        String a(String str, String str2);
    }

    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (c) {
        }
        return false;
    }

    protected abstract T a(String str);

    private static boolean a() {
        synchronized (c) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GservicesValue(String str, T t) {
        this.f1411a = str;
        this.b = t;
    }

    @VisibleForTesting
    @KeepForSdk
    public void override(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.h = t;
        synchronized (c) {
            a();
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void resetOverride() {
        this.h = null;
    }

    @KeepForSdk
    public final T get() {
        T t = this.h;
        if (t != null) {
            return t;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        synchronized (c) {
        }
        synchronized (c) {
            g = null;
            f = null;
        }
        try {
            try {
                T a2 = a(this.f1411a);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return a2;
            } catch (SecurityException unused) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    T a3 = a(this.f1411a);
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    return a3;
                } finally {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    @KeepForSdk
    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new com.google.android.gms.common.config.a(str, Boolean.valueOf(z));
    }

    @KeepForSdk
    public static GservicesValue<Long> value(String str, Long l) {
        return new b(str, l);
    }

    @KeepForSdk
    public static GservicesValue<Integer> value(String str, Integer num) {
        return new c(str, num);
    }

    @KeepForSdk
    public static GservicesValue<Float> value(String str, Float f2) {
        return new d(str, f2);
    }

    @KeepForSdk
    public static GservicesValue<String> value(String str, String str2) {
        return new e(str, str2);
    }
}
