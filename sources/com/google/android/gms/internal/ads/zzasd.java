package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzasd {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f2790a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final String f;
    private final String g;
    private String h;
    private final int i;
    private final boolean j;
    private final JSONObject k;
    private final String l;
    private final boolean m;

    public zzasd(JSONObject jSONObject) {
        this.h = jSONObject.optString("url");
        this.b = jSONObject.optString("base_uri");
        this.c = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        this.e = optString != null && (optString.equals("1") || optString.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        this.f = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
        this.d = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        this.f2790a = optString2 == null ? null : Arrays.asList(optString2.split(","));
        this.i = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.g = jSONObject.optString("fetched_ad");
        this.j = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.k = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.l = jSONObject.optString("analytics_query_ad_event_id");
        this.m = jSONObject.optBoolean("is_analytics_logging_enabled");
    }

    public final String zztu() {
        return this.b;
    }

    public final String zztv() {
        return this.c;
    }

    public final String getUrl() {
        return this.h;
    }

    public final boolean zztw() {
        return this.e;
    }

    public final JSONObject zztx() {
        return this.k;
    }
}
