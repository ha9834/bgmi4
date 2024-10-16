package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzagy implements zzaho<zzbgz> {
    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzawz.zzep("No label given for CSI tick.");
                return;
            }
            if (TextUtils.isEmpty(str4)) {
                zzawz.zzep("No timestamp given for CSI tick.");
                return;
            }
            try {
                long elapsedRealtime = zzk.zzln().elapsedRealtime() + (Long.parseLong(str4) - zzk.zzln().currentTimeMillis());
                if (TextUtils.isEmpty(str3)) {
                    str3 = "native:view_load";
                }
                zzbgzVar2.zzyg().zza(str2, str3, elapsedRealtime);
                return;
            } catch (NumberFormatException e) {
                zzawz.zzd("Malformed timestamp for CSI tick.", e);
                return;
            }
        }
        if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzawz.zzep("No value given for CSI experiment.");
                return;
            }
            zzadi zzqw = zzbgzVar2.zzyg().zzqw();
            if (zzqw == null) {
                zzawz.zzep("No ticker for WebView, dropping experiment ID.");
                return;
            } else {
                zzqw.zzh("e", str5);
                return;
            }
        }
        if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzawz.zzep("No value given for CSI extra.");
                return;
            }
            if (TextUtils.isEmpty(str6)) {
                zzawz.zzep("No name given for CSI extra.");
                return;
            }
            zzadi zzqw2 = zzbgzVar2.zzyg().zzqw();
            if (zzqw2 == null) {
                zzawz.zzep("No ticker for WebView, dropping extra parameter.");
            } else {
                zzqw2.zzh(str6, str7);
            }
        }
    }
}
