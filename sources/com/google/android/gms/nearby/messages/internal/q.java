package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes2.dex */
final class q implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f5017a;
    private final zzak b;

    private q(Activity activity, zzak zzakVar) {
        this.f5017a = activity;
        this.b = zzakVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(Activity activity, zzak zzakVar, j jVar) {
        this(activity, zzakVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.f5017a) {
            Log.v("NearbyMessages", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (activity == this.f5017a) {
            zzak.a(this.b, 1);
        }
    }
}
