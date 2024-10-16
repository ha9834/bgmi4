package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ait implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzr f1898a;
    private final /* synthetic */ zzd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ait(zzd zzdVar, zzr zzrVar) {
        this.b = zzdVar;
        this.f1898a = zzrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.b.c;
            blockingQueue.put(this.f1898a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
