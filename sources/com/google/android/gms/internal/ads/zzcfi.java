package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzk;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.connect.common.Constants;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcfi {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f3229a = new LinkedHashMap();

    public zzcfi(Context context, String str) {
        Map<String, String> map = this.f3229a;
        map.put(AnalyticsEventKey.SEARCH_QUERY, "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Build.VERSION.SDK);
        zzk.zzlg();
        map.put("device", zzaxi.zzwc());
        map.put(Constants.JumpUrlConstants.SRC_TYPE_APP, str);
        zzk.zzlg();
        map.put("is_lite_sdk", zzaxi.zzau(context) ? "1" : "0");
        map.put("e", TextUtils.join(",", zzacu.zzqo()));
    }

    public final void zzb(zzcxu zzcxuVar) {
        if (zzcxuVar.zzgky.zzgkt.size() > 0) {
            switch (zzcxuVar.zzgky.zzgkt.get(0).zzflt) {
                case 1:
                    this.f3229a.put("ad_format", "banner");
                    break;
                case 2:
                    this.f3229a.put("ad_format", "interstitial");
                    break;
                case 3:
                    this.f3229a.put("ad_format", "native_express");
                    break;
                case 4:
                    this.f3229a.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.f3229a.put("ad_format", "rewarded");
                    break;
                default:
                    this.f3229a.put("ad_format", "unknown");
                    break;
            }
            if (TextUtils.isEmpty(zzcxuVar.zzgky.zzgku.zzcep)) {
                return;
            }
            this.f3229a.put("gqi", zzcxuVar.zzgky.zzgku.zzcep);
        }
    }

    public final void zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.f3229a.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.f3229a.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzqy() {
        return this.f3229a;
    }
}
