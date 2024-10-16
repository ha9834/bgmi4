package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class aom implements zzun {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2009a;
    private final /* synthetic */ Bundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aom(aol aolVar, Activity activity, Bundle bundle) {
        this.f2009a = activity;
        this.b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f2009a, this.b);
    }
}
