package com.ihoc.mgpa.j;

import com.ihoc.mgpa.MgpaCallback;
import com.samsung.android.game.gamelibnew.GameServiceHelper;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ihoc.mgpa.j.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0265q implements GameServiceHelper.ToTGPACallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f5647a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0265q(x xVar) {
        this.f5647a = xVar;
    }

    @Override // com.samsung.android.game.gamelibnew.GameServiceHelper.ToTGPACallback
    public void totgpa(String str) {
        MgpaCallback mgpaCallback;
        long j;
        x xVar;
        MgpaCallback mgpaCallback2;
        com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk: spa callback: " + String.valueOf(str));
        try {
            JSONObject jSONObject = new JSONObject(str);
            mgpaCallback = this.f5647a.i;
            if (mgpaCallback != null) {
                if (jSONObject.has("rpic_set") || jSONObject.has("9")) {
                    String d = com.ihoc.mgpa.f.G.d(jSONObject.getString("rpic_set"));
                    if (d != null) {
                        xVar = this.f5647a;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (!com.ihoc.mgpa.i.f.J()) {
                            return;
                        }
                        j = this.f5647a.f;
                        if (currentTimeMillis - j <= 300) {
                            return;
                        }
                        this.f5647a.f = currentTimeMillis;
                        this.f5647a.g = 2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("{");
                        sb.append("\"");
                        sb.append(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a());
                        sb.append("\":\"2\",");
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(sb2);
                        sb3.append("\"");
                        sb3.append(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a());
                        sb3.append("\":\"");
                        sb3.append(2);
                        sb3.append("\"}");
                        d = sb3.toString();
                        xVar = this.f5647a;
                    }
                    mgpaCallback2 = xVar.i;
                    mgpaCallback2.notifySystemInfo(d);
                }
            }
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk: spa callback exception. ");
        }
    }
}
