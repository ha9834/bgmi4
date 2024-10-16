package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class er implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4840a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ zzgp e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(zzgp zzgpVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.e = zzgpVar;
        this.f4840a = atomicReference;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.v.zzs().a(this.f4840a, this.b, this.c, this.d);
    }
}
