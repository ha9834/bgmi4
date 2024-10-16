package com.ihoc.mgpa.j;

import android.os.SystemClock;

/* loaded from: classes2.dex */
class I implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f5628a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(L l) {
        this.f5628a = l;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemClock.sleep(1000L);
        if (z.c != this.f5628a.b()) {
            com.ihoc.mgpa.n.m.a("TGPA", "tgpabinder sdk is not available. ");
            this.f5628a.c();
        }
    }
}
