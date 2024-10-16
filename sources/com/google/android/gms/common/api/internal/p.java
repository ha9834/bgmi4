package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
abstract class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaak f1371a;

    private p(zaak zaakVar) {
        this.f1371a = zaakVar;
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        Lock lock2;
        zabe zabeVar;
        lock = this.f1371a.b;
        lock.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
        } catch (RuntimeException e) {
            zabeVar = this.f1371a.f1386a;
            zabeVar.a(e);
        } finally {
            lock2 = this.f1371a.b;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(zaak zaakVar, g gVar) {
        this(zaakVar);
    }
}
