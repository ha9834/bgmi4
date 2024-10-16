package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.b.g;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzau {
    private static zzau zzdd;

    @GuardedBy("serviceClassNames")
    private final g<String, String> zzde = new g<>();
    private Boolean zzdf = null;
    private Boolean zzdg = null;
    final Queue<Intent> zzdh = new ArrayDeque();
    private final Queue<Intent> zzdi = new ArrayDeque();

    public static synchronized zzau zzai() {
        zzau zzauVar;
        synchronized (zzau.class) {
            if (zzdd == null) {
                zzdd = new zzau();
            }
            zzauVar = zzdd;
        }
        return zzauVar;
    }

    private zzau() {
    }

    public static void zzb(Context context, Intent intent) {
        context.sendBroadcast(zza(context, "com.google.firebase.INSTANCE_ID_EVENT", intent));
    }

    public static void zzc(Context context, Intent intent) {
        context.sendBroadcast(zza(context, "com.google.firebase.MESSAGING_EVENT", intent));
    }

    private static Intent zza(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) FirebaseInstanceIdReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    public final Intent zzaj() {
        return this.zzdi.poll();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0048. Please report as an issue. */
    public final int zzb(Context context, String str, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Starting service: ".concat(valueOf) : new String("Starting service: "));
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -842411455) {
            if (hashCode == 41532704 && str.equals("com.google.firebase.MESSAGING_EVENT")) {
                c = 1;
            }
        } else if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
            c = 0;
        }
        switch (c) {
            case 0:
                this.zzdh.offer(intent);
                Intent intent2 = new Intent(str);
                intent2.setPackage(context.getPackageName());
                return zzd(context, intent2);
            case 1:
                this.zzdi.offer(intent);
                Intent intent22 = new Intent(str);
                intent22.setPackage(context.getPackageName());
                return zzd(context, intent22);
            default:
                String valueOf2 = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf2.length() != 0 ? "Unknown service action: ".concat(valueOf2) : new String("Unknown service action: "));
                return 500;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00de A[Catch: IllegalStateException -> 0x00fc, SecurityException -> 0x0124, TryCatch #4 {IllegalStateException -> 0x00fc, SecurityException -> 0x0124, blocks: (B:34:0x00d8, B:36:0x00de, B:38:0x00f0, B:42:0x00e3), top: B:33:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f0 A[Catch: IllegalStateException -> 0x00fc, SecurityException -> 0x0124, TRY_LEAVE, TryCatch #4 {IllegalStateException -> 0x00fc, SecurityException -> 0x0124, blocks: (B:34:0x00d8, B:36:0x00de, B:38:0x00f0, B:42:0x00e3), top: B:33:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3 A[Catch: IllegalStateException -> 0x00fc, SecurityException -> 0x0124, TryCatch #4 {IllegalStateException -> 0x00fc, SecurityException -> 0x0124, blocks: (B:34:0x00d8, B:36:0x00de, B:38:0x00f0, B:42:0x00e3), top: B:33:0x00d8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzd(android.content.Context r6, android.content.Intent r7) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzau.zzd(android.content.Context, android.content.Intent):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(Context context) {
        if (this.zzdf == null) {
            this.zzdf = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.zzdf.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.zzdf.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zze(Context context) {
        if (this.zzdg == null) {
            this.zzdg = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.zzdf.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.zzdg.booleanValue();
    }
}
