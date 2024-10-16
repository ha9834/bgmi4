package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f5187a;
    private final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Task task) {
        this.b = eVar;
        this.f5187a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v vVar;
        v vVar2;
        v vVar3;
        Continuation continuation;
        try {
            continuation = this.b.b;
            Task task = (Task) continuation.then(this.f5187a);
            if (task == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.addOnSuccessListener(TaskExecutors.f5178a, this.b);
            task.addOnFailureListener(TaskExecutors.f5178a, this.b);
            task.addOnCanceledListener(TaskExecutors.f5178a, this.b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                vVar3 = this.b.c;
                vVar3.a((Exception) e.getCause());
            } else {
                vVar2 = this.b.c;
                vVar2.a((Exception) e);
            }
        } catch (Exception e2) {
            vVar = this.b.c;
            vVar.a(e2);
        }
    }
}
