package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ej implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4832a;
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;
    private final /* synthetic */ Bundle d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ boolean f;
    private final /* synthetic */ boolean g;
    private final /* synthetic */ String h;
    private final /* synthetic */ zzgp i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ej(zzgp zzgpVar, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.i = zzgpVar;
        this.f4832a = str;
        this.b = str2;
        this.c = j;
        this.d = bundle;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.i.a(this.f4832a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
