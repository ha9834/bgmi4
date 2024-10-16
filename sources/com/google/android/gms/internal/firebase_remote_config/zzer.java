package com.google.android.gms.internal.firebase_remote_config;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzer {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f4162a;
    private Date b;
    private JSONArray c;

    private zzer() {
        Date date;
        this.f4162a = new JSONObject();
        date = zzep.f4160a;
        this.b = date;
        this.c = new JSONArray();
    }

    public final zzer zzd(Map<String, String> map) {
        this.f4162a = new JSONObject(map);
        return this;
    }

    public final zzer zzc(Date date) {
        this.b = date;
        return this;
    }

    public final zzer zzb(List<zzdd> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<zzdd> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(new JSONObject(it.next()));
        }
        this.c = jSONArray;
        return this;
    }

    public final zzep zzcw() throws JSONException {
        return new zzep(this.f4162a, this.b, this.c);
    }
}
