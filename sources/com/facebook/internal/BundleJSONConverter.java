package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class BundleJSONConverter {
    public static final BundleJSONConverter INSTANCE = new BundleJSONConverter();
    private static final Map<Class<?>, Setter> SETTERS = new HashMap();

    /* loaded from: classes.dex */
    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        SETTERS.put(Boolean.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.1
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                h.b(bundle, "bundle");
                h.b(str, "key");
                h.b(obj, "value");
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                h.b(jSONObject, "json");
                h.b(str, "key");
                h.b(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Integer.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.2
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                h.b(bundle, "bundle");
                h.b(str, "key");
                h.b(obj, "value");
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                h.b(jSONObject, "json");
                h.b(str, "key");
                h.b(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Long.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.3
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                h.b(bundle, "bundle");
                h.b(str, "key");
                h.b(obj, "value");
                bundle.putLong(str, ((Long) obj).longValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                h.b(jSONObject, "json");
                h.b(str, "key");
                h.b(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Double.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.4
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                h.b(bundle, "bundle");
                h.b(str, "key");
                h.b(obj, "value");
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                h.b(jSONObject, "json");
                h.b(str, "key");
                h.b(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.5
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                h.b(bundle, "bundle");
                h.b(str, "key");
                h.b(obj, "value");
                bundle.putString(str, (String) obj);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                h.b(jSONObject, "json");
                h.b(str, "key");
                h.b(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String[].class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.6
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                h.b(bundle, "bundle");
                h.b(str, "key");
                h.b(obj, "value");
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                h.b(jSONObject, "json");
                h.b(str, "key");
                h.b(obj, "value");
                JSONArray jSONArray = new JSONArray();
                for (String str2 : (String[]) obj) {
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        SETTERS.put(JSONArray.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                h.b(bundle, "bundle");
                h.b(str, "key");
                h.b(obj, "value");
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        arrayList.add(obj2);
                    } else {
                        throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                h.b(jSONObject, "json");
                h.b(str, "key");
                h.b(obj, "value");
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    private BundleJSONConverter() {
    }

    public static final JSONObject convertToJSON(Bundle bundle) throws JSONException {
        h.b(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                h.a(obj, "bundle[key] ?: // Null i…orted.\n          continue");
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    h.a((Object) str, "key");
                    setter.setOnJSON(jSONObject, str, obj);
                }
            }
        }
        return jSONObject;
    }

    public static final Bundle convertToBundle(JSONObject jSONObject) throws JSONException {
        h.b(jSONObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    h.a((Object) next, "key");
                    h.a(obj, "value");
                    setter.setOnBundle(bundle, next, obj);
                }
            }
        }
        return bundle;
    }
}
