package com.ihoc.mgpa.j;

import android.os.SystemClock;

/* renamed from: com.ihoc.mgpa.j.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC0262n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f5644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0262n(x xVar) {
        this.f5644a = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemClock.sleep(1000L);
        if (z.c != this.f5644a.b()) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk is not available. ");
            this.f5644a.c();
        }
    }
}
