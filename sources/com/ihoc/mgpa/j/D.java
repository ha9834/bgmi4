package com.ihoc.mgpa.j;

import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class D implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ G f5624a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(G g) {
        this.f5624a = g;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemClock.sleep(1000L);
        if (z.c != this.f5624a.b()) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder2 sdk is not available. ");
            this.f5624a.c();
        }
    }
}
