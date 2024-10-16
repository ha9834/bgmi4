package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcwb implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f3469a;

    public zzcwb(JSONObject jSONObject) {
        this.f3469a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.f3469a);
        } catch (JSONException unused) {
            zzawz.zzds("Unable to get cache_state");
        }
    }
}
