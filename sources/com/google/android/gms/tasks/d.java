package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f5185a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Task task) {
        this.b = cVar;
        this.f5185a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v vVar;
        v vVar2;
        v vVar3;
        Continuation continuation;
        v vVar4;
        v vVar5;
        if (this.f5185a.isCanceled()) {
            vVar5 = this.b.c;
            vVar5.a();
            return;
        }
        try {
            continuation = this.b.b;
            Object then = continuation.then(this.f5185a);
            vVar4 = this.b.c;
            vVar4.a((v) then);
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
