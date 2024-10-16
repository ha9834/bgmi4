package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class c<TResult, TContinuationResult> implements q<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f5184a;
    private final Continuation<TResult, TContinuationResult> b;
    private final v<TContinuationResult> c;

    public c(Executor executor, Continuation<TResult, TContinuationResult> continuation, v<TContinuationResult> vVar) {
        this.f5184a = executor;
        this.b = continuation;
        this.c = vVar;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task<TResult> task) {
        this.f5184a.execute(new d(this, task));
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        throw new UnsupportedOperationException();
    }
}
