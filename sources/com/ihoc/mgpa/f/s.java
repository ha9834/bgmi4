package com.ihoc.mgpa.f;

import com.ihoc.mgpa.n.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s implements c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C f5543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(C c) {
        this.f5543a = c;
    }

    @Override // com.ihoc.mgpa.n.c.a
    public void a() {
        com.ihoc.mgpa.n.m.a("TGPA_Init", "Upload log file failed.");
    }

    @Override // com.ihoc.mgpa.n.c.a
    public void a(String str) {
        com.ihoc.mgpa.n.m.a("TGPA_Init", "Upload log file result: " + str);
    }
}
