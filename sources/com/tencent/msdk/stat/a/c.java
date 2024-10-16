package com.tencent.msdk.stat.a;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f6290a;
    public JSONArray b;
    public JSONObject c;

    public c() {
        this.c = null;
    }

    public c(String str, String[] strArr, Properties properties) {
        JSONObject jSONObject;
        this.c = null;
        this.f6290a = str;
        if (properties != null) {
            jSONObject = new JSONObject(properties);
        } else {
            if (strArr != null) {
                this.b = new JSONArray();
                for (String str2 : strArr) {
                    this.b.put(str2);
                }
                return;
            }
            jSONObject = new JSONObject();
        }
        this.c = jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return toString().equals(((c) obj).toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f6290a);
        sb.append(",");
        JSONArray jSONArray = this.b;
        if (jSONArray != null) {
            sb.append(jSONArray.toString());
        }
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            sb.append(jSONObject.toString());
        }
        return sb.toString();
    }
}
