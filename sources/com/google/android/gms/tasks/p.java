package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

/* loaded from: classes2.dex */
final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f5197a;
    private final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, Task task) {
        this.b = oVar;
        this.f5197a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuccessContinuation successContinuation;
        try {
            successContinuation = this.b.b;
            Task then = successContinuation.then(this.f5197a.getResult());
            if (then == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            then.addOnSuccessListener(TaskExecutors.f5178a, this.b);
            then.addOnFailureListener(TaskExecutors.f5178a, this.b);
            then.addOnCanceledListener(TaskExecutors.f5178a, this.b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.b.onFailure((Exception) e.getCause());
            } else {
                this.b.onFailure(e);
            }
        } catch (CancellationException unused) {
            this.b.onCanceled();
        } catch (Exception e2) {
            this.b.onFailure(e2);
        }
    }
}
