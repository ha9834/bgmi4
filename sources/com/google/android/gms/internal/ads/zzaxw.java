package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;

@TargetApi(24)
/* loaded from: classes.dex */
public class zzaxw extends zzaxv {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuh)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuj)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzyt.zzpa();
        int zza = zzazt.zza(activity, configuration.screenHeightDp);
        int zza2 = zzazt.zza(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        zzk.zzlg();
        DisplayMetrics zza3 = zzaxi.zza(windowManager);
        int i = zza3.heightPixels;
        int i2 = zza3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int round = ((int) Math.round(d + 0.5d)) * ((Integer) zzyt.zzpe().zzd(zzacu.zzcug)).intValue();
        return !(a(i, zza + dimensionPixelSize, round) && a(i2, zza2, round));
    }

    private static boolean a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }
}
