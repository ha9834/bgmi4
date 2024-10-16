package com.ihoc.mgpa.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements com.ihoc.mgpa.k.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ihoc.mgpa.g.q f5501a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, com.ihoc.mgpa.g.q qVar) {
        this.b = iVar;
        this.f5501a = qVar;
    }

    @Override // com.ihoc.mgpa.k.a
    public int a(String str) {
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i2 = -1;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                int optInt = jSONArray.optInt(i3);
                if (optInt > 0 && (i2 == -1 || optInt < i2)) {
                    i2 = optInt;
                }
            }
            int a2 = this.f5501a.a(i2);
            StringBuilder sb = new StringBuilder();
            sb.append("level = ");
            sb.append(a2);
            com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            i = this.b.c;
            if (a2 != i) {
                this.b.a(a2);
            }
            this.b.c = a2;
            arrayList = this.b.d;
            arrayList.add(Integer.valueOf(i2));
            arrayList2 = this.b.d;
            if (arrayList2.size() >= this.f5501a.d()) {
                this.b.e();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
