package com.vk.api.sdk.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.MalformedJsonException;
import java.io.StringReader;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6882a = new b();

    private b() {
    }

    public final boolean a(String str, String str2) {
        h.b(str, "jsonString");
        h.b(str2, "name");
        try {
            return b(str, str2);
        } catch (MalformedJsonException e) {
            throw new MalformedJsonException(((Object) e.getMessage()) + ". Json: '" + str + '\'');
        }
    }

    private final boolean b(String str, String str2) {
        JsonToken peek;
        if (str.length() == 0) {
            return false;
        }
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        if (!jsonReader.hasNext() || jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
            return false;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext() && (peek = jsonReader.peek()) != JsonToken.END_DOCUMENT) {
            if (peek != JsonToken.NAME) {
                jsonReader.skipValue();
            } else if (h.a((Object) str2, (Object) jsonReader.nextName())) {
                return true;
            }
        }
        return false;
    }
}
