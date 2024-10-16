package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.helpshift.analytics.AnalyticsEventKey;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzbgc implements zzaho<zzbdf> {
    private static Integer a(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzawz.zzep(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbdf zzbdfVar, Map map) {
        zzbft zzbftVar;
        zzbdf zzbdfVar2 = zzbdfVar;
        if (zzawz.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzawz.zzdp(sb.toString());
        }
        zzk.zzmc();
        if (map.containsKey("abort")) {
            if (zzbfs.zzc(zzbdfVar2)) {
                return;
            }
            zzawz.zzep("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get(AnalyticsEventKey.FAQ_SOURCE);
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    String valueOf2 = String.valueOf(str2);
                    zzawz.zzep(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (zzbfs.a(zzbdfVar2) != null) {
                zzawz.zzep("Precache task is already running.");
                return;
            }
            if (zzbdfVar2.zzye() == null) {
                zzawz.zzep("Precache requires a dependency provider.");
                return;
            }
            zzbde zzbdeVar = new zzbde((String) map.get("flags"));
            Integer a2 = a(map, VineCardUtils.PLAYER_CARD);
            if (a2 == null) {
                a2 = 0;
            }
            zzbftVar = zzbdfVar2.zzye().zzbqr.zza(zzbdfVar2, a2.intValue(), null, zzbdeVar);
            new zzbfq(zzbdfVar2, zzbftVar, str, strArr).zzvi();
        } else {
            zzbfq a3 = zzbfs.a(zzbdfVar2);
            if (a3 != null) {
                zzbftVar = a3.b;
            } else {
                zzawz.zzep("Precache must specify a source.");
                return;
            }
        }
        Integer a4 = a(map, "minBufferMs");
        if (a4 != null) {
            zzbftVar.zzcy(a4.intValue());
        }
        Integer a5 = a(map, "maxBufferMs");
        if (a5 != null) {
            zzbftVar.zzcz(a5.intValue());
        }
        Integer a6 = a(map, "bufferForPlaybackMs");
        if (a6 != null) {
            zzbftVar.zzda(a6.intValue());
        }
        Integer a7 = a(map, "bufferForPlaybackAfterRebufferMs");
        if (a7 != null) {
            zzbftVar.zzdb(a7.intValue());
        }
    }
}
