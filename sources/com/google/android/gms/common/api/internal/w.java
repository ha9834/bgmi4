package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    private final zabd f1378a;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(zabd zabdVar) {
        this.f1378a = zabdVar;
    }

    protected abstract void a();

    public final void a(zabe zabeVar) {
        Lock lock;
        Lock lock2;
        zabd zabdVar;
        lock = zabeVar.f;
        lock.lock();
        try {
            zabdVar = zabeVar.n;
            if (zabdVar != this.f1378a) {
                return;
            }
            a();
        } finally {
            lock2 = zabeVar.f;
            lock2.unlock();
        }
    }
}
