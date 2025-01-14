package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzaz implements Runnable {
    private final zzba zzay;
    private final long zzdq;
    private final PowerManager.WakeLock zzdr = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId zzds;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzaz(FirebaseInstanceId firebaseInstanceId, zzam zzamVar, zzba zzbaVar, long j) {
        this.zzds = firebaseInstanceId;
        this.zzay = zzbaVar;
        this.zzdq = j;
        this.zzdr.setReferenceCounted(false);
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        boolean zzd;
        try {
            if (zzau.zzai().zzd(getContext())) {
                this.zzdr.acquire();
            }
            this.zzds.zza(true);
            if (!this.zzds.zzo()) {
                this.zzds.zza(false);
                if (zzd) {
                    return;
                } else {
                    return;
                }
            }
            if (zzau.zzai().zze(getContext()) && !zzao()) {
                new zzay(this).zzam();
                if (zzau.zzai().zzd(getContext())) {
                    this.zzdr.release();
                    return;
                }
                return;
            }
            if (zzan() && this.zzay.zzc(this.zzds)) {
                this.zzds.zza(false);
            } else {
                this.zzds.zza(this.zzdq);
            }
            if (zzau.zzai().zzd(getContext())) {
                this.zzdr.release();
            }
        } finally {
            if (zzau.zzai().zzd(getContext())) {
                this.zzdr.release();
            }
        }
    }

    @VisibleForTesting
    private final boolean zzan() {
        zzaw zzk = this.zzds.zzk();
        if (!this.zzds.zzr() && !this.zzds.zza(zzk)) {
            return true;
        }
        try {
            String zzl = this.zzds.zzl();
            if (zzl == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (zzk == null || (zzk != null && !zzl.equals(zzk.zzbx))) {
                Context context = getContext();
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", zzl);
                zzau.zzc(context, intent);
                zzau.zzb(context, new Intent("com.google.firebase.iid.TOKEN_REFRESH"));
            }
            return true;
        } catch (IOException | SecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Token retrieval failed: ".concat(valueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context getContext() {
        return this.zzds.zzi().getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzao() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
