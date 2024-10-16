package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
final class k<TResult> implements q<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f5192a;
    private final Object b = new Object();

    @GuardedBy("mLock")
    private OnFailureListener c;

    public k(Executor executor, OnFailureListener onFailureListener) {
        this.f5192a = executor;
        this.c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task<TResult> task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.f5192a.execute(new l(this, task));
        }
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        synchronized (this.b) {
            this.c = null;
        }
    }
}
