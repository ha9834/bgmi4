package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class agb implements zzdu {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f1860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public agb(aeg aegVar, Activity activity) {
        this.f1860a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f1860a);
    }
}
