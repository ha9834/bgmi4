package com.tencent.msdk.stat.common;

import com.tencent.mid.api.MidEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f6318a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private long g;

    public a() {
        this.f6318a = null;
        this.b = null;
        this.c = null;
        this.d = "0";
        this.f = 0;
        this.g = 0L;
    }

    public a(String str, String str2, int i) {
        this.f6318a = null;
        this.b = null;
        this.c = null;
        this.d = "0";
        this.f = 0;
        this.g = 0L;
        this.f6318a = str;
        this.b = str2;
        this.e = i;
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            p.a(jSONObject, "ui", this.f6318a);
            p.a(jSONObject, "mc", this.b);
            p.a(jSONObject, "mid", this.d);
            p.a(jSONObject, "aid", this.c);
            jSONObject.put("ts", this.g);
            jSONObject.put(MidEntity.TAG_VER, this.f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void a(int i) {
        this.e = i;
    }

    public String b() {
        return this.f6318a;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public String toString() {
        return a().toString();
    }
}
