package com.subao.common.b;

import android.util.JsonReader;
import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f5932a;
    public final int b;
    public final String c;

    public n(String str, int i, String str2) {
        this.f5932a = str;
        this.b = i;
        this.c = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static n a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("parameters error");
        }
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        jsonReader.setLenient(true);
        try {
            jsonReader.beginObject();
            int i = -1;
            String str2 = null;
            String str3 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("shortId".equals(nextName)) {
                    str2 = jsonReader.nextString();
                } else if ("status".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("expiredTime".equals(nextName)) {
                    str3 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (str2 == null || str3 == null) {
                return null;
            }
            return new n(str2, i, str3);
        } catch (IOException unused) {
            return null;
        } catch (RuntimeException unused2) {
            return null;
        } finally {
            com.subao.common.e.a(jsonReader);
        }
    }
}
