package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
final class m<TResult> implements q<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f5194a;
    private final Object b = new Object();

    @GuardedBy("mLock")
    private OnSuccessListener<? super TResult> c;

    public m(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f5194a = executor;
        this.c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.f5194a.execute(new n(this, task));
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
