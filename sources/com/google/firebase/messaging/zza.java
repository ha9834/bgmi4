package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.h;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.drive.DriveFile;
import com.huawei.game.gamekit.b.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zza {
    private static final AtomicInteger zzdt = new AtomicInteger((int) SystemClock.elapsedRealtime());
    private final Context zzag;
    private final String zzdu;

    @GuardedBy("this")
    private Bundle zzdv;

    public zza(Context context, String str) {
        this.zzag = context;
        this.zzdu = str;
    }

    public final zzc zzf(Bundle bundle) {
        Uri defaultUri;
        Intent launchIntentForPackage;
        PendingIntent activity;
        h.e eVar = new h.e(this.zzag, zzm(zza(bundle, "gcm.n.android_channel_id")));
        eVar.c(true);
        eVar.a(zzg(bundle));
        String zzc = zzc(bundle, "gcm.n.body");
        if (!TextUtils.isEmpty(zzc)) {
            eVar.b((CharSequence) zzc);
            eVar.a(new h.c().a(zzc));
        }
        eVar.a(zzk(zza(bundle, "gcm.n.icon")));
        String zzi = zzi(bundle);
        PendingIntent pendingIntent = null;
        if (TextUtils.isEmpty(zzi)) {
            defaultUri = null;
        } else if (!a.f5471a.equals(zzi) && this.zzag.getResources().getIdentifier(zzi, "raw", this.zzdu) != 0) {
            String str = this.zzdu;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(zzi).length());
            sb.append("android.resource://");
            sb.append(str);
            sb.append("/raw/");
            sb.append(zzi);
            defaultUri = Uri.parse(sb.toString());
        } else {
            defaultUri = RingtoneManager.getDefaultUri(2);
        }
        if (defaultUri != null) {
            eVar.a(defaultUri);
        }
        String zza = zza(bundle, "gcm.n.click_action");
        if (!TextUtils.isEmpty(zza)) {
            launchIntentForPackage = new Intent(zza);
            launchIntentForPackage.setPackage(this.zzdu);
            launchIntentForPackage.setFlags(DriveFile.MODE_READ_ONLY);
        } else {
            Uri zzj = zzj(bundle);
            if (zzj != null) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW");
                launchIntentForPackage.setPackage(this.zzdu);
                launchIntentForPackage.setData(zzj);
            } else {
                launchIntentForPackage = this.zzag.getPackageManager().getLaunchIntentForPackage(this.zzdu);
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        }
        if (launchIntentForPackage == null) {
            activity = null;
        } else {
            launchIntentForPackage.addFlags(67108864);
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.startsWith("google.c.")) {
                    it.remove();
                }
            }
            launchIntentForPackage.putExtras(bundle2);
            for (String str2 : bundle2.keySet()) {
                if (str2.startsWith("gcm.n.") || str2.startsWith("gcm.notification.")) {
                    launchIntentForPackage.removeExtra(str2);
                }
            }
            activity = PendingIntent.getActivity(this.zzag, zzdt.incrementAndGet(), launchIntentForPackage, 1073741824);
            if (zzk(bundle)) {
                Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                zza(intent, bundle);
                intent.putExtra("pending_intent", activity);
                activity = zza(zzdt.incrementAndGet(), intent);
            }
        }
        eVar.a(activity);
        if (zzk(bundle)) {
            Intent intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
            zza(intent2, bundle);
            pendingIntent = zza(zzdt.incrementAndGet(), intent2);
        }
        if (pendingIntent != null) {
            eVar.b(pendingIntent);
        }
        Integer zzl = zzl(zza(bundle, "gcm.n.color"));
        if (zzl != null) {
            eVar.d(zzl.intValue());
        }
        String zza2 = zza(bundle, "gcm.n.tag");
        if (TextUtils.isEmpty(zza2)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("FCM-Notification:");
            sb2.append(uptimeMillis);
            zza2 = sb2.toString();
        }
        return new zzc(eVar, zza2, 0);
    }

    private final CharSequence zzg(Bundle bundle) {
        String zzc = zzc(bundle, "gcm.n.title");
        if (!TextUtils.isEmpty(zzc)) {
            return zzc;
        }
        try {
            return zzc(0).loadLabel(this.zzag.getPackageManager());
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.e("FirebaseMessaging", sb.toString());
            return "";
        }
    }

    public static boolean zzh(Bundle bundle) {
        return "1".equals(zza(bundle, "gcm.n.e")) || zza(bundle, "gcm.n.icon") != null;
    }

    public static String zza(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object[] zzb(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String zza = zza(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(zza);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException unused) {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf("_loc_args");
            String substring = (valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(zza).length());
            sb.append("Malformed ");
            sb.append(substring);
            sb.append(": ");
            sb.append(zza);
            sb.append("  Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
    }

    private final String zzc(Bundle bundle, String str) {
        String zza = zza(bundle, str);
        return !TextUtils.isEmpty(zza) ? zza : zze(bundle, str);
    }

    public static String zzd(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return zza(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private final String zze(Bundle bundle, String str) {
        String zzd = zzd(bundle, str);
        if (TextUtils.isEmpty(zzd)) {
            return null;
        }
        Resources resources = this.zzag.getResources();
        int identifier = resources.getIdentifier(zzd, "string", this.zzdu);
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("_loc_key");
            String substring = (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(str).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(str);
            sb.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
        Object[] zzb = zzb(bundle, str);
        if (zzb == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, zzb);
        } catch (MissingFormatArgumentException e) {
            String arrays = Arrays.toString(zzb);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString(), e);
            return null;
        }
    }

    @TargetApi(26)
    private final boolean zzb(int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.zzag.getResources().getDrawable(i, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    private final int zzk(String str) {
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.zzag.getResources();
            int identifier = resources.getIdentifier(str, "drawable", this.zzdu);
            if (identifier != 0 && zzb(identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str, "mipmap", this.zzdu);
            if (identifier2 != 0 && zzb(identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("Icon resource ");
            sb.append(str);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i = zzap().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !zzb(i)) {
            try {
                i = zzc(0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        return (i == 0 || !zzb(i)) ? android.R.drawable.sym_def_app_icon : i;
    }

    private final Integer zzl(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
                sb.append("Color ");
                sb.append(str);
                sb.append(" not valid. Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = zzap().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(androidx.core.content.a.c(this.zzag, i));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    public static String zzi(Bundle bundle) {
        String zza = zza(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(zza) ? zza(bundle, "gcm.n.sound") : zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri zzj(Bundle bundle) {
        String zza = zza(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(zza)) {
            zza = zza(bundle, "gcm.n.link");
        }
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        return Uri.parse(zza);
    }

    private final synchronized Bundle zzap() {
        if (this.zzdv != null) {
            return this.zzdv;
        }
        try {
            ApplicationInfo zzc = zzc(128);
            if (zzc != null && zzc.metaData != null) {
                this.zzdv = zzc.metaData;
                return this.zzdv;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    private final String zzm(String str) {
        if (!PlatformVersion.isAtLeastO()) {
            return null;
        }
        int i = 0;
        try {
            i = zzc(0).targetSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (i < 26) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.zzag.getSystemService(NotificationManager.class);
        if (!TextUtils.isEmpty(str)) {
            if (notificationManager.getNotificationChannel(str) != null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
            sb.append("Notification Channel requested (");
            sb.append(str);
            sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        String string = zzap().getString("com.google.firebase.messaging.default_notification_channel_id");
        if (!TextUtils.isEmpty(string)) {
            if (notificationManager.getNotificationChannel(string) != null) {
                return string;
            }
            Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
        } else {
            Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
        }
        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") != null) {
            return "fcm_fallback_notification_channel";
        }
        notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.zzag.getString(this.zzag.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", this.zzdu)), 3));
        return "fcm_fallback_notification_channel";
    }

    private final ApplicationInfo zzc(int i) throws PackageManager.NameNotFoundException {
        return this.zzag.getPackageManager().getApplicationInfo(this.zzdu, i);
    }

    private static void zza(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private final PendingIntent zza(int i, Intent intent) {
        return PendingIntent.getBroadcast(this.zzag, i, new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(this.zzag, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }

    private static boolean zzk(Bundle bundle) {
        return bundle != null && "1".equals(bundle.getString("google.c.a.e"));
    }
}
