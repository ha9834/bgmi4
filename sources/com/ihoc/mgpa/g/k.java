package com.ihoc.mgpa.g;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private List<Integer> f5567a;

    public boolean a(int i) {
        List<Integer> list = this.f5567a;
        return list != null && list.contains(Integer.valueOf(i));
    }

    public boolean a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return false;
        }
        this.f5567a = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f5567a.add(Integer.valueOf(jSONArray.optInt(i)));
        }
        return true;
    }
}
