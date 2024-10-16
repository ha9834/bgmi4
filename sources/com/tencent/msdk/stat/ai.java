package com.tencent.msdk.stat;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f6304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar) {
        this.f6304a = afVar;
    }

    @Override // com.tencent.msdk.stat.j
    public void a() {
        Context context;
        StatServiceImpl.c();
        if (aj.b().f6305a > 0) {
            context = this.f6304a.d;
            StatServiceImpl.commitEvents(context, -1);
        }
    }

    @Override // com.tencent.msdk.stat.j
    public void b() {
        com.tencent.msdk.stat.a.d dVar;
        boolean z;
        aj b = aj.b();
        dVar = this.f6304a.f6301a;
        z = this.f6304a.c;
        b.a(dVar, (j) null, z, true);
        StatServiceImpl.d();
    }
}
