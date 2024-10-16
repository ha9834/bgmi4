package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzadb {
    public static boolean zza(zzadi zzadiVar, zzadg zzadgVar, String... strArr) {
        if (zzadiVar == null || zzadgVar == null || !zzadiVar.f2706a || zzadgVar == null) {
            return false;
        }
        return zzadiVar.zza(zzadgVar, zzk.zzln().elapsedRealtime(), strArr);
    }

    public static zzadg zzb(zzadi zzadiVar) {
        if (zzadiVar == null) {
            return null;
        }
        return zzadiVar.zzfa(zzk.zzln().elapsedRealtime());
    }
}
