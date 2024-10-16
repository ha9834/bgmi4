package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzk;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.connect.common.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@zzard
/* loaded from: classes2.dex */
public final class zzacx {

    /* renamed from: a, reason: collision with root package name */
    private String f2702a = (String) zzyt.zzpe().zzd(zzacu.zzcmy);
    private Map<String, String> b = new LinkedHashMap();
    private Context c;
    private String d;

    public zzacx(Context context, String str) {
        String packageName;
        this.c = null;
        this.d = null;
        this.c = context;
        this.d = str;
        this.b.put(AnalyticsEventKey.SEARCH_QUERY, "gmob_sdk");
        this.b.put("v", "3");
        this.b.put("os", Build.VERSION.RELEASE);
        this.b.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Build.VERSION.SDK);
        Map<String, String> map = this.b;
        zzk.zzlg();
        map.put("device", zzaxi.zzwc());
        Map<String, String> map2 = this.b;
        if (context.getApplicationContext() != null) {
            packageName = context.getApplicationContext().getPackageName();
        } else {
            packageName = context.getPackageName();
        }
        map2.put(Constants.JumpUrlConstants.SRC_TYPE_APP, packageName);
        Map<String, String> map3 = this.b;
        zzk.zzlg();
        map3.put("is_lite_sdk", zzaxi.zzau(context) ? "1" : "0");
        Future<zzase> zzt = zzk.zzlr().zzt(this.c);
        try {
            this.b.put("network_coarse", Integer.toString(zzt.get().zzdps));
            this.b.put("network_fine", Integer.toString(zzt.get().zzdpt));
        } catch (Exception e) {
            zzk.zzlk().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.f2702a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> d() {
        return this.b;
    }
}
