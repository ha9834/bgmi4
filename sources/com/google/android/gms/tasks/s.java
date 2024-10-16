package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f5198a = new Object();

    @GuardedBy("mLock")
    private Queue<q<TResult>> b;

    @GuardedBy("mLock")
    private boolean c;

    public final void a(q<TResult> qVar) {
        synchronized (this.f5198a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(qVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(Task<TResult> task) {
        q<TResult> poll;
        synchronized (this.f5198a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.f5198a) {
                        poll = this.b.poll();
                        if (poll == null) {
                            this.c = false;
                            return;
                        }
                    }
                    poll.a(task);
                }
            }
        }
    }
}
