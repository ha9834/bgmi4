package com.ihoc.mgpa.g;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class E {

    /* renamed from: a, reason: collision with root package name */
    public String f5555a;
    public String b;

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        this.f5555a = jSONObject.optString("rom");
        this.b = jSONObject.optString("software");
        return true;
    }
}
