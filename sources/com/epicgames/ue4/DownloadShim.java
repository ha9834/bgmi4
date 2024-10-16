package com.epicgames.ue4;

import android.app.Activity;
import android.content.Context;
import com.google.android.vending.expansion.downloader.d;
import com.pubg.imobile.DownloaderActivity;
import com.pubg.imobile.OBBDownloaderService;
import com.pubg.imobile.a;

/* loaded from: classes.dex */
public class DownloadShim {
    public static DownloaderActivity DownloadActivity;
    public static OBBDownloaderService DownloaderService;

    public static Class<DownloaderActivity> GetDownloaderType() {
        return DownloaderActivity.class;
    }

    public static boolean expansionFilesDelivered(Activity activity) {
        for (a.C0146a c0146a : a.f5766a) {
            String a2 = d.a(activity, c0146a.f5767a, c0146a.b);
            GameActivity.Log.debug("Checking for file : " + a2);
            String a3 = d.a(activity, a2);
            String b = d.b(activity, a2);
            GameActivity.Log.debug("which is really being resolved to : " + a3 + "\n Or : " + b);
            if (d.a((Context) activity, a2, c0146a.c, false)) {
                GameActivity.Log.debug("Found OBB here: " + a3);
            } else {
                if (!d.b(activity, a2, c0146a.c, false)) {
                    return false;
                }
                GameActivity.Log.debug("Found OBB here: " + b);
            }
        }
        return true;
    }
}
