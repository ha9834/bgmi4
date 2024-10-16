package com.subao.common.n;

import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.ServerProtocol;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class g {
    public static String a(com.subao.common.c cVar) {
        StringWriter stringWriter = new StringWriter(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        cVar.serialize(jsonWriter);
        com.subao.common.e.a(jsonWriter);
        return stringWriter.toString();
    }

    public static byte[] b(com.subao.common.c cVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream, "UTF-8"));
        cVar.serialize(jsonWriter);
        com.subao.common.e.a(jsonWriter);
        return byteArrayOutputStream.toByteArray();
    }

    public static JsonWriter a(JsonWriter jsonWriter, String str, com.subao.common.c cVar) {
        if (cVar != null) {
            if (!TextUtils.isEmpty(str)) {
                jsonWriter.name(str);
            }
            cVar.serialize(jsonWriter);
        }
        return jsonWriter;
    }

    public static JsonWriter a(JsonWriter jsonWriter, String str, String str2) {
        if (str2 != null) {
            jsonWriter.name(str).value(str2);
        }
        return jsonWriter;
    }

    public static JsonWriter a(JsonWriter jsonWriter, String str, Number number) {
        if (number != null) {
            jsonWriter.name(str).value(number);
        }
        return jsonWriter;
    }

    public static JsonWriter a(JsonWriter jsonWriter, String str, Integer num) {
        if (num != null) {
            jsonWriter.name(str).value(num.intValue() & 4294967295L);
        }
        return jsonWriter;
    }

    /* renamed from: com.subao.common.n.g$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6136a = new int[JsonToken.values().length];

        static {
            try {
                f6136a[JsonToken.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6136a[JsonToken.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6136a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6136a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static boolean a(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        switch (AnonymousClass1.f6136a[peek.ordinal()]) {
            case 1:
                return jsonReader.nextBoolean();
            case 2:
                jsonReader.skipValue();
                return false;
            case 3:
                return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(jsonReader.nextString());
            case 4:
                return 0 != jsonReader.nextLong();
            default:
                throw new IOException("Expected a boolean but was " + peek);
        }
    }

    public static String b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        return jsonReader.nextString();
    }

    public static StringBuilder a(StringBuilder sb, String str) {
        if (str == null) {
            sb.append(Constants.NULL_VERSION_ID);
            return sb;
        }
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\"':
                case '\\':
                    sb.append('\\');
                    sb.append(charAt);
                    break;
                case 8232:
                case 8233:
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    break;
                default:
                    if (charAt <= 31) {
                        sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                        break;
                    } else {
                        sb.append(charAt);
                        break;
                    }
            }
        }
        sb.append('\"');
        return sb;
    }
}
