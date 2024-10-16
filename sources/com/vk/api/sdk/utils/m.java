package com.vk.api.sdk.utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f6932a = new m();
    private static final ReentrantLock b = new ReentrantLock();
    private static final Condition c;

    private m() {
    }

    static {
        Condition newCondition = b.newCondition();
        kotlin.jvm.internal.h.a((Object) newCondition, "locker.newCondition()");
        c = newCondition;
    }

    public final void a() {
        try {
            ReentrantLock reentrantLock = b;
            reentrantLock.lock();
            try {
                c.await();
                kotlin.k kVar = kotlin.k.f6974a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } catch (InterruptedException unused) {
        }
    }

    public final void b() {
        ReentrantLock reentrantLock = b;
        reentrantLock.lock();
        try {
            c.signalAll();
            kotlin.k kVar = kotlin.k.f6974a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
