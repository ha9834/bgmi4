package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzcya {
    public static void zzc(Throwable th, String str) {
        int zze = zzcgm.zze(th);
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(zze);
        zzawz.zzeo(sb.toString());
        zzawz.zza(str, th);
        if (zzcgm.zze(th) == 3) {
            return;
        }
        zzk.zzlk().zzb(th, str);
    }

    public static void zze(Context context, boolean z) {
        if (z) {
            zzawz.zzeo("This request is sent from a test device.");
            return;
        }
        zzyt.zzpa();
        String zzbe = zzazt.zzbe(context);
        StringBuilder sb = new StringBuilder(String.valueOf(zzbe).length() + 71);
        sb.append("Use AdRequest.Builder.addTestDevice(\"");
        sb.append(zzbe);
        sb.append("\") to get test ads on this device.");
        zzawz.zzeo(sb.toString());
    }
}
