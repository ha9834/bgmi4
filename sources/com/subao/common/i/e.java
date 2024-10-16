package com.subao.common.i;

import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr)));
        try {
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if ("id".equals(jsonReader.nextName())) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            if ("id".equals(jsonReader.nextName())) {
                                return jsonReader.nextString();
                            }
                            jsonReader.skipValue();
                        }
                        jsonReader.endObject();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } finally {
                com.subao.common.e.a(jsonReader);
            }
        } catch (IOException | RuntimeException unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(JsonWriter jsonWriter, String str, c cVar) {
        if (cVar != null) {
            jsonWriter.name(str);
            jsonWriter.value(cVar.a());
        }
    }
}
