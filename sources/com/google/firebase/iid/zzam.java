package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzam {
    private final Context zzag;

    @GuardedBy("this")
    private String zzcp;

    @GuardedBy("this")
    private String zzcq;

    @GuardedBy("this")
    private int zzcr;

    @GuardedBy("this")
    private int zzcs = 0;

    public zzam(Context context) {
        this.zzag = context;
    }

    public final synchronized int zzac() {
        if (this.zzcs != 0) {
            return this.zzcs;
        }
        PackageManager packageManager = this.zzag.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.zzcs = 1;
                return this.zzcs;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.zzcs = 2;
            return this.zzcs;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.isAtLeastO()) {
            this.zzcs = 2;
        } else {
            this.zzcs = 1;
        }
        return this.zzcs;
    }

    public static String zza(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(CertificateUtil.DELIMITER);
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    public final synchronized String zzad() {
        if (this.zzcp == null) {
            zzag();
        }
        return this.zzcp;
    }

    public final synchronized String zzae() {
        if (this.zzcq == null) {
            zzag();
        }
        return this.zzcq;
    }

    public final synchronized int zzaf() {
        PackageInfo zze;
        if (this.zzcr == 0 && (zze = zze("com.google.android.gms")) != null) {
            this.zzcr = zze.versionCode;
        }
        return this.zzcr;
    }

    private final synchronized void zzag() {
        PackageInfo zze = zze(this.zzag.getPackageName());
        if (zze != null) {
            this.zzcp = Integer.toString(zze.versionCode);
            this.zzcq = zze.versionName;
        }
    }

    private final PackageInfo zze(String str) {
        try {
            return this.zzag.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }
}
