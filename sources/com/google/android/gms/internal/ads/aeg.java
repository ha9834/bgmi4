package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class aeg implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final Application f1828a;
    private final WeakReference<Application.ActivityLifecycleCallbacks> b;
    private boolean c = false;

    public aeg(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.b = new WeakReference<>(activityLifecycleCallbacks);
        this.f1828a = application;
    }

    private final void a(zzdu zzduVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.b.get();
            if (activityLifecycleCallbacks != null) {
                zzduVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.c) {
                    return;
                }
                this.f1828a.unregisterActivityLifecycleCallbacks(this);
                this.c = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new aex(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new afp(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new agb(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new agv(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new aht(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new aid(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new aio(this, activity));
    }
}
