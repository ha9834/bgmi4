package com.huawei.game.gamekit.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5467a = "UpstreamTranslatorFactory";
    private static final String b = "temperature";
    private static final String c = "cpu_level";
    private static final String d = "MessageType";

    @Override // com.huawei.game.gamekit.a.g
    public final e a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = jSONObject.has(b) || jSONObject.has(c);
            boolean z2 = !jSONObject.has(d);
            StringBuilder sb = new StringBuilder("isSystemInfo:");
            sb.append(z);
            sb.append(",isOldProtocl:");
            sb.append(z2);
            com.huawei.game.gamekit.b.c.a(f5467a, sb.toString());
            return (z && z2) ? f.a() : c.a();
        } catch (JSONException unused) {
            com.huawei.game.gamekit.b.c.d(f5467a, "getManager JSONObject operation exception");
            return c.a();
        }
    }
}
