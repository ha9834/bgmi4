package com.tencent.msdk.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f6311a;
    final /* synthetic */ boolean b;
    final /* synthetic */ aj c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(aj ajVar, List list, boolean z) {
        this.c = ajVar;
        this.f6311a = list;
        this.b = z;
    }

    @Override // com.tencent.msdk.stat.j
    public void a() {
        StatServiceImpl.c();
        this.c.a(this.f6311a, this.b, true);
    }

    @Override // com.tencent.msdk.stat.j
    public void b() {
        StatServiceImpl.d();
        this.c.a(this.f6311a, 1, this.b, true);
    }
}
