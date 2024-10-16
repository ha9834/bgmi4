package com.gamesafe.ano;

import com.gamesafe.ano.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f1098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1098a = hVar;
    }

    @Override // com.gamesafe.ano.g.a
    public void a(int i) {
        String str;
        String str2;
        g gVar;
        str = this.f1098a.c;
        str2 = this.f1098a.c;
        if (str2 == null) {
            this.f1098a.c = "0";
        }
        gVar = this.f1098a.b;
        if (gVar != null) {
            this.f1098a.b = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a.a("hnb_wjs_ydnhdnn:ntn:"));
        sb.append(a.a("|hnb_wjs_dy=") + str);
        sb.append(a.a("|woi_dy=") + i);
        b.a(sb.toString());
    }
}
