package com.ihoc.mgpa.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class B {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Integer> f5552a = new HashMap<>();
    private ArrayList<Integer> b = new ArrayList<>();
    private ArrayList<Integer> c = new ArrayList<>();
    private HashMap<Integer, Integer> d = new HashMap<>();

    public int a(int i) {
        Integer num = this.d.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("resetScene");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.b.add(Integer.valueOf(optJSONArray.getInt(i)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("sceneLevel1");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.f5552a.put(optJSONArray2.getString(i2), 1);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("sceneLevel2");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        this.f5552a.put(optJSONArray3.getString(i3), 2);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("sceneLevel3");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        this.f5552a.put(optJSONArray4.getString(i4), 3);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("sceneLevel4");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        this.f5552a.put(optJSONArray5.getString(i5), 4);
                    }
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("sceneLevel5");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        this.f5552a.put(optJSONArray6.getString(i6), 5);
                    }
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("plotScene");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        this.c.add(Integer.valueOf(optJSONArray7.getInt(i7)));
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("actionScene");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.d.put(Integer.valueOf(optJSONObject.getInt(next)), Integer.valueOf(Integer.parseInt(next)));
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int b(int i) {
        Integer num = this.f5552a.get(String.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public boolean c(int i) {
        return this.c.contains(Integer.valueOf(i));
    }

    public boolean d(int i) {
        return this.b.contains(Integer.valueOf(i));
    }

    public boolean e(int i) {
        return this.f5552a.containsValue(Integer.valueOf(i));
    }

    public boolean f(int i) {
        return this.d.containsKey(Integer.valueOf(i));
    }
}
