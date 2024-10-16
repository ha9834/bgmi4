package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzyt;

@zzard
/* loaded from: classes.dex */
public final class zza {
    public static boolean zza(Context context, zzc zzcVar, zzu zzuVar) {
        int i = 0;
        if (zzcVar == null) {
            zzawz.zzep("No intent data for launcher overlay.");
            return false;
        }
        zzacu.initialize(context);
        if (zzcVar.intent != null) {
            return a(context, zzcVar.intent, zzuVar);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzcVar.url)) {
            zzawz.zzep("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzcVar.mimeType)) {
            intent.setDataAndType(Uri.parse(zzcVar.url), zzcVar.mimeType);
        } else {
            intent.setData(Uri.parse(zzcVar.url));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzcVar.packageName)) {
            intent.setPackage(zzcVar.packageName);
        }
        if (!TextUtils.isEmpty(zzcVar.zzdjh)) {
            String[] split = zzcVar.zzdjh.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzcVar.zzdjh);
                zzawz.zzep(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = zzcVar.zzdji;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzawz.zzep("Could not parse intent flags.");
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctz)).booleanValue()) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.putExtra("androidx.browser.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcty)).booleanValue()) {
                zzk.zzlg();
                zzaxi.zzb(context, intent);
            }
        }
        return a(context, intent, zzuVar);
    }

    private static boolean a(Context context, Intent intent, zzu zzuVar) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzawz.zzds(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzk.zzlg();
            zzaxi.zza(context, intent);
            if (zzuVar == null) {
                return true;
            }
            zzuVar.zztq();
            return true;
        } catch (ActivityNotFoundException e) {
            zzawz.zzep(e.getMessage());
            return false;
        }
    }
}
