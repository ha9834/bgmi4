package com.vk.api.sdk.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import kotlin.jvm.internal.h;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a extends b<Boolean> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super(str, null, 2, null);
        h.b(str, FirebaseAnalytics.Param.METHOD);
    }

    @Override // com.vk.api.sdk.b.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean b(JSONObject jSONObject) {
        h.b(jSONObject, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        return true;
    }
}
