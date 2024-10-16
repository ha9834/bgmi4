package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class el implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4834a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzgp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(zzgp zzgpVar, AtomicReference atomicReference, boolean z) {
        this.c = zzgpVar;
        this.f4834a = atomicReference;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.zzs().a(this.f4834a, this.b);
    }
}
