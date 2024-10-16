package com.shieldtunnel.svpn.common.k;

import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;

/* loaded from: classes2.dex */
public class c {
    public static JsonWriter a(JsonWriter jsonWriter, String str, com.shieldtunnel.svpn.common.a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(str)) {
                jsonWriter.name(str);
            }
            aVar.serialize(jsonWriter);
        }
        return jsonWriter;
    }

    public static JsonWriter a(JsonWriter jsonWriter, String str, String str2) {
        if (str2 != null) {
            jsonWriter.name(str).value(str2);
        }
        return jsonWriter;
    }

    public static String a(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        return jsonReader.nextString();
    }
}
