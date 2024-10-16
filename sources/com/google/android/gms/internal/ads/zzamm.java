package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzamm {

    /* renamed from: a, reason: collision with root package name */
    private final long f2758a;
    private final List<String> b;
    private final List<String> c;
    private final List<String> d;
    private final List<String> e;
    private final List<String> f;
    private final boolean g;
    private final String h;
    private final long i;
    private final String j;
    private final int k;
    private final int l;
    private final long m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private int r;
    private int s;
    private boolean t;
    public final List<zzaml> zzdfd;

    public zzamm(JSONObject jSONObject) throws JSONException {
        if (zzawz.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzawz.zzds(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzaml zzamlVar = new zzaml(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzamlVar.zzdfb)) {
                    this.t = true;
                }
                arrayList.add(zzamlVar);
                if (i < 0) {
                    Iterator<String> it = zzamlVar.zzdei.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.r = i;
        this.s = jSONArray.length();
        this.zzdfd = Collections.unmodifiableList(arrayList);
        this.h = jSONObject.optString("qdata");
        this.l = jSONObject.optInt("fs_model_type", -1);
        this.m = jSONObject.optLong("timeout_ms", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f2758a = optJSONObject.optLong("ad_network_timeout_millis", -1L);
            zzk.zzly();
            this.b = zzamn.zza(optJSONObject, "click_urls");
            zzk.zzly();
            this.c = zzamn.zza(optJSONObject, "imp_urls");
            zzk.zzly();
            this.d = zzamn.zza(optJSONObject, "downloaded_imp_urls");
            zzk.zzly();
            this.e = zzamn.zza(optJSONObject, "nofill_urls");
            zzk.zzly();
            this.f = zzamn.zza(optJSONObject, "remote_ping_urls");
            this.g = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1L);
            this.i = optLong > 0 ? 1000 * optLong : -1L;
            zzato zza = zzato.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.j = null;
                this.k = 0;
            } else {
                this.j = zza.type;
                this.k = zza.zzdqm;
            }
            this.n = optJSONObject.optBoolean("use_displayed_impression", false);
            this.o = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.p = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.q = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.f2758a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.i = -1L;
        this.j = null;
        this.k = 0;
        this.n = false;
        this.g = false;
        this.o = false;
        this.p = false;
        this.q = false;
    }
}
