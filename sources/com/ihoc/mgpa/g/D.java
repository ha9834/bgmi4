package com.ihoc.mgpa.g;

import java.util.ArrayList;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class D {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f5554a = null;

    public ArrayList<String> a() {
        return this.f5554a;
    }

    public boolean a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return false;
        }
        this.f5554a = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f5554a.add(jSONArray.optString(i));
        }
        return true;
    }
}
