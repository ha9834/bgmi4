package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ba f1352a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.f1352a = baVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        lock = this.f1352a.m;
        lock.lock();
        try {
            this.f1352a.a();
        } finally {
            lock2 = this.f1352a.m;
            lock2.unlock();
        }
    }
}
