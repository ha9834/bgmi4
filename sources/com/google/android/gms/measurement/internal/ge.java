package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes2.dex */
final class ge implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzin f4879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ge(zzin zzinVar) {
        this.f4879a = zzinVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhv zzhvVar = this.f4879a.f4949a;
        Context context = this.f4879a.f4949a.getContext();
        this.f4879a.f4949a.zzae();
        zzhvVar.a(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
