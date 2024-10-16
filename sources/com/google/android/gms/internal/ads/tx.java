package com.google.android.gms.internal.ads;

import com.helpshift.analytics.AnalyticsEventKey;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final /* synthetic */ class tx implements zzczc {

    /* renamed from: a, reason: collision with root package name */
    static final zzczc f2531a = new tx();

    private tx() {
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optInt("error_code") == 6) {
            return zzalo.zzddj.zzd(jSONObject.getJSONObject(AnalyticsEventKey.RESPONSE));
        }
        throw new zzcif(jSONObject.getString("error_reason"), jSONObject.optInt("error_code", 0));
    }
}
