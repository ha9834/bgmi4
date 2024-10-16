package com.ihoc.mgpa.g;

import org.json.JSONArray;

/* loaded from: classes2.dex */
public class z {
    public boolean a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (optString != null) {
                if (optString.equals("samsung2")) {
                    com.ihoc.mgpa.i.f.ba = true;
                }
                if (optString.equals("samsung_shm")) {
                    com.ihoc.mgpa.i.f.ca = true;
                }
            }
        }
        return true;
    }
}
