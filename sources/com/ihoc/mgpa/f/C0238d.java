package com.ihoc.mgpa.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ihoc.mgpa.f.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0238d implements com.ihoc.mgpa.g.m {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0240f f5527a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0238d(C0240f c0240f) {
        this.f5527a = c0240f;
    }

    @Override // com.ihoc.mgpa.g.m
    public boolean a(com.ihoc.mgpa.i.g gVar, String str) {
        com.ihoc.mgpa.i.g a2;
        com.ihoc.mgpa.n.m.a("TGPA", "download spa config content: " + String.valueOf(str));
        a2 = this.f5527a.a(str);
        if (a2 == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA", "reparse spa config success.");
            return true;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "reparse spa config failed.");
        return false;
    }
}
