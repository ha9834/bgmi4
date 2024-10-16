package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class et implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4842a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public et(zzgp zzgpVar, AtomicReference atomicReference) {
        this.b = zzgpVar;
        this.f4842a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4842a) {
            try {
                this.f4842a.set(Long.valueOf(this.b.zzad().zza(this.b.zzr().c(), zzak.zzho)));
            } finally {
                this.f4842a.notify();
            }
        }
    }
}
