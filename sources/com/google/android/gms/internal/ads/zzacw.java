package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.regex.Pattern;

@zzard
/* loaded from: classes2.dex */
public final class zzacw {
    public static boolean zzcg(String str) {
        return a((String) zzyt.zzpe().zzd(zzacu.zzcvd), str);
    }

    private static boolean a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        try {
            return Pattern.matches(str, str2);
        } catch (RuntimeException e) {
            zzk.zzlk().zza(e, "NonagonUtil.isPatternMatched");
            return false;
        }
    }
}
