package com.ihoc.mgpa.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, ArrayList<String>> f5576a;

    public boolean a(String str, String str2) {
        ArrayList<String> arrayList;
        HashMap<String, ArrayList<String>> hashMap = this.f5576a;
        if (hashMap == null || !hashMap.containsKey(str) || (arrayList = this.f5576a.get(str)) == null || arrayList.size() <= 0) {
            return false;
        }
        if (arrayList.get(0).equals("all")) {
            return true;
        }
        return arrayList.get(0).equals("filter") ? !arrayList.contains(str2) : arrayList.contains(str2);
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f5576a = new HashMap<>();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.getString(i));
                        }
                        this.f5576a.put(next, arrayList);
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
