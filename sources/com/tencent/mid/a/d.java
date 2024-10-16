package com.tencent.mid.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f6250a;
    private JSONObject b;

    public d(int i, String str) {
        this.f6250a = -1;
        this.b = null;
        this.f6250a = i;
        try {
            this.b = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int a() {
        return this.f6250a;
    }

    public JSONObject b() {
        return this.b;
    }
}
