package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawl;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzyt;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzd {

    /* renamed from: a, reason: collision with root package name */
    private Context f1161a;
    private long b = 0;

    public final void zza(Context context, zzbai zzbaiVar, String str, Runnable runnable) {
        a(context, zzbaiVar, true, null, str, null, runnable);
    }

    public final void zza(Context context, zzbai zzbaiVar, String str, zzawl zzawlVar) {
        a(context, zzbaiVar, false, zzawlVar, zzawlVar != null ? zzawlVar.zzut() : null, str, null);
    }

    @VisibleForTesting
    private final void a(Context context, zzbai zzbaiVar, boolean z, zzawl zzawlVar, String str, String str2, Runnable runnable) {
        if (zzk.zzln().elapsedRealtime() - this.b < 5000) {
            zzawz.zzep("Not retrying to fetch app settings");
            return;
        }
        this.b = zzk.zzln().elapsedRealtime();
        boolean z2 = true;
        if (zzawlVar != null) {
            if (!(zzk.zzln().currentTimeMillis() - zzawlVar.zzuq() > ((Long) zzyt.zzpe().zzd(zzacu.zzcsy)).longValue()) && zzawlVar.zzur()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzawz.zzep("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzawz.zzep("App settings could not be fetched. Required parameters missing");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.f1161a = applicationContext;
            zzalj zza = zzk.zzlt().zzb(this.f1161a, zzbaiVar).zza("google.afma.config.fetchAppSettings", zzalo.zzddi, zzalo.zzddi);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbbh zzi = zza.zzi(jSONObject);
                zzbbh zza2 = zzbar.zza(zzi, a.f1148a, zzbbm.zzeaf);
                if (runnable != null) {
                    zzi.zza(runnable, zzbbm.zzeaf);
                }
                zzbao.zza(zza2, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e) {
                zzawz.zzc("Error requesting application settings", e);
            }
        }
    }
}
