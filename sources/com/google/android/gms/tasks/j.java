package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f5191a;
    private final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, Task task) {
        this.b = iVar;
        this.f5191a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCompleteListener onCompleteListener;
        OnCompleteListener onCompleteListener2;
        obj = this.b.b;
        synchronized (obj) {
            onCompleteListener = this.b.c;
            if (onCompleteListener != null) {
                onCompleteListener2 = this.b.c;
                onCompleteListener2.onComplete(this.f5191a);
            }
        }
    }
}
