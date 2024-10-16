package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzawl {

    /* renamed from: a, reason: collision with root package name */
    private final long f2815a;
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();
    private final Map<String, zzamm> d = new HashMap();
    private String e;
    private String f;
    private JSONObject g;
    private boolean h;

    public zzawl(String str, long j) {
        JSONObject optJSONObject;
        this.h = false;
        this.f = str;
        this.f2815a = j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.g = new JSONObject(str);
            if (this.g.optInt("status", -1) != 1) {
                this.h = false;
                zzawz.zzep("App settings could not be fetched successfully.");
                return;
            }
            this.h = true;
            this.e = this.g.optString("app_id");
            JSONArray optJSONArray = this.g.optJSONArray("ad_unit_id_settings");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("format");
                    String optString2 = jSONObject.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        if ("interstitial".equalsIgnoreCase(optString)) {
                            this.c.add(optString2);
                        } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject.optJSONObject("mediation_config")) != null) {
                            this.d.put(optString2, new zzamm(optJSONObject));
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = this.g.optJSONArray("persistable_banner_ad_unit_ids");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.b.add(optJSONArray2.optString(i2));
                }
            }
        } catch (JSONException e) {
            zzawz.zzd("Exception occurred while processing app setting json", e);
            zzk.zzlk().zza(e, "AppSettings.parseAppSettingsJson");
        }
    }

    public final long zzuq() {
        return this.f2815a;
    }

    public final boolean zzur() {
        return this.h;
    }

    public final String zzus() {
        return this.f;
    }

    public final String zzut() {
        return this.e;
    }

    public final Map<String, zzamm> zzuu() {
        return this.d;
    }

    public final JSONObject zzuv() {
        return this.g;
    }
}
