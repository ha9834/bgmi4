package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class aos implements zzun {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2015a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aos(aol aolVar, Activity activity) {
        this.f2015a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f2015a);
    }
}
