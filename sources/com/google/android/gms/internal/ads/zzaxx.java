package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;

@TargetApi(26)
/* loaded from: classes.dex */
public class zzaxx extends zzaxw {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final zzwx zza(Context context, TelephonyManager telephonyManager) {
        zzk.zzlg();
        if (zzaxi.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzwx.ENUM_TRUE : zzwx.ENUM_FALSE;
        }
        return zzwx.ENUM_FALSE;
    }
}
