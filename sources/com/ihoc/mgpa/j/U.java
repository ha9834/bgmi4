package com.ihoc.mgpa.j;

import com.ihoc.mgpa.f.RunnableC0236b;
import com.xiaomi.boostersdk.SystemCallback;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class U implements SystemCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ V f5636a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(V v) {
        this.f5636a = v;
    }

    @Override // com.xiaomi.boostersdk.SystemCallback
    public void systemCallback(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("xiaomi:systemcallback: key: ");
            sb.append(String.valueOf(str));
            sb.append(" , value: ");
            sb.append(String.valueOf(str2));
            com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            if (com.ihoc.mgpa.i.f.J()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(str, str2);
                com.ihoc.mgpa.f.H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VENDOR, jSONObject.toString()));
            }
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "xiaomi:systemcallback: exception.");
        }
    }
}
