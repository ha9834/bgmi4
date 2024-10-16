package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class aol implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final Application f2008a;
    private final WeakReference<Application.ActivityLifecycleCallbacks> b;
    private boolean c = false;

    public aol(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.b = new WeakReference<>(activityLifecycleCallbacks);
        this.f2008a = application;
    }

    private final void a(zzun zzunVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.b.get();
            if (activityLifecycleCallbacks != null) {
                zzunVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.c) {
                    return;
                }
                this.f2008a.unregisterActivityLifecycleCallbacks(this);
                this.c = true;
            }
        } catch (Exception e) {
            zzawz.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new aom(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new aon(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new aoo(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new aop(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new aoq(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new aor(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new aos(this, activity));
    }
}
