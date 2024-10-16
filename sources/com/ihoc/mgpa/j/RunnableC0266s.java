package com.ihoc.mgpa.j;

import android.os.SystemClock;

/* renamed from: com.ihoc.mgpa.j.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC0266s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f5649a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0266s(w wVar) {
        this.f5649a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemClock.sleep(1000L);
        if (z.c != this.f5649a.b()) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung2 sdk is not available. ");
            this.f5649a.c();
        }
    }
}
