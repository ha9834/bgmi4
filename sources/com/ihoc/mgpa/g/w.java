package com.ihoc.mgpa.g;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, ArrayList<String>> f5584a;

    public boolean a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    this.f5584a = new HashMap<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.has("predownDir") && jSONObject.has("fileName")) {
                            String optString = jSONObject.optString("predownDir");
                            String optString2 = jSONObject.optString("fileName");
                            if (optString != null && optString2 != null) {
                                if (this.f5584a.containsKey(optString)) {
                                    this.f5584a.get(optString).add(optString2);
                                } else {
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    arrayList.add(optString2);
                                    this.f5584a.put(optString, arrayList);
                                }
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
