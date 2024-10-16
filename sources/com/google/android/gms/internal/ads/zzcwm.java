package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcwm implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f3476a;

    public zzcwm(List<String> list) {
        this.f3476a = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.f3476a));
        } catch (JSONException unused) {
            zzawz.zzds("Failed putting experiment ids.");
        }
    }
}
