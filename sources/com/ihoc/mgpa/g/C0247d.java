package com.ihoc.mgpa.g;

import org.json.JSONObject;

/* renamed from: com.ihoc.mgpa.g.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0247d {

    /* renamed from: a, reason: collision with root package name */
    public int f5559a;
    public int b;
    public int c;
    public int d;
    public int e;

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            if (jSONObject.has("baseFrequency")) {
                this.f5559a = jSONObject.getInt("baseFrequency");
            }
            if (jSONObject.has("interval")) {
                this.b = jSONObject.getInt("interval");
            }
            if (jSONObject.has("strategy")) {
                this.c = jSONObject.getInt("strategy");
            }
            if (jSONObject.has("lockLimit")) {
                this.d = jSONObject.getInt("lockLimit");
            }
            if (!jSONObject.has("unlockLimit")) {
                return true;
            }
            this.e = jSONObject.getInt("unlockLimit");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
