package com.tencent.msdk.stat;

/* loaded from: classes.dex */
class ag implements j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f6302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.f6302a = afVar;
    }

    @Override // com.tencent.msdk.stat.j
    public void a() {
        StatServiceImpl.c();
        if (aj.b().a() >= StatConfig.getMaxBatchReportCount()) {
            aj.b().a(StatConfig.getMaxBatchReportCount());
        }
    }

    @Override // com.tencent.msdk.stat.j
    public void b() {
        StatServiceImpl.d();
    }
}
