package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class aid implements zzdu {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f1889a;
    private final /* synthetic */ Bundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aid(aeg aegVar, Activity activity, Bundle bundle) {
        this.f1889a = activity;
        this.b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f1889a, this.b);
    }
}
