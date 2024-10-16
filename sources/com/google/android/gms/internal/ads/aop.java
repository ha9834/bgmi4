package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class aop implements zzun {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2012a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aop(aol aolVar, Activity activity) {
        this.f2012a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f2012a);
    }
}
