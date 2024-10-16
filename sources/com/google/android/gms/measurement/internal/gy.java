package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

/* loaded from: classes2.dex */
final class gy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzp f4898a;
    private final /* synthetic */ AppMeasurementDynamiteService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzpVar) {
        this.b = appMeasurementDynamiteService;
        this.f4898a = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f4719a.zzz().zza(this.f4898a, this.b.f4719a.zzib());
    }
}
