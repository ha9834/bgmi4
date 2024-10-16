package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzk;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@zzard
@TargetApi(11)
/* loaded from: classes2.dex */
public class zzbia extends zzbha {
    public zzbia(zzbgz zzbgzVar, zzwj zzwjVar, boolean z) {
        super(zzbgzVar, zzwjVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final WebResourceResponse a(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbgz)) {
            zzawz.zzep("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbgz zzbgzVar = (zzbgz) webView;
        if (this.b != null) {
            this.b.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.a(str, map);
        }
        if (zzbgzVar.zzaai() != null) {
            zzbgzVar.zzaai().zzth();
        }
        if (zzbgzVar.zzaag().zzabx()) {
            str2 = (String) zzyt.zzpe().zzd(zzacu.zzcmu);
        } else if (zzbgzVar.zzaan()) {
            str2 = (String) zzyt.zzpe().zzd(zzacu.zzcmt);
        } else {
            str2 = (String) zzyt.zzpe().zzd(zzacu.zzcms);
        }
        zzk.zzlg();
        return zzaxi.zzd(zzbgzVar.getContext(), zzbgzVar.zzyh().zzbsx, str2);
    }
}
