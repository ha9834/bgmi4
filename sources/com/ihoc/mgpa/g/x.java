package com.ihoc.mgpa.g;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public int f5585a;

    public boolean a(JSONObject jSONObject) {
        int i;
        if (jSONObject == null) {
            i = 0;
        } else {
            try {
                i = jSONObject.getInt("template");
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        this.f5585a = i;
        return true;
    }
}
