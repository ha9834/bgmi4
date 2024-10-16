package com.ihoc.mgpa.g;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class C {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5553a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            this.f5553a = jSONObject.getBoolean("available");
            this.b = jSONObject.getInt("appid");
            this.c = jSONObject.getInt("scene_start");
            this.d = jSONObject.getInt("scene_stop");
            this.e = jSONObject.getInt("scene_report");
            this.f = jSONObject.optInt("user_start");
            this.g = jSONObject.optInt("user_stop");
            this.h = jSONObject.getInt("last_time");
            this.i = jSONObject.getInt("limit_count");
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
