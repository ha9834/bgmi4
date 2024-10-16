package com.shieldtunnel.svpn.common.f;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import android.util.Log;
import com.amazonaws.event.ProgressEvent;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.f.a;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

/* loaded from: classes2.dex */
public class p extends e {

    /* renamed from: a, reason: collision with root package name */
    private a.b f5825a;
    private q b;
    private q c;
    private Integer d;
    private Integer e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5826a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f5826a = iArr;
            try {
                iArr[JsonToken.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5826a[JsonToken.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5826a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5826a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.shieldtunnel.svpn.common.f.e
    protected String a() {
        return ConfigDBHelper.TABLE_NAME_CONFIG;
    }

    @Override // com.shieldtunnel.svpn.common.f.e
    protected void a(byte[] bArr) {
        try {
            a(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr)), ProgressEvent.PART_COMPLETED_EVENT_CODE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public a.b c() {
        return this.f5825a;
    }

    public Integer d() {
        return this.d;
    }

    public Integer e() {
        return this.e;
    }

    public q f() {
        return this.c;
    }

    public q g() {
        return this.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void a(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if ("nodes".equals(nextName)) {
                        this.f5825a = b.a(jsonReader);
                    } else if ("url_portal".equals(nextName)) {
                        this.b = q.a(com.shieldtunnel.svpn.common.k.c.a(jsonReader));
                    } else if ("url_drone".equals(nextName)) {
                        this.c = q.a(com.shieldtunnel.svpn.common.k.c.a(jsonReader));
                    } else if ("portal_fail_retry".equals(nextName)) {
                        this.d = Integer.valueOf(jsonReader.nextInt());
                    } else if ("portal_success_retry".equals(nextName)) {
                        this.e = Integer.valueOf(jsonReader.nextInt());
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } finally {
                com.shieldtunnel.svpn.common.c.a(jsonReader);
            }
        } catch (AssertionError | RuntimeException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static a.b a(JsonReader jsonReader) {
            ByteArrayOutputStream byteArrayOutputStream;
            JsonWriter jsonWriter;
            JsonWriter jsonWriter2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(4096);
                jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream, f.c));
            } catch (Throwable th) {
                th = th;
            }
            try {
                jsonWriter.beginArray();
                jsonReader.beginArray();
                int i = 0;
                while (jsonReader.hasNext()) {
                    a(jsonReader, jsonWriter);
                    i++;
                }
                jsonReader.endArray();
                jsonWriter.endArray();
                com.shieldtunnel.svpn.common.c.a(jsonWriter);
                if (i > 0) {
                    return new a.b(i, byteArrayOutputStream.toByteArray());
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                jsonWriter2 = jsonWriter;
                com.shieldtunnel.svpn.common.c.a(jsonWriter2);
                throw th;
            }
        }

        private static void a(JsonReader jsonReader, JsonWriter jsonWriter) {
            jsonReader.beginObject();
            jsonWriter.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                JsonToken peek = jsonReader.peek();
                switch (a.f5826a[peek.ordinal()]) {
                    case 1:
                        jsonWriter.name(nextName).value(jsonReader.nextString());
                        break;
                    case 2:
                        jsonWriter.name(nextName).nullValue();
                        jsonReader.nextNull();
                        break;
                    case 3:
                        jsonWriter.name(nextName).value(jsonReader.nextBoolean());
                        break;
                    case 4:
                        jsonWriter.name(nextName).value(jsonReader.nextLong());
                        break;
                    default:
                        jsonReader.skipValue();
                        Log.w(LogTag.DATA, String.format("JsonNodeListParser: Unknown field type '%s' : '%s'", nextName, peek));
                        break;
                }
            }
            jsonWriter.endObject();
            jsonReader.endObject();
        }
    }
}
