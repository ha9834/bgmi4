package com.google.android.gms.internal.firebase_remote_config;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzep {

    /* renamed from: a, reason: collision with root package name */
    private static final Date f4160a = new Date(0);
    private JSONObject b;
    private JSONObject c;
    private Date d;
    private JSONArray e;

    private zzep(JSONObject jSONObject, Date date, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.c = jSONObject;
        this.d = date;
        this.e = jSONArray;
        this.b = jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzep a(JSONObject jSONObject) throws JSONException {
        return new zzep(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"));
    }

    public final JSONObject zzcq() {
        return this.c;
    }

    public final Date zzcr() {
        return this.d;
    }

    public final JSONArray zzcs() {
        return this.e;
    }

    public final String toString() {
        return this.b.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzep) {
            return this.b.toString().equals(((zzep) obj).toString());
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public static zzer zzct() {
        return new zzer();
    }
}
