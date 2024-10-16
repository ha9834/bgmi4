package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzbfp implements zzaho<zzbdf> {
    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbdf zzbdfVar, Map map) {
        zzbdf zzbdfVar2 = zzbdfVar;
        zzbhq zzyb = zzbdfVar2.zzyb();
        if (zzyb == null) {
            try {
                zzbhq zzbhqVar = new zzbhq(zzbdfVar2, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzbdfVar2.zza(zzbhqVar);
                zzyb = zzbhqVar;
            } catch (NullPointerException | NumberFormatException e) {
                zzawz.zzc("Unable to parse videoMeta message.", e);
                zzk.zzlk().zza(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt < 0 || 3 < parseInt) {
            parseInt = 0;
        }
        String str = (String) map.get("aspectRatio");
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zzawz.isLoggable(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 140);
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(parseFloat2);
            sb.append(" , duration : ");
            sb.append(parseFloat);
            sb.append(" , isMuted : ");
            sb.append(equals);
            sb.append(" , playbackState : ");
            sb.append(parseInt);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            zzawz.zzdp(sb.toString());
        }
        zzyb.zza(parseFloat2, parseFloat, parseInt, equals, parseFloat3);
    }
}
