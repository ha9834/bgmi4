package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class zzb {
    private final Context zzag;
    private final Bundle zzco;
    private final Executor zzdy;
    private final zza zzdz;

    public zzb(Context context, Bundle bundle, Executor executor) {
        this.zzdy = executor;
        this.zzag = context;
        this.zzco = bundle;
        this.zzdz = new zza(context, context.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzas() {
        /*
            r9 = this;
            java.lang.String r0 = "1"
            android.os.Bundle r1 = r9.zzco
            java.lang.String r2 = "gcm.n.noui"
            java.lang.String r1 = com.google.firebase.messaging.zza.zza(r1, r2)
            boolean r0 = r0.equals(r1)
            r1 = 1
            if (r0 == 0) goto L12
            return r1
        L12:
            android.content.Context r0 = r9.zzag
            java.lang.String r2 = "keyguard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.app.KeyguardManager r0 = (android.app.KeyguardManager) r0
            boolean r0 = r0.inKeyguardRestrictedInputMode()
            r2 = 0
            if (r0 != 0) goto L60
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastLollipop()
            if (r0 != 0) goto L2e
            r3 = 10
            android.os.SystemClock.sleep(r3)
        L2e:
            int r0 = android.os.Process.myPid()
            android.content.Context r3 = r9.zzag
            java.lang.String r4 = "activity"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3
            java.util.List r3 = r3.getRunningAppProcesses()
            if (r3 == 0) goto L60
            java.util.Iterator r3 = r3.iterator()
        L46:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L60
            java.lang.Object r4 = r3.next()
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r5 = r4.pid
            if (r5 != r0) goto L46
            int r0 = r4.importance
            r3 = 100
            if (r0 != r3) goto L5e
            r0 = 1
            goto L61
        L5e:
            r0 = 0
            goto L61
        L60:
            r0 = 0
        L61:
            if (r0 == 0) goto L64
            return r2
        L64:
            android.os.Bundle r0 = r9.zzco
            java.lang.String r3 = "gcm.n.image"
            java.lang.String r0 = com.google.firebase.messaging.zza.zza(r0, r3)
            com.google.firebase.messaging.zze r0 = com.google.firebase.messaging.zze.zzo(r0)
            if (r0 == 0) goto L77
            java.util.concurrent.Executor r3 = r9.zzdy
            r0.zza(r3)
        L77:
            com.google.firebase.messaging.zza r3 = r9.zzdz
            android.os.Bundle r4 = r9.zzco
            com.google.firebase.messaging.zzc r3 = r3.zzf(r4)
            androidx.core.app.h$e r4 = r3.zzea
            if (r0 == 0) goto Lc4
            com.google.android.gms.tasks.Task r5 = r0.getTask()     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            r6 = 5
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            java.lang.Object r5 = com.google.android.gms.tasks.Tasks.await(r5, r6, r8)     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            r4.a(r5)     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            androidx.core.app.h$b r6 = new androidx.core.app.h$b     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            r6.<init>()     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            androidx.core.app.h$b r5 = r6.a(r5)     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            r6 = 0
            androidx.core.app.h$b r5 = r5.b(r6)     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            r4.a(r5)     // Catch: java.util.concurrent.TimeoutException -> La6 java.lang.InterruptedException -> Lb1 java.util.concurrent.ExecutionException -> Lc3
            goto Lc4
        La6:
            java.lang.String r4 = "FirebaseMessaging"
            java.lang.String r5 = "Failed to download image in time, showing notification without it"
            android.util.Log.w(r4, r5)
            r0.close()
            goto Lc4
        Lb1:
            java.lang.String r4 = "FirebaseMessaging"
            java.lang.String r5 = "Interrupted while downloading image, showing notification without it"
            android.util.Log.w(r4, r5)
            r0.close()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto Lc4
        Lc3:
        Lc4:
            java.lang.String r0 = "FirebaseMessaging"
            r4 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r4)
            if (r0 == 0) goto Ld4
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r4 = "Showing notification"
            android.util.Log.d(r0, r4)
        Ld4:
            android.content.Context r0 = r9.zzag
            java.lang.String r4 = "notification"
            java.lang.Object r0 = r0.getSystemService(r4)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            java.lang.String r4 = r3.tag
            androidx.core.app.h$e r3 = r3.zzea
            android.app.Notification r3 = r3.b()
            r0.notify(r4, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzb.zzas():boolean");
    }
}
