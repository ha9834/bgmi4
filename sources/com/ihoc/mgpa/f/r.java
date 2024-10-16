package com.ihoc.mgpa.f;

import com.ihoc.mgpa.f.C;

/* loaded from: classes2.dex */
class r implements C.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f5542a;
    final /* synthetic */ C b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(C c, long j) {
        this.b = c;
        this.f5542a = j;
    }

    @Override // com.ihoc.mgpa.f.C.a
    public void a() {
        long currentTimeMillis = System.currentTimeMillis() - this.f5542a;
        com.ihoc.mgpa.n.m.c("All task in %s thread has done, total run time: %d", Thread.currentThread().getName(), Long.valueOf(currentTimeMillis));
        this.b.f5517a.put("run_time", String.valueOf(currentTimeMillis));
        this.b.f5517a.put("result", "0");
        com.ihoc.mgpa.i.m.e(this.b.f5517a);
    }
}
