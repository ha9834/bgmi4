package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

/* loaded from: classes2.dex */
final class fn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzp f4861a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ boolean d;
    private final /* synthetic */ AppMeasurementDynamiteService e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzpVar, String str, String str2, boolean z) {
        this.e = appMeasurementDynamiteService;
        this.f4861a = zzpVar;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.f4719a.zzs().a(this.f4861a, this.b, this.c, this.d);
    }
}
