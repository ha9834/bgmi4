package com.google.android.gms.internal.ads;

import android.content.Context;

@zzard
/* loaded from: classes2.dex */
public final class zzawx {
    public static void zzaj(Context context) {
        if (zzazx.zzbk(context) && !zzazx.zzxb()) {
            zzbbh zzvi = new fj(context).zzvi();
            zzawz.zzeo("Updating ad debug logging enablement.");
            zzbao.zza(zzvi, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
