package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class agv implements zzdu {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f1871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public agv(aeg aegVar, Activity activity) {
        this.f1871a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f1871a);
    }
}
