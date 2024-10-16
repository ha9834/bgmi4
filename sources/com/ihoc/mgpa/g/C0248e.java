package com.ihoc.mgpa.g;

import com.ihoc.mgpa.g.g;
import com.ihoc.mgpa.n.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ihoc.mgpa.g.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0248e implements c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f5560a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0248e(g gVar, m mVar) {
        this.b = gVar;
        this.f5560a = mVar;
    }

    @Override // com.ihoc.mgpa.n.c.a
    public void a() {
        g.a aVar;
        aVar = this.b.b;
        com.ihoc.mgpa.n.m.b("%s async download config failed.", aVar.a());
    }

    @Override // com.ihoc.mgpa.n.c.a
    public void a(String str) {
        this.b.a(str, this.f5560a);
    }
}
