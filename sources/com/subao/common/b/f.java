package com.subao.common.b;

import android.util.JsonReader;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.imsdk.android.IR;
import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes2.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    public final a f5923a;

    private f(a aVar) {
        this.f5923a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static f a(JsonReader jsonReader) {
        if (jsonReader == null) {
            throw new NullPointerException();
        }
        a aVar = null;
        try {
            jsonReader.setLenient(true);
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (FirebaseAnalytics.Param.CONTENT.equals(jsonReader.nextName().trim())) {
                    aVar = a.a(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return new f(aVar);
        } catch (RuntimeException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final String f5924a;

        private a(String str) {
            this.f5924a = str;
        }

        static a a(String str) {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                return a(jsonReader);
            } finally {
                com.subao.common.e.a(jsonReader);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static a a(JsonReader jsonReader) {
            try {
                jsonReader.setLenient(false);
                jsonReader.beginObject();
                String str = null;
                while (jsonReader.hasNext()) {
                    if (IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME.equals(jsonReader.nextName().trim())) {
                        str = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                return new a(str);
            } catch (RuntimeException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
