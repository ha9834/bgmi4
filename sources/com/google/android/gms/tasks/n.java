package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f5195a;
    private final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, Task task) {
        this.b = mVar;
        this.f5195a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnSuccessListener onSuccessListener;
        OnSuccessListener onSuccessListener2;
        obj = this.b.b;
        synchronized (obj) {
            onSuccessListener = this.b.c;
            if (onSuccessListener != null) {
                onSuccessListener2 = this.b.c;
                onSuccessListener2.onSuccess(this.f5195a.getResult());
            }
        }
    }
}
