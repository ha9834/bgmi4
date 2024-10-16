package com.ihoc.mgpa.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class A {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, ArrayList<Integer>> f5551a;

    public String a(String str) {
        if (this.f5551a == null) {
            return null;
        }
        int parseInt = Integer.parseInt(str);
        for (Map.Entry<String, ArrayList<Integer>> entry : this.f5551a.entrySet()) {
            if (entry.getValue().contains(Integer.valueOf(parseInt))) {
                return entry.getKey();
            }
        }
        return null;
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f5551a = new HashMap<>();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
                        }
                        this.f5551a.put(next, arrayList);
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
