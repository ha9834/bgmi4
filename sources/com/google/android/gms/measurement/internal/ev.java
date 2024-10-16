package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ev implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4844a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(zzgp zzgpVar, AtomicReference atomicReference) {
        this.b = zzgpVar;
        this.f4844a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4844a) {
            try {
                this.f4844a.set(Double.valueOf(this.b.zzad().zzc(this.b.zzr().c(), zzak.zzhq)));
            } finally {
                this.f4844a.notify();
            }
        }
    }
}
