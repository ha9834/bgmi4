package com.pubg.imobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.vending.expansion.downloader.b;

/* loaded from: classes2.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            b.a(context, intent, (Class<?>) OBBDownloaderService.class);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
