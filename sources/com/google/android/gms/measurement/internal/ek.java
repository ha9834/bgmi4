package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ek implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4833a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(zzgp zzgpVar, AtomicReference atomicReference) {
        this.b = zzgpVar;
        this.f4833a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.zzs().zza(this.f4833a);
    }
}
