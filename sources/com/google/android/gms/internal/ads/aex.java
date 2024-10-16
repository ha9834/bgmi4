package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class aex implements zzdu {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f1839a;
    private final /* synthetic */ Bundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aex(aeg aegVar, Activity activity, Bundle bundle) {
        this.f1839a = activity;
        this.b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f1839a, this.b);
    }
}
