package com.ihoc.mgpa.g;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private int f5577a = 1000;
    private int b = 60000;
    private List<String> c = null;
    private String d = null;
    private List<Integer> e = null;
    private String f = com.ihoc.mgpa.a.g.PLAYING.a();
    private String g = com.ihoc.mgpa.a.g.MAIN_UI.a();

    public int a(int i) {
        if (i < 0) {
            return 3;
        }
        int i2 = 0;
        while (i2 < this.e.size() && i >= this.e.get(i2).intValue()) {
            i2++;
        }
        return i2 + 1;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.e.size(); i++) {
            sb.append(this.e.get(i));
            sb.append(',');
        }
        return this.e.isEmpty() ? "" : sb.toString().substring(0, sb.toString().length() - 1);
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        this.f5577a = jSONObject.optInt("period", this.f5577a);
        JSONArray optJSONArray = jSONObject.optJSONArray("probeIP");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.c = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.c.add(optJSONArray.optString(i));
            }
        }
        this.d = jSONObject.optString("tconnd");
        JSONArray optJSONArray2 = jSONObject.optJSONArray(FirebaseAnalytics.Param.LEVEL);
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.e = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                this.e.add(Integer.valueOf(optJSONArray2.optInt(i2)));
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("scene");
        if (optJSONArray3 != null && optJSONArray3.length() == 2) {
            this.f = String.valueOf(optJSONArray3.optInt(0, -1));
            this.g = String.valueOf(optJSONArray3.optInt(1, -1));
        }
        return true;
    }

    public int b() {
        return this.f5577a;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.c.size(); i++) {
            if (i != 0) {
                sb.append(";");
            }
            sb.append(this.c.get(i));
        }
        return sb.toString();
    }

    public int d() {
        return this.b / this.f5577a;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.d;
    }
}
