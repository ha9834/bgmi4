package com.ihoc.mgpa.b;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class g implements h {
    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        if (com.ihoc.mgpa.g.o.b().c.t == null || !com.ihoc.mgpa.g.o.b().c.t.a(i)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(String.valueOf(i), str);
            com.ihoc.mgpa.c.c.a().a(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            try {
                a(Integer.parseInt(entry.getKey()), entry.getValue());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
