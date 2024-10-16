package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzbde {
    public final boolean zzeec;
    public final int zzeed;
    public final int zzeee;
    public final int zzeef;
    public final String zzeeg;
    public final int zzeeh;
    public final int zzeei;
    public final int zzeej;
    public final int zzeek;
    public final boolean zzeel;

    public zzbde(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzeec = a(jSONObject, "aggressive_media_codec_release", zzacu.zzcmi);
        this.zzeed = b(jSONObject, "byte_buffer_precache_limit", zzacu.zzclr);
        this.zzeee = b(jSONObject, "exo_cache_buffer_size", zzacu.zzclw);
        this.zzeef = b(jSONObject, "exo_connect_timeout_millis", zzacu.zzcln);
        this.zzeeg = c(jSONObject, "exo_player_version", zzacu.zzclm);
        this.zzeeh = b(jSONObject, "exo_read_timeout_millis", zzacu.zzclo);
        this.zzeei = b(jSONObject, "load_check_interval_bytes", zzacu.zzclp);
        this.zzeej = b(jSONObject, "player_precache_limit", zzacu.zzclq);
        this.zzeek = b(jSONObject, "socket_receive_buffer_size", zzacu.zzcls);
        this.zzeel = a(jSONObject, "use_cache_data_source", zzacu.zzctr);
    }

    private static boolean a(JSONObject jSONObject, String str, zzacj<Boolean> zzacjVar) {
        return a(jSONObject, str, ((Boolean) zzyt.zzpe().zzd(zzacjVar)).booleanValue());
    }

    private static boolean a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    private static int b(JSONObject jSONObject, String str, zzacj<Integer> zzacjVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzyt.zzpe().zzd(zzacjVar)).intValue();
    }

    private static String c(JSONObject jSONObject, String str, zzacj<String> zzacjVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzyt.zzpe().zzd(zzacjVar);
    }
}
