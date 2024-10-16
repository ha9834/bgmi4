package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcvx implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f3466a;

    public zzcvx(JSONObject jSONObject) {
        this.f3466a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzazc.zzb(jSONObject, "content_info");
            JSONObject jSONObject2 = this.f3466a;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            zzawz.zzds("Failed putting app indexing json.");
        }
    }
}
