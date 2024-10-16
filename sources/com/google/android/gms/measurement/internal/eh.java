package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class eh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4830a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(zzgp zzgpVar, AtomicReference atomicReference) {
        this.b = zzgpVar;
        this.f4830a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4830a) {
            try {
                this.f4830a.set(Boolean.valueOf(this.b.zzad().d(this.b.zzr().c())));
            } finally {
                this.f4830a.notify();
            }
        }
    }
}
