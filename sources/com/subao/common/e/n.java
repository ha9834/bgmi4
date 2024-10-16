package com.subao.common.e;

import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class n implements com.subao.common.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f5995a;
    private final String b;
    private final Map<String, String> c;

    public n(String str, String str2, Map<String, String> map) {
        this.f5995a = str;
        this.b = str2;
        this.c = map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static n a(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        Map<String, String> map = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("couponId".equals(nextName)) {
                str = com.subao.common.n.g.b(jsonReader);
            } else if ("couponName".equals(nextName)) {
                str2 = com.subao.common.n.g.b(jsonReader);
            } else if ("appClientParas".equals(nextName)) {
                map = b(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IOException("Invalid Coupon JSON");
        }
        return new n(str, str2, map);
    }

    private static Map<String, String> b(JsonReader jsonReader) {
        if (JsonToken.NULL == jsonReader.peek()) {
            jsonReader.skipValue();
            return null;
        }
        HashMap hashMap = new HashMap(2);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            hashMap.put(jsonReader.nextName(), jsonReader.nextString());
        }
        jsonReader.endObject();
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public String a() {
        return this.f5995a;
    }

    public String b() {
        return this.b;
    }

    public String a(String str) {
        Map<String, String> map = this.c;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return com.subao.common.e.a(this.f5995a, nVar.f5995a) && com.subao.common.e.a(this.b, nVar.b) && com.subao.common.e.a(this.c, nVar.c);
    }

    @Override // com.subao.common.c
    public void serialize(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("couponId").value(a());
        jsonWriter.name("couponName").value(b());
        Map<String, String> map = this.c;
        if (map != null && !map.isEmpty()) {
            jsonWriter.name("appClientParas");
            jsonWriter.beginObject();
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                jsonWriter.name(entry.getKey());
                jsonWriter.value(entry.getValue());
            }
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }
}
