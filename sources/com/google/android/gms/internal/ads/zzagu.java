package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzagu implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final zzagv f2729a;

    public zzagu(zzagv zzagvVar) {
        this.f2729a = zzagvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        if (this.f2729a == null) {
            return;
        }
        String str = map.get("name");
        if (str == null) {
            zzawz.zzeo("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundle = null;
        if (map.containsKey(NetworkManager.CMD_INFO)) {
            try {
                bundle = a(new JSONObject(map.get(NetworkManager.CMD_INFO)));
            } catch (JSONException e) {
                zzawz.zzc("Failed to convert ad metadata to JSON.", e);
            }
        }
        if (bundle == null) {
            zzawz.zzen("Failed to convert ad metadata to Bundle.");
        } else {
            this.f2729a.zza(str, bundle);
        }
    }

    private static Bundle a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        Bundle bundle = new Bundle();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != null) {
                if (obj instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof String) {
                    bundle.putString(next, (String) obj);
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    if (jSONArray != null && jSONArray.length() != 0) {
                        int length = jSONArray.length();
                        int i = 0;
                        Object obj2 = null;
                        for (int i2 = 0; obj2 == null && i2 < length; i2++) {
                            obj2 = !jSONArray.isNull(i2) ? jSONArray.get(i2) : null;
                        }
                        if (obj2 == null) {
                            String valueOf = String.valueOf(next);
                            zzawz.zzep(valueOf.length() != 0 ? "Expected JSONArray with at least 1 non-null element for key:".concat(valueOf) : new String("Expected JSONArray with at least 1 non-null element for key:"));
                        } else if (obj2 instanceof JSONObject) {
                            Bundle[] bundleArr = new Bundle[length];
                            while (i < length) {
                                bundleArr[i] = !jSONArray.isNull(i) ? a(jSONArray.optJSONObject(i)) : null;
                                i++;
                            }
                            bundle.putParcelableArray(next, bundleArr);
                        } else if (obj2 instanceof Number) {
                            double[] dArr = new double[jSONArray.length()];
                            while (i < length) {
                                dArr[i] = jSONArray.optDouble(i);
                                i++;
                            }
                            bundle.putDoubleArray(next, dArr);
                        } else if (obj2 instanceof CharSequence) {
                            String[] strArr = new String[length];
                            while (i < length) {
                                strArr[i] = !jSONArray.isNull(i) ? jSONArray.optString(i) : null;
                                i++;
                            }
                            bundle.putStringArray(next, strArr);
                        } else if (obj2 instanceof Boolean) {
                            boolean[] zArr = new boolean[length];
                            while (i < length) {
                                zArr[i] = jSONArray.optBoolean(i);
                                i++;
                            }
                            bundle.putBooleanArray(next, zArr);
                        } else {
                            zzawz.zzep(String.format("JSONArray with unsupported type %s for key:%s", obj2.getClass().getCanonicalName(), next));
                        }
                    }
                } else if (obj instanceof JSONObject) {
                    bundle.putBundle(next, a((JSONObject) obj));
                } else {
                    String valueOf2 = String.valueOf(next);
                    zzawz.zzep(valueOf2.length() != 0 ? "Unsupported type for key:".concat(valueOf2) : new String("Unsupported type for key:"));
                }
            }
        }
        return bundle;
    }
}
