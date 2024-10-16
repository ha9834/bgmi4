package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class eq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4839a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(zzgp zzgpVar, AtomicReference atomicReference) {
        this.b = zzgpVar;
        this.f4839a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4839a) {
            try {
                this.f4839a.set(this.b.zzad().e(this.b.zzr().c()));
            } finally {
                this.f4839a.notify();
            }
        }
    }
}
