package com.ihoc.mgpa.download;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.ihoc.mgpa.g.o;
import com.ihoc.mgpa.n.a;
import com.ihoc.mgpa.n.h;
import com.ihoc.mgpa.n.k;
import com.ihoc.mgpa.n.m;

/* loaded from: classes2.dex */
public class BgDownloadService extends Service implements k.a {
    private static final String DOWNLOAD_CHANNEL = "tgpa_download";
    private static final int NOTIFY_ID = 102;
    public static final String STATE_ICON = "update_icon";
    public static final String STATE_PROGRESS = "update_progress";
    public static final String STATE_TITLE = "update_title";
    private static final String TAG = "TGPA_BgDownloadService";
    private NotificationManager mNotificationManager;
    private String mNotificationTitle = "";
    private int mNotificationIcon = 0;
    private int mNotificationProgress = 0;
    private boolean mIsCloseNotifyInFore = false;
    private boolean mIsAppForeground = true;
    private volatile boolean mIsStartForeground = false;

    /* loaded from: classes2.dex */
    public class BgDownloadServiceLocalBinder extends Binder {
        public BgDownloadServiceLocalBinder() {
        }

        public void bringServiceToForeground(String str, int i) {
            BgDownloadService.this.mNotificationTitle = str;
            BgDownloadService.this.mNotificationProgress = i;
            BgDownloadService.this.prepareAndStartForeground();
        }

        public boolean isStartForeground() {
            return BgDownloadService.this.mIsStartForeground;
        }
    }

    private Class<?> getGameCurrentActivity() {
        Activity a2 = h.a();
        return a2 != null ? a2.getClass() : a.d();
    }

    private boolean hasNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.mNotificationManager.areNotificationsEnabled();
        }
        return true;
    }

    private void hideNotification() {
        safeStopForeground();
        this.mNotificationManager.cancel(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAndStartForeground() {
        if (this.mNotificationManager == null) {
            this.mNotificationManager = (NotificationManager) getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationManager.createNotificationChannel(new NotificationChannel(DOWNLOAD_CHANNEL, DOWNLOAD_CHANNEL, 2));
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Notification prepareNotification = prepareNotification();
            if (prepareNotification == null) {
                prepareNotification = prepareNotification();
            }
            safeStartForeground(102, prepareNotification);
        }
    }

    private Notification prepareNotification() {
        int i = Build.VERSION.SDK_INT;
        if (i < 16) {
            return null;
        }
        try {
            Notification.Builder builder = i >= 26 ? new Notification.Builder(this, DOWNLOAD_CHANNEL) : new Notification.Builder(this);
            Notification.Builder smallIcon = builder.setAutoCancel(true).setSmallIcon(this.mNotificationIcon);
            StringBuilder sb = new StringBuilder();
            sb.append(this.mNotificationProgress);
            sb.append("%");
            smallIcon.setContentText(sb.toString()).setContentTitle(this.mNotificationTitle).setProgress(100, this.mNotificationProgress, false);
            Class<?> gameCurrentActivity = getGameCurrentActivity();
            if (gameCurrentActivity != null) {
                builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, gameCurrentActivity), Build.VERSION.SDK_INT >= 23 ? 67108864 : 134217728));
            }
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setGroupSummary(false).setGroup(DOWNLOAD_CHANNEL);
            }
            return builder.build();
        } catch (Exception unused) {
            m.a(TAG, "prepare notification exception, ple try it again!");
            return null;
        }
    }

    private void safeStartForeground(int i, Notification notification) {
        if (this.mIsStartForeground) {
            return;
        }
        if (notification == null) {
            m.b(TAG, "notification is null to skip startForeground.");
            return;
        }
        try {
            startForeground(i, notification);
            this.mIsStartForeground = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void safeStopForeground() {
        if (this.mIsStartForeground) {
            stopForeground(true);
            this.mIsStartForeground = false;
        }
    }

    private void showNotification(int i) {
        if (i < DownloadState.START.state || this.mNotificationProgress > DownloadState.FINISH.state || (this.mIsCloseNotifyInFore && k.a((Context) this).b())) {
            hideNotification();
        } else {
            updateNotification();
        }
    }

    private void updateNotification() {
        Notification prepareNotification;
        if (Build.VERSION.SDK_INT < 16 || !hasNotificationPermission() || (prepareNotification = prepareNotification()) == null) {
            return;
        }
        this.mNotificationManager.notify(102, prepareNotification);
    }

    @Override // com.ihoc.mgpa.n.k.a
    public void onBecameBackground() {
        this.mIsAppForeground = false;
        int i = this.mNotificationProgress;
        if (i < DownloadState.START.state || i >= DownloadState.FINISH.state) {
            return;
        }
        showNotification(i);
    }

    @Override // com.ihoc.mgpa.n.k.a
    public void onBecameForeground() {
        this.mIsAppForeground = true;
        if (this.mIsCloseNotifyInFore || this.mNotificationProgress == DownloadState.FINISH.state) {
            hideNotification();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new BgDownloadServiceLocalBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        this.mNotificationIcon = getApplicationContext().getApplicationInfo().icon;
        this.mIsCloseNotifyInFore = o.b().b.P;
        prepareAndStartForeground();
        k.a((Context) this).a((k.a) this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        hideNotification();
        k.a((Context) this).b(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        prepareAndStartForeground();
        if (intent == null) {
            return 2;
        }
        try {
            this.mNotificationTitle = intent.getStringExtra("update_title");
            this.mNotificationIcon = intent.getIntExtra("update_icon", 0);
            this.mNotificationProgress = intent.getIntExtra("update_progress", 0);
            StringBuilder sb = new StringBuilder();
            sb.append("onStartCommand mNotificationProgress: ");
            sb.append(this.mNotificationProgress);
            m.a(TAG, sb.toString());
            showNotification(this.mNotificationProgress);
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
            m.a(TAG, "onStartCommand create notification exception!");
            return 2;
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        hideNotification();
        stopSelf();
    }
}
