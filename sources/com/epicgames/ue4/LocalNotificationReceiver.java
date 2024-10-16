package com.epicgames.ue4;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.h;

/* loaded from: classes.dex */
public class LocalNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("local-notification-ID", 0);
        String stringExtra = intent.getStringExtra("local-notification-title");
        String stringExtra2 = intent.getStringExtra("local-notification-body");
        String stringExtra3 = intent.getStringExtra("local-notification-action");
        if (stringExtra == null || stringExtra2 == null || stringExtra3 == null) {
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) GameActivity.class);
        intent2.setFlags(603979776);
        intent2.putExtra("localNotificationID", intExtra);
        intent2.putExtra("localNotificationAppLaunched", true);
        int identifier = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
        if (identifier == 0) {
            identifier = context.getResources().getIdentifier("icon", "drawable", context.getPackageName());
        }
        PendingIntent activity = PendingIntent.getActivity(context, intExtra, intent2, 0);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            if (notificationManager.getNotificationChannel("PUBG MOBILE") == null) {
                NotificationChannel notificationChannel = new NotificationChannel("PUBG MOBILE", "PUBG MOBILE", 4);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notificationManager.createNotificationChannel(notificationChannel);
            }
            h.e a2 = new h.e(context, "PUBG MOBILE").a(identifier).a(activity).a(System.currentTimeMillis()).b((CharSequence) stringExtra2).a((CharSequence) stringExtra);
            if (Build.VERSION.SDK_INT >= 21) {
                a2.d(-15851965);
            }
            Notification b = a2.b();
            b.flags |= 16;
            b.defaults |= 3;
            notificationManager.notify(intExtra, b);
            return;
        }
        h.e a3 = new h.e(context).a(identifier).a(activity).a(System.currentTimeMillis()).b((CharSequence) stringExtra2).a((CharSequence) stringExtra);
        if (Build.VERSION.SDK_INT >= 21) {
            a3.d(-15851965);
        }
        Notification b2 = a3.b();
        b2.flags |= 16;
        b2.defaults |= 3;
        notificationManager.notify(intExtra, b2);
    }
}
