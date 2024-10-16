package com.tencent.msdk.a.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f6280a = null;
    public String b = null;
    public String c = "0";
    public long d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(String str) {
        d dVar = new d();
        if (i.b(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    dVar.f6280a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    dVar.b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    dVar.c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    dVar.d = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
                Log.w("MID", "", e);
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return i.c(this.c);
    }

    JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            i.a(jSONObject, "ui", this.f6280a);
            i.a(jSONObject, "mc", this.b);
            i.a(jSONObject, "mid", this.c);
            jSONObject.put("ts", this.d);
        } catch (JSONException e) {
            i.a(e);
        }
        return jSONObject;
    }

    public String toString() {
        return b().toString();
    }
}
