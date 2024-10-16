package com.tencent.mid.local;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    String f6265a = null;
    String b = null;
    String c = "0";
    long d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(String str) {
        c cVar = new c();
        if (i.b(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    cVar.f6265a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    cVar.b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    cVar.c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    cVar.d = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
                Log.w("MID", "", e);
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return i.c(this.c);
    }

    JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            i.a(jSONObject, "ui", this.f6265a);
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
