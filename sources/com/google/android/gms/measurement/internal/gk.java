package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

/* loaded from: classes2.dex */
final class gk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzp f4885a;
    private final /* synthetic */ zzai b;
    private final /* synthetic */ String c;
    private final /* synthetic */ AppMeasurementDynamiteService d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzpVar, zzai zzaiVar, String str) {
        this.d = appMeasurementDynamiteService;
        this.f4885a = zzpVar;
        this.b = zzaiVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.f4719a.zzs().zza(this.f4885a, this.b, this.c);
    }
}
