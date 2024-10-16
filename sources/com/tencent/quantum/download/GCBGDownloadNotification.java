package com.tencent.quantum.download;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.app.h;

/* loaded from: classes.dex */
public class GCBGDownloadNotification {
    public static final String NOTIFICATION_CHANNEL_NAME = "Downloader";
    private h.e mActiveDownloadBuilder;
    private h.e mBuilder;
    private Context mContext;
    private h.e mCurrentBuilder;
    private NotificationMode mCurrentMode;
    private NotificationManager mNotificationManager;
    private CharSequence mTitle;
    public static final String NOTIFICATION_CHANNEL_ID = "service.notify";
    static final int NOTIFICATION_ID = NOTIFICATION_CHANNEL_ID.hashCode();

    /* loaded from: classes.dex */
    public enum NotificationMode {
        PROGRESS,
        TEXT
    }

    public GCBGDownloadNotification(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.mTitle = charSequence;
        String str = context.getPackageName() + "." + NOTIFICATION_CHANNEL_ID;
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannel(new NotificationChannel(str, NOTIFICATION_CHANNEL_NAME, 2));
        }
        this.mActiveDownloadBuilder = new h.e(context, str);
        this.mActiveDownloadBuilder.c(-1);
        this.mActiveDownloadBuilder.a("progress");
        String str2 = context.getPackageName() + "." + NOTIFICATION_CHANNEL_ID + ".finish";
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannel(new NotificationChannel(str2, NOTIFICATION_CHANNEL_NAME, 3));
        }
        this.mBuilder = new h.e(context, str2);
        this.mBuilder.c(1);
        this.mBuilder.a("progress");
        this.mBuilder.b(10);
        this.mCurrentBuilder = this.mBuilder;
        this.mCurrentMode = NotificationMode.TEXT;
    }

    public void onDownloadProgress(String str, long j, long j2) {
        Notification b;
        switch (this.mCurrentMode) {
            case TEXT:
                this.mCurrentBuilder = getNormalDescriptionNotify(str);
                b = this.mCurrentBuilder.b();
                if (Build.VERSION.SDK_INT >= 21) {
                    b.visibility = 1;
                    break;
                }
                break;
            case PROGRESS:
                this.mActiveDownloadBuilder.a((int) j2, (int) j, false);
                this.mActiveDownloadBuilder.b((CharSequence) str);
                this.mActiveDownloadBuilder.a(getDrawableId(this.mContext, "notification_icon"));
                this.mActiveDownloadBuilder.d(this.mTitle);
                this.mActiveDownloadBuilder.a(this.mTitle);
                this.mCurrentBuilder = this.mActiveDownloadBuilder;
                b = this.mCurrentBuilder.b();
                break;
            default:
                b = null;
                break;
        }
        if (b != null) {
            this.mNotificationManager.notify(NOTIFICATION_ID, b);
        }
    }

    public h.e getNormalDescriptionNotify(String str) {
        this.mBuilder.d(this.mTitle);
        this.mBuilder.a(getDrawableId(this.mContext, "notification_icon"));
        this.mBuilder.a(this.mTitle);
        this.mBuilder.b((CharSequence) str);
        return this.mBuilder;
    }

    public void swithMode(NotificationMode notificationMode) {
        this.mCurrentMode = notificationMode;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        h.e eVar = this.mActiveDownloadBuilder;
        if (eVar != null) {
            eVar.a(pendingIntent);
            this.mBuilder.a(pendingIntent);
        }
    }

    public static int getDrawableId(Context context, String str) {
        if (context != null) {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        }
        return 0;
    }

    public static Drawable getDrawable(Context context, String str) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        int drawableId = getDrawableId(context, str);
        if (drawableId != 0) {
            return resources.getDrawable(drawableId);
        }
        return null;
    }
}
