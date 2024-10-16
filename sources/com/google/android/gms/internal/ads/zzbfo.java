package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.helpshift.analytics.AnalyticsEventKey;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzbfo implements zzaho<zzbdf> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2867a;

    private static int a(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzyt.zzpa();
            return zzazt.zza(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzawz.zzep(sb.toString());
            return i;
        }
    }

    private static void a(zzbcq zzbcqVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbcqVar.zzcy(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzawz.zzep(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbcqVar.zzcz(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbcqVar.zzda(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbcqVar.zzdb(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbcqVar.zzdc(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbdf zzbdfVar, Map map) {
        int i;
        zzbdf zzbdfVar2 = zzbdfVar;
        String str = (String) map.get("action");
        if (str == null) {
            zzawz.zzep("Action missing from video GMSG.");
            return;
        }
        if (zzawz.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzawz.zzdp(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzawz.zzep("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbdfVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                zzawz.zzep("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzawz.zzep("No MIME types specified for decoder properties inspection.");
                zzbcq.zza(zzbdfVar2, "missingMimeTypes");
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                zzawz.zzep("Video decoder properties available on API versions >= 16.");
                zzbcq.zza(zzbdfVar2, "deficientApiVersion");
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str4 : str3.split(",")) {
                hashMap.put(str4, zzazr.zzeh(str4.trim()));
            }
            zzbcq.zza(zzbdfVar2, hashMap);
            return;
        }
        zzbcw zzya = zzbdfVar2.zzya();
        if (zzya == null) {
            zzawz.zzep("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        if (equals || equals2) {
            Context context = zzbdfVar2.getContext();
            int a2 = a(context, map, "x", 0);
            int a3 = a(context, map, "y", 0);
            int a4 = a(context, map, "w", -1);
            int a5 = a(context, map, "h", -1);
            int min = Math.min(a4, zzbdfVar2.zzyj() - a2);
            int min2 = Math.min(a5, zzbdfVar2.zzyi() - a3);
            try {
                i = Integer.parseInt((String) map.get(VineCardUtils.PLAYER_CARD));
            } catch (NumberFormatException unused2) {
                i = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (equals && zzya.zzxw() == null) {
                zzya.zza(a2, a3, min, min2, i, parseBoolean, new zzbde((String) map.get("flags")));
                zzbcq zzxw = zzya.zzxw();
                if (zzxw != null) {
                    a(zzxw, map);
                    return;
                }
                return;
            }
            zzya.zze(a2, a3, min, min2);
            return;
        }
        zzbhq zzyb = zzbdfVar2.zzyb();
        if (zzyb != null) {
            if ("timeupdate".equals(str)) {
                String str5 = (String) map.get("currentTime");
                if (str5 == null) {
                    zzawz.zzep("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    zzyb.zze(Float.parseFloat(str5));
                    return;
                } catch (NumberFormatException unused3) {
                    String valueOf = String.valueOf(str5);
                    zzawz.zzep(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                    return;
                }
            }
            if ("skip".equals(str)) {
                zzyb.zzabs();
                return;
            }
        }
        zzbcq zzxw2 = zzya.zzxw();
        if (zzxw2 == null) {
            zzbcq.zzb(zzbdfVar2);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = zzbdfVar2.getContext();
            int a6 = a(context2, map, "x", 0);
            int a7 = a(context2, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, a6, a7, 0);
            zzxw2.zze(obtain);
            obtain.recycle();
            return;
        }
        if ("currentTime".equals(str)) {
            String str6 = (String) map.get("time");
            if (str6 == null) {
                zzawz.zzep("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzxw2.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                return;
            } catch (NumberFormatException unused4) {
                String valueOf2 = String.valueOf(str6);
                zzawz.zzep(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                return;
            }
        }
        if (MessengerShareContentUtility.SHARE_BUTTON_HIDE.equals(str)) {
            zzxw2.setVisibility(4);
            return;
        }
        if ("load".equals(str)) {
            zzxw2.zzfr();
            return;
        }
        if ("loadControl".equals(str)) {
            a(zzxw2, map);
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzxw2.zzxq();
                return;
            } else {
                zzxw2.zzxr();
                return;
            }
        }
        if ("pause".equals(str)) {
            zzxw2.pause();
            return;
        }
        if ("play".equals(str)) {
            zzxw2.play();
            return;
        }
        if ("show".equals(str)) {
            zzxw2.setVisibility(0);
            return;
        }
        if (AnalyticsEventKey.FAQ_SOURCE.equals(str)) {
            String str7 = (String) map.get(AnalyticsEventKey.FAQ_SOURCE);
            String[] strArr = {str7};
            String str8 = (String) map.get("demuxed");
            if (str8 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str8);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr2[i2] = jSONArray.getString(i2);
                    }
                    strArr = strArr2;
                } catch (JSONException unused5) {
                    String valueOf3 = String.valueOf(str8);
                    zzawz.zzep(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                    strArr = new String[]{str7};
                }
            }
            zzxw2.zzc(str7, strArr);
            return;
        }
        if ("touchMove".equals(str)) {
            Context context3 = zzbdfVar2.getContext();
            zzxw2.zza(a(context3, map, "dx", 0), a(context3, map, "dy", 0));
            if (this.f2867a) {
                return;
            }
            zzbdfVar2.zztm();
            this.f2867a = true;
            return;
        }
        if ("volume".equals(str)) {
            String str9 = (String) map.get("volume");
            if (str9 == null) {
                zzawz.zzep("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zzxw2.setVolume(Float.parseFloat(str9));
                return;
            } catch (NumberFormatException unused6) {
                String valueOf4 = String.valueOf(str9);
                zzawz.zzep(valueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
                return;
            }
        }
        if ("watermark".equals(str)) {
            zzxw2.zzxs();
        } else {
            String valueOf5 = String.valueOf(str);
            zzawz.zzep(valueOf5.length() != 0 ? "Unknown video action: ".concat(valueOf5) : new String("Unknown video action: "));
        }
    }
}
