package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: classes.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a, reason: collision with root package name */
    private static final BackgroundDetector f1304a = new BackgroundDetector();
    private final AtomicBoolean b = new AtomicBoolean();
    private final AtomicBoolean c = new AtomicBoolean();

    @GuardedBy("sInstance")
    private final ArrayList<BackgroundStateChangeListener> d = new ArrayList<>();

    @GuardedBy("sInstance")
    private boolean e = false;

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return f1304a;
    }

    @KeepForSdk
    public static void initialize(Application application) {
        synchronized (f1304a) {
            if (!f1304a.e) {
                application.registerActivityLifecycleCallbacks(f1304a);
                application.registerComponentCallbacks(f1304a);
                f1304a.e = true;
            }
        }
    }

    @KeepForSdk
    @TargetApi(16)
    public final boolean readCurrentStateIfPossible(boolean z) {
        if (!this.c.get()) {
            if (!PlatformVersion.isAtLeastJellyBean()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.b.set(true);
            }
        }
        return isInBackground();
    }

    @KeepForSdk
    public final boolean isInBackground() {
        return this.b.get();
    }

    @KeepForSdk
    public final void addListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f1304a) {
            this.d.add(backgroundStateChangeListener);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.b.compareAndSet(true, false);
        this.c.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.b.compareAndSet(true, false);
        this.c.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.b.compareAndSet(false, true)) {
            this.c.set(true);
            a(true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(boolean z) {
        synchronized (f1304a) {
            ArrayList<BackgroundStateChangeListener> arrayList = this.d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                BackgroundStateChangeListener backgroundStateChangeListener = arrayList.get(i);
                i++;
                backgroundStateChangeListener.onBackgroundStateChanged(z);
            }
        }
    }
}
