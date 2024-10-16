package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
/* loaded from: classes.dex */
public class zzaxv extends zzaxu {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final int zzwi() {
        return R.style.Theme.Material.Dialog.Alert;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final CookieManager zzaz(Context context) {
        if (zzwh()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzawz.zzc("Failed to obtain CookieManager.", th);
            zzk.zzlk().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final zzbha zza(zzbgz zzbgzVar, zzwj zzwjVar, boolean z) {
        return new zzbib(zzbgzVar, zzwjVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
