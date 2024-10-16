package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class fb implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzgp f4851a;

    private fb(zzgp zzgpVar) {
        this.f4851a = zzgpVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0154 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e A[Catch: all -> 0x01dc, Exception -> 0x01de, Merged into TryCatch #1 {all -> 0x01dc, Exception -> 0x01de, blocks: (B:3:0x0000, B:8:0x001f, B:10:0x0025, B:13:0x002d, B:16:0x003d, B:18:0x0052, B:24:0x00ce, B:26:0x00da, B:28:0x00ef, B:31:0x00f9, B:33:0x0101, B:34:0x0116, B:35:0x011d, B:38:0x012d, B:41:0x0137, B:43:0x013f, B:44:0x014e, B:48:0x015e, B:50:0x0166, B:52:0x016e, B:54:0x0176, B:56:0x017e, B:58:0x0186, B:62:0x0191, B:65:0x01aa, B:67:0x01bf, B:70:0x0063, B:73:0x006b, B:75:0x0073, B:77:0x007b, B:79:0x0083, B:81:0x008b, B:82:0x009c, B:84:0x00ae, B:85:0x00b9, B:87:0x00c3, B:88:0x00b3, B:93:0x01df), top: B:1:0x0000 }, TRY_ENTER] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityCreated(android.app.Activity r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.fb.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f4851a.zzt().onActivityDestroyed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f4851a.zzt().onActivityPaused(activity);
        zziw zzv = this.f4851a.zzv();
        zzv.zzaa().zza(new gl(zzv, zzv.zzx().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.f4851a.zzt().onActivityResumed(activity);
        zziw zzv = this.f4851a.zzv();
        zzv.zzaa().zza(new gm(zzv, zzv.zzx().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f4851a.zzt().onActivitySaveInstanceState(activity, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ fb(zzgp zzgpVar, eh ehVar) {
        this(zzgpVar);
    }
}
