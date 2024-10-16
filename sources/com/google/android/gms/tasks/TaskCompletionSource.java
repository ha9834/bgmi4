package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
public class TaskCompletionSource<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final v<TResult> f5177a = new v<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new t(this));
    }

    public void setResult(TResult tresult) {
        this.f5177a.a((v<TResult>) tresult);
    }

    public boolean trySetResult(TResult tresult) {
        return this.f5177a.b((v<TResult>) tresult);
    }

    public void setException(Exception exc) {
        this.f5177a.a(exc);
    }

    public boolean trySetException(Exception exc) {
        return this.f5177a.b(exc);
    }

    public Task<TResult> getTask() {
        return this.f5177a;
    }
}
