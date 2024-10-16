package com.tencent.msdk.stat;

import com.helpshift.analytics.AnalyticsEventKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f6328a;
    private int b = 0;
    private String c = "";
    private String d = "";

    public f(String str) {
        this.f6328a = "";
        this.f6328a = str;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        if (com.tencent.msdk.stat.common.j.c(this.f6328a)) {
            try {
                com.tencent.msdk.stat.common.p.a(jSONObject, AnalyticsEventKey.ACTION_SHA, this.f6328a);
                jSONObject.put("t", this.b);
                com.tencent.msdk.stat.common.p.a(jSONObject, "e", this.c);
                com.tencent.msdk.stat.common.p.a(jSONObject, "e1", this.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String b() {
        return this.f6328a;
    }

    public String toString() {
        return "StatAccount [account=" + this.f6328a + ", accountType=" + this.b + ", ext=" + this.c + ", ext1=" + this.d + "]";
    }
}
