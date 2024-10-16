package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ g f5189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f5189a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCanceledListener onCanceledListener;
        OnCanceledListener onCanceledListener2;
        obj = this.f5189a.b;
        synchronized (obj) {
            onCanceledListener = this.f5189a.c;
            if (onCanceledListener != null) {
                onCanceledListener2 = this.f5189a.c;
                onCanceledListener2.onCanceled();
            }
        }
    }
}
