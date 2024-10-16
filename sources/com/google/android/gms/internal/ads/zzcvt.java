package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcvt implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final String f3464a;

    public zzcvt(String str) {
        this.f3464a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.f3464a);
        } catch (JSONException e) {
            zzawz.zza("Failed putting Ad ID.", e);
        }
    }
}
