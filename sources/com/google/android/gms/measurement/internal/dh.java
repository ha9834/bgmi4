package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dh extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final Object f4805a;
    private final BlockingQueue<di<?>> b;
    private final /* synthetic */ zzfc c;

    public dh(zzfc zzfcVar, String str, BlockingQueue<di<?>> blockingQueue) {
        this.c = zzfcVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.f4805a = new Object();
        this.b = blockingQueue;
        setName(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        dh dhVar;
        dh dhVar2;
        Object obj3;
        Object obj4;
        Semaphore semaphore2;
        Object obj5;
        dh dhVar3;
        dh dhVar4;
        boolean z;
        Semaphore semaphore3;
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore3 = this.c.h;
                semaphore3.acquire();
                z2 = true;
            } catch (InterruptedException e) {
                a(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                di<?> poll = this.b.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.f4806a ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.f4805a) {
                        if (this.b.peek() == null) {
                            z = this.c.i;
                            if (!z) {
                                try {
                                    this.f4805a.wait(30000L);
                                } catch (InterruptedException e2) {
                                    a(e2);
                                }
                            }
                        }
                    }
                    obj3 = this.c.g;
                    synchronized (obj3) {
                        if (this.b.peek() == null) {
                            break;
                        }
                    }
                }
            }
            obj4 = this.c.g;
            synchronized (obj4) {
                semaphore2 = this.c.h;
                semaphore2.release();
                obj5 = this.c.g;
                obj5.notifyAll();
                dhVar3 = this.c.f4940a;
                if (this == dhVar3) {
                    zzfc.a(this.c, null);
                } else {
                    dhVar4 = this.c.b;
                    if (this == dhVar4) {
                        zzfc.b(this.c, null);
                    } else {
                        this.c.zzab().zzgk().zzao("Current scheduler thread is neither worker nor network");
                    }
                }
            }
        } catch (Throwable th) {
            obj = this.c.g;
            synchronized (obj) {
                semaphore = this.c.h;
                semaphore.release();
                obj2 = this.c.g;
                obj2.notifyAll();
                dhVar = this.c.f4940a;
                if (this == dhVar) {
                    zzfc.a(this.c, null);
                } else {
                    dhVar2 = this.c.b;
                    if (this == dhVar2) {
                        zzfc.b(this.c, null);
                    } else {
                        this.c.zzab().zzgk().zzao("Current scheduler thread is neither worker nor network");
                    }
                }
                throw th;
            }
        }
    }

    public final void a() {
        synchronized (this.f4805a) {
            this.f4805a.notifyAll();
        }
    }

    private final void a(InterruptedException interruptedException) {
        this.c.zzab().zzgn().zza(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
