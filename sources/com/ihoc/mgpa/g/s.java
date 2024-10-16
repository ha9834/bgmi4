package com.ihoc.mgpa.g;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public long f5579a;
    public ArrayList<String> b;
    public ArrayList<String> c;

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            this.f5579a = jSONObject.getLong("versionCode");
            JSONArray jSONArray = jSONObject.getJSONArray("dir");
            JSONArray jSONArray2 = jSONObject.getJSONArray("fileName");
            this.b = new ArrayList<>();
            this.c = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.b.add(jSONArray.getString(i));
            }
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.c.add(jSONArray2.getString(i2));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
