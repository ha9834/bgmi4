package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class afp implements zzdu {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f1851a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public afp(aeg aegVar, Activity activity) {
        this.f1851a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f1851a);
    }
}
