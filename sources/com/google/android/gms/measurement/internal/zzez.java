package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzez {

    /* renamed from: a, reason: collision with root package name */
    private final zzfa f4939a;

    public zzez(zzfa zzfaVar) {
        Preconditions.checkNotNull(zzfaVar);
        this.f4939a = zzfaVar;
    }

    public static boolean zzl(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void onReceive(Context context, Intent intent) {
        zzfj zza = zzfj.zza(context, null);
        zzef zzab = zza.zzab();
        if (intent == null) {
            zzab.zzgn().zzao("Receiver called with null intent");
            return;
        }
        zza.zzae();
        String action = intent.getAction();
        zzab.zzgs().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzab.zzgs().zzao("Starting wakeful intent.");
            this.f4939a.doStartService(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zza.zzaa().zza(new dd(this, zza, zzab));
            } catch (Exception e) {
                zzab.zzgn().zza("Install Referrer Reporter encountered a problem", e);
            }
            BroadcastReceiver.PendingResult doGoAsync = this.f4939a.doGoAsync();
            String stringExtra = intent.getStringExtra(Constants.REFERRER);
            if (stringExtra == null) {
                zzab.zzgs().zzao("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            zzab.zzgq().zza("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                String valueOf = String.valueOf(stringExtra);
                stringExtra = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            Bundle a2 = zza.zzz().a(Uri.parse(stringExtra));
            if (a2 == null) {
                zzab.zzgs().zzao("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0L) * 1000;
            if (longExtra == 0) {
                zzab.zzgn().zzao("Install referrer is missing timestamp");
            }
            zza.zzaa().zza(new df(this, zza, longExtra, a2, context, zzab, doGoAsync));
        }
    }
}
