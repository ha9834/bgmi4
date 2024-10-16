package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f5193a;
    private final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, Task task) {
        this.b = kVar;
        this.f5193a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.b.b;
        synchronized (obj) {
            onFailureListener = this.b.c;
            if (onFailureListener != null) {
                onFailureListener2 = this.b.c;
                onFailureListener2.onFailure(this.f5193a.getException());
            }
        }
    }
}
