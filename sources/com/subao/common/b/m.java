package com.subao.common.b;

import android.util.JsonReader;
import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f5931a;
    public final int b;

    public m(String str, int i) {
        this.f5931a = str;
        this.b = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static m a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("parameters error");
        }
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        jsonReader.setLenient(true);
        try {
            jsonReader.beginObject();
            int i = 0;
            String str2 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("access_token".equals(nextName)) {
                    str2 = jsonReader.nextString();
                } else if ("expires_in".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                return new m(str2, i);
            }
            return null;
        } catch (IOException unused) {
            return null;
        } catch (RuntimeException unused2) {
            return null;
        } finally {
            com.subao.common.e.a(jsonReader);
        }
    }
}
