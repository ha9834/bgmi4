package com.tencent.smtt.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import com.tencent.smtt.sdk.WebSettings;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b {
    public static void a(final Context context, WebView webView) {
        Log.i("MsdkInit", "MsdkInit start");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(false);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setAppCachePath(context.getDir("appcache", 0).getPath());
        settings.setDatabasePath(context.getDir("databases", 0).getPath());
        settings.setGeolocationDatabasePath(context.getDir("geolocation", 0).getPath());
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 11) {
            settings.setDisplayZoomControls(false);
        }
        CookieSyncManager.createInstance(context);
        CookieSyncManager.getInstance().sync();
        webView.setDownloadListener(new DownloadListener() { // from class: com.tencent.smtt.sdk.b.1
            @Override // com.tencent.smtt.sdk.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(DriveFile.MODE_READ_ONLY);
                    context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Log.e("MsdkInit", "default browser is uninstalled!");
                }
            }
        });
        Log.i("MsdkInit", "MsdkInit end");
    }
}
