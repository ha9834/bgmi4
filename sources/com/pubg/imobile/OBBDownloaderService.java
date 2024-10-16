package com.pubg.imobile;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;

/* loaded from: classes2.dex */
public class OBBDownloaderService extends DownloaderService {
    private static final byte[] g = {1, 43, -12, -1, 54, 98, -100, -12, 43, 2, -8, -4, 9, 5, -106, -108, -33, 45, -1, 84};

    public static int n() {
        return 392;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public String g() {
        return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlxAPeEJ0YGlshl7rbe71oa4shtkqRSv0Pd70jhxC52/zim2IuQoSOtxcJNXKhg3CFqviDoNv860+FJ149ErtJFEGsm/jGJBDLQWMZrRezl+EEDuHVczWlUBPqogsnmrGOcGFecgmU/ramrXNPwcw9F2its1qWw3bQUZ/myBZwcvWG4qjXB/wVxhwxpxrHwLDN0bMRiRl8AWyris9k1/xL3BU1Vrz9izAeLDa925lcSxru7K+nqGuiDHli1ou4qo/QTTttK7rWd3x+8hXc+1QuQRkH5ThdrZk2EDnK46S4DRScGMFibhb2Voc4Y2tuRZxxpkjUSilkajH78xKk2Cq+wIDAQAB";
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public byte[] h() {
        return g;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public String i() {
        return AlarmReceiver.class.getName();
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    protected void j() {
        int identifier = getResources().getIdentifier("notification_icon", "drawable", getPackageName());
        if (identifier == 0) {
            identifier = getResources().getIdentifier("icon", "drawable", getPackageName());
        }
        Notification.Builder contentText = new Notification.Builder(this).setSmallIcon(identifier).setContentTitle("Download OBB Service").setContentText("Download obb service is running");
        contentText.setChannelId("DownladObbId");
        Notification build = contentText.build();
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("DownladObbId", "Download OBB", 4));
        startForeground(1, build);
    }
}
