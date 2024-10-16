package com.ihoc.mgpa.j;

import com.huawei.game.gamekit.GameManager;
import com.ihoc.mgpa.f.RunnableC0236b;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ihoc.mgpa.j.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0251c implements GameManager.GameCallBack {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0252d f5638a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0251c(C0252d c0252d) {
        this.f5638a = c0252d;
    }

    @Override // com.huawei.game.gamekit.GameManager.GameCallBack
    public void onPhoneInfoUpdated(String str) {
        int a2;
        int i;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("huawei:callback: ");
            sb.append(str);
            com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("IsSupport")) {
                com.ihoc.mgpa.n.m.a("TGPA", "huawei:callback: check strategy.");
                com.ihoc.mgpa.f.G.a(jSONObject);
                return;
            }
            if (jSONObject.has("TempCurLevel")) {
                int i2 = jSONObject.getInt("TempCurLevel");
                a2 = this.f5638a.a(i2);
                i = this.f5638a.f;
                if (i == a2) {
                    com.ihoc.mgpa.n.m.a("TGPA", "huawei:callback: same to last level.");
                    return;
                }
                com.ihoc.mgpa.i.f.z(String.valueOf(i2));
                if (com.ihoc.mgpa.i.f.J()) {
                    this.f5638a.f = a2;
                    if (a2 > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("{");
                        sb2.append("\"");
                        sb2.append(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a());
                        sb2.append("\":\"2\",");
                        String sb3 = sb2.toString();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(sb3);
                        sb4.append("\"");
                        sb4.append(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a());
                        sb4.append("\":\"");
                        sb4.append(a2);
                        sb4.append("\"}");
                        com.ihoc.mgpa.f.H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VENDOR, sb4.toString()));
                    }
                }
                if (com.ihoc.mgpa.i.f.Y()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.ihoc.mgpa.a.f.VENDOR_LEVEL.a(), String.valueOf(i2));
                    hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a(), "2");
                    hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a(), String.valueOf(a2));
                    com.ihoc.mgpa.i.m.o(hashMap);
                }
            }
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "huawei:callback: exception.");
        }
    }
}
