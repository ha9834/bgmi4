package com.tencent.mid.b;

import com.tencent.mid.util.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f6261a = "ts";
    public static String b = "times";
    public static String c = "mfreq";
    public static String d = "mdays";
    private static com.tencent.mid.util.d i = Util.getLogger();
    private long e;
    private int f;
    private int g;
    private int h;

    public a() {
        this.e = 0L;
        this.f = 1;
        this.g = 1024;
        this.h = 3;
    }

    public a(String str) {
        this.e = 0L;
        this.f = 1;
        this.g = 1024;
        this.h = 3;
        if (Util.isStringValid(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(f6261a)) {
                    this.e = jSONObject.getLong(f6261a);
                }
                if (!jSONObject.isNull(c)) {
                    this.g = jSONObject.getInt(c);
                }
                if (!jSONObject.isNull(b)) {
                    this.f = jSONObject.getInt(b);
                }
                if (jSONObject.isNull(d)) {
                    return;
                }
                this.h = jSONObject.getInt(d);
            } catch (JSONException e) {
                i.d(e.toString());
            }
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f6261a, this.e);
            jSONObject.put(b, this.f);
            jSONObject.put(c, this.g);
            jSONObject.put(d, this.h);
        } catch (JSONException e) {
            i.d(e.toString());
        }
        return jSONObject.toString();
    }

    public int a() {
        return this.h;
    }

    public void a(int i2) {
        this.h = i2;
    }

    public long b() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public int c() {
        return this.f;
    }

    public void b(int i2) {
        this.f = i2;
    }

    public int d() {
        return this.g;
    }

    public void c(int i2) {
        this.g = i2;
    }
}
