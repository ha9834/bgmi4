package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.iid.zzau;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public class FirebaseMessagingService extends com.google.firebase.iid.zzc {
    private static final Queue<String> zzeb = new ArrayDeque(10);

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    @Override // com.google.firebase.iid.zzc
    protected final Intent zzb(Intent intent) {
        return zzau.zzai().zzaj();
    }

    @Override // com.google.firebase.iid.zzc
    public final boolean zzc(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!MessagingAnalytics.shouldUploadMetrics(intent)) {
            return true;
        }
        MessagingAnalytics.logNotificationOpen(intent);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f7, code lost:
    
        if (r0.equals("send_event") == false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015b  */
    @Override // com.google.firebase.iid.zzc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.zzd(android.content.Intent):void");
    }
}
