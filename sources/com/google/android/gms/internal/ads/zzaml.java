package com.google.android.gms.internal.ads;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaml {

    /* renamed from: a, reason: collision with root package name */
    private final String f2757a;
    private final String b;
    private final String c;
    private final String d;
    private final List<String> e;
    private final List<String> f;
    private final List<String> g;
    private final List<String> h;
    private final List<String> i;
    private final List<String> j;
    private final List<String> k;
    private final List<String> l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final List<String> r;
    private final String s;
    private final long t;
    public final List<String> zzdei;
    public final String zzdeq;
    public final String zzdfb;

    public zzaml(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.b = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdei = Collections.unmodifiableList(arrayList);
        this.c = jSONObject.optString("allocation_id", null);
        zzk.zzly();
        this.e = zzamn.zza(jSONObject, "clickurl");
        zzk.zzly();
        this.f = zzamn.zza(jSONObject, "imp_urls");
        zzk.zzly();
        this.g = zzamn.zza(jSONObject, "downloaded_imp_urls");
        zzk.zzly();
        this.i = zzamn.zza(jSONObject, "fill_urls");
        zzk.zzly();
        this.j = zzamn.zza(jSONObject, "video_start_urls");
        zzk.zzly();
        this.l = zzamn.zza(jSONObject, "video_complete_urls");
        zzk.zzly();
        this.k = zzamn.zza(jSONObject, "video_reward_urls");
        this.m = jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        this.n = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzk.zzly();
            list = zzamn.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.h = list;
        this.f2757a = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdeq = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.d = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.o = jSONObject.optString("html_template", null);
        this.p = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.q = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzk.zzly();
        this.r = zzamn.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.s = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzdfb = jSONObject.optString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, null);
        this.t = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
