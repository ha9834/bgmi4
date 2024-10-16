package com.ihoc.mgpa.g;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ihoc.mgpa.g.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0246c {

    /* renamed from: a, reason: collision with root package name */
    public String f5558a;
    public boolean b;
    public boolean c;
    public String d;
    public int e;
    public int f;

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            this.f5558a = jSONObject.getString("who_ctrl");
            this.c = jSONObject.getBoolean("notify_progress");
            this.b = jSONObject.getBoolean("need_wifi");
            this.d = jSONObject.getString("notify_title");
            this.e = jSONObject.getInt("battery_min");
            this.f = jSONObject.getInt("file_overdue_time");
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
