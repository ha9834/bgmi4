package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
final class g<TResult> implements q<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f5188a;
    private final Object b = new Object();

    @GuardedBy("mLock")
    private OnCanceledListener c;

    public g(Executor executor, OnCanceledListener onCanceledListener) {
        this.f5188a = executor;
        this.c = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task task) {
        if (task.isCanceled()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.f5188a.execute(new h(this));
            }
        }
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        synchronized (this.b) {
            this.c = null;
        }
    }
}
