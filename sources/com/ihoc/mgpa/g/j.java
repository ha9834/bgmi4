package com.ihoc.mgpa.g;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public int f5566a;
    public int[] b;
    public int[] c;

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            this.f5566a = jSONObject.getInt("cpu_num");
            JSONArray jSONArray = jSONObject.getJSONArray("little_core");
            if (jSONArray.length() > 0) {
                this.b = new int[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.b[i] = jSONArray.getInt(i);
                }
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("big_core");
            if (jSONArray2.length() <= 0) {
                return true;
            }
            this.c = new int[jSONArray2.length()];
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.c[i2] = jSONArray2.getInt(i2);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
