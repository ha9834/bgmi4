package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class aoo implements zzun {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2011a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aoo(aol aolVar, Activity activity) {
        this.f2011a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f2011a);
    }
}
