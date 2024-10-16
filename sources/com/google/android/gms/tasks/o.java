package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class o<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, q<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f5196a;
    private final SuccessContinuation<TResult, TContinuationResult> b;
    private final v<TContinuationResult> c;

    public o(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, v<TContinuationResult> vVar) {
        this.f5196a = executor;
        this.b = successContinuation;
        this.c = vVar;
    }

    @Override // com.google.android.gms.tasks.q
    public final void a(Task<TResult> task) {
        this.f5196a.execute(new p(this, task));
    }

    @Override // com.google.android.gms.tasks.q
    public final void a() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.a((v<TContinuationResult>) tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.c.a(exc);
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.c.a();
    }
}
