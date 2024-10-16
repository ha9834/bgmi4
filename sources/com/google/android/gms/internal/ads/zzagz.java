package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.IR;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzagz {
    public static final zzaho<zzbgz> zzczq = z.f2653a;
    public static final zzaho<zzbgz> zzczr = aa.f1751a;
    public static final zzaho<zzbgz> zzczs = ab.f1774a;
    public static final zzaho<zzbgz> zzczt = new ae();
    public static final zzaho<zzbgz> zzczu = new af();
    public static final zzaho<zzbgz> zzczv = ac.f1784a;
    public static final zzaho<Object> zzczw = new ag();
    public static final zzaho<zzbgz> zzczx = new ah();
    public static final zzaho<zzbgz> zzczy = ad.f1806a;
    public static final zzaho<zzbgz> zzczz = new ai();
    public static final zzaho<zzbgz> zzdaa = new aj();
    public static final zzaho<zzbdf> zzdab = new zzbfo();
    public static final zzaho<zzbdf> zzdac = new zzbfp();
    public static final zzaho<zzbgz> zzdad = new zzagy();
    public static final zzahu zzdae = new zzahu();
    public static final zzaho<zzbgz> zzdaf = new ak();
    public static final zzaho<zzbgz> zzdag = new al();
    public static final zzaho<zzbgz> zzdah = new am();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzbif zzbifVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzdh zzaal = zzbifVar.zzaal();
            if (zzaal != null) {
                zzaal.zzcg().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzawz.zzep("Could not parse touch parameters from gmsg.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzbhx zzbhxVar, Map map) {
        String str = (String) map.get(AnalyticsEventKey.URL);
        if (str == null) {
            zzawz.zzep("URL missing from httpTrack GMSG.");
        } else {
            new zzazi(zzbhxVar.getContext(), ((zzbig) zzbhxVar).zzyh().zzbsx, str).zzvi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzaji zzajiVar, Map map) {
        String str = (String) map.get(AnalyticsEventKey.URL);
        if (str == null) {
            zzawz.zzep("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzdh zzaal = ((zzbif) zzajiVar).zzaal();
            if (zzaal != null && zzaal.zzc(parse)) {
                parse = zzaal.zza(parse, ((zzbhx) zzajiVar).getContext(), ((zzbih) zzajiVar).getView(), ((zzbhx) zzajiVar).zzyd());
            }
        } catch (zzdi unused) {
            String valueOf = String.valueOf(str);
            zzawz.zzep(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        zzbhx zzbhxVar = (zzbhx) zzajiVar;
        new zzazi(zzbhxVar.getContext(), ((zzbig) zzajiVar).zzyh().zzbsx, zzavx.zzb(parse, zzbhxVar.getContext())).zzvi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void b(zzbhx zzbhxVar, Map map) {
        PackageManager packageManager = zzbhxVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString(AnalyticsEventKey.URL);
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString(AnalyticsEventKey.PROTOCOL);
                        String optString6 = jSONObject2.optString(IR.path.DOCS_IMSDK_CHANNEL);
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                String valueOf = String.valueOf(optString7);
                                zzawz.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e);
                            }
                        }
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (JSONException e2) {
                            zzawz.zzc("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzawz.zzc("Error parsing the intent data.", e3);
                    }
                }
                ((zzaji) zzbhxVar).zza("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzaji) zzbhxVar).zza("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzaji) zzbhxVar).zza("openableIntents", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void c(zzbhx zzbhxVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzawz.zzep("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbhxVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzaji) zzbhxVar).zza("openableURLs", hashMap);
    }
}
