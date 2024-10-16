package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

/* loaded from: classes2.dex */
final class gz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzp f4899a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ AppMeasurementDynamiteService d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzpVar, String str, String str2) {
        this.d = appMeasurementDynamiteService;
        this.f4899a = zzpVar;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.f4719a.zzs().a(this.f4899a, this.b, this.c);
    }
}
