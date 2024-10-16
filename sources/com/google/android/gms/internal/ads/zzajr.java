package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final /* synthetic */ class zzajr {
    public static void zza(zzajq zzajqVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzajqVar.zzi(str, jSONObject.toString());
    }

    public static void zza(zzajq zzajqVar, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzajqVar.zzco(sb.toString());
    }

    public static void zzb(zzajq zzajqVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzawz.zzdp(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzajqVar.zzco(sb.toString());
    }

    public static void zza(zzajq zzajqVar, String str, Map map) {
        try {
            zzajqVar.zza(str, zzk.zzlg().zzi((Map<String, ?>) map));
        } catch (JSONException unused) {
            zzawz.zzep("Could not convert parameters to JSON.");
        }
    }
}
