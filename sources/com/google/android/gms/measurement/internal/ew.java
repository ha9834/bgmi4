package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ew implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4845a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ew(zzgp zzgpVar, AtomicReference atomicReference) {
        this.b = zzgpVar;
        this.f4845a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4845a) {
            try {
                this.f4845a.set(Integer.valueOf(this.b.zzad().zzb(this.b.zzr().c(), zzak.zzhp)));
            } finally {
                this.f4845a.notify();
            }
        }
    }
}
