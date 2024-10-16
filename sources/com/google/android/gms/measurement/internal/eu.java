package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class eu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4843a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ zzgp f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eu(zzgp zzgpVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f = zzgpVar;
        this.f4843a = atomicReference;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f.v.zzs().a(this.f4843a, this.b, this.c, this.d, this.e);
    }
}
