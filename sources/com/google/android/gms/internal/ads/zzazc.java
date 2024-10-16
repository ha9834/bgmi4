package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzazc {

    /* renamed from: a, reason: collision with root package name */
    private static final zzaze<Map<String, ?>> f2835a = new gk();

    public static List<String> zza(JSONArray jSONArray, List<String> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static List<String> zza(JsonReader jsonReader) throws IllegalStateException, IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(jsonReader.nextString());
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static Map<String, String> zzb(JsonReader jsonReader) throws IllegalStateException, IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            hashMap.put(jsonReader.nextName(), jsonReader.nextString());
        }
        jsonReader.endObject();
        return hashMap;
    }

    public static JSONObject zzc(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException {
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(peek)) {
                jSONObject.put(nextName, zzd(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(peek)) {
                jSONObject.put(nextName, zzc(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(peek)) {
                jSONObject.put(nextName, jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(peek)) {
                jSONObject.put(nextName, jsonReader.nextDouble());
            } else if (JsonToken.STRING.equals(peek)) {
                jSONObject.put(nextName, jsonReader.nextString());
            } else {
                String valueOf = String.valueOf(peek);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                sb.append("unexpected json token: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            }
        }
        jsonReader.endObject();
        return jSONObject;
    }

    public static JSONArray zzd(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException {
        JSONArray jSONArray = new JSONArray();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            JsonToken peek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(peek)) {
                jSONArray.put(zzd(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(peek)) {
                jSONArray.put(zzc(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(peek)) {
                jSONArray.put(jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(peek)) {
                jSONArray.put(jsonReader.nextDouble());
            } else if (JsonToken.STRING.equals(peek)) {
                jSONArray.put(jsonReader.nextString());
            } else {
                String valueOf = String.valueOf(peek);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                sb.append("unexpected json token: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            }
        }
        jsonReader.endArray();
        return jSONArray;
    }

    public static String zza(zzazf zzazfVar) {
        return a(zzazfVar);
    }

    private static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            a(jsonWriter, obj);
            jsonWriter.close();
            return stringWriter.toString();
        } catch (IOException e) {
            zzawz.zzc("Error when writing JSON.", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
        try {
            jsonWriter.beginObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    jsonWriter.name(next).value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.name(next).value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.name(next).value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    zza(jsonWriter.name(next), (JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    a(jsonWriter.name(next), (JSONArray) obj);
                } else {
                    String valueOf = String.valueOf(obj);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                    sb.append("unable to write field: ");
                    sb.append(valueOf);
                    throw new JSONException(sb.toString());
                }
            }
            jsonWriter.endObject();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void a(JsonWriter jsonWriter, JSONArray jSONArray) throws IOException {
        try {
            jsonWriter.beginArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    jsonWriter.value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    zza(jsonWriter, (JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    a(jsonWriter, (JSONArray) obj);
                } else {
                    String valueOf = String.valueOf(obj);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                    sb.append("unable to write field: ");
                    sb.append(valueOf);
                    throw new JSONException(sb.toString());
                }
            }
            jsonWriter.endArray();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    private static void a(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof String) {
            jsonWriter.value((String) obj);
            return;
        }
        if (obj instanceof zzazf) {
            ((zzazf) obj).zza(jsonWriter);
            return;
        }
        if (obj instanceof Map) {
            jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    a(jsonWriter.name((String) key), entry.getValue());
                }
            }
            jsonWriter.endObject();
            return;
        }
        if (obj instanceof List) {
            jsonWriter.beginArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(jsonWriter, it.next());
            }
            jsonWriter.endArray();
            return;
        }
        jsonWriter.nullValue();
    }

    public static JSONObject zzb(JSONObject jSONObject, String str) throws JSONException {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            return jSONObject2;
        }
    }

    public static JSONObject zza(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, obj);
        return jSONObject;
    }

    public static JSONObject zza(JSONObject jSONObject, String... strArr) {
        JSONObject a2 = a(jSONObject, strArr);
        if (a2 == null) {
            return null;
        }
        return a2.optJSONObject(strArr[strArr.length - 1]);
    }

    public static boolean zza(boolean z, JSONObject jSONObject, String... strArr) {
        JSONObject a2 = a(jSONObject, strArr);
        if (a2 == null) {
            return false;
        }
        return a2.optBoolean(strArr[strArr.length - 1], false);
    }

    private static JSONObject a(JSONObject jSONObject, String[] strArr) {
        for (int i = 0; i < strArr.length - 1; i++) {
            if (jSONObject == null) {
                return null;
            }
            jSONObject = jSONObject.optJSONObject(strArr[i]);
        }
        return jSONObject;
    }
}
