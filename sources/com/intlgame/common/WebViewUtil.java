package com.intlgame.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.intlgame.INTLApp;
import com.intlgame.foundation.INTLLog;

/* loaded from: classes2.dex */
public class WebViewUtil {
    public static final String WEBVIEW_CHANNEL = "INTLWebView";
    public static final String WEBVIEW_PLugin = "INTLWebView";
    private static ComponentName keepAliveComponentName;
    private static Intent keepAliveIntent;

    public static void initialize(String str) {
    }

    public static void startKeepAliveService() {
        Context appContext = INTLApp.getInstance().getAppContext();
        if (keepAliveComponentName == null && appContext != null) {
            try {
                keepAliveIntent = new Intent(appContext, (Class<?>) ForegroundService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    keepAliveComponentName = appContext.startForegroundService(keepAliveIntent);
                } else {
                    keepAliveComponentName = appContext.startService(keepAliveIntent);
                }
            } catch (Exception e) {
                INTLLog.e("ForegroundService start failed : " + e);
            }
            INTLLog.i("ForegroundService [" + keepAliveComponentName + "] is started !!!");
            return;
        }
        INTLLog.i("ForegroundService [" + keepAliveComponentName + "] is existed !!!");
    }

    public static void stopKeepAliveService() {
        Context appContext = INTLApp.getInstance().getAppContext();
        Intent intent = keepAliveIntent;
        if (intent != null && keepAliveComponentName != null && appContext != null) {
            try {
                appContext.stopService(intent);
            } catch (Exception e) {
                INTLLog.e("ForegroundService stop failed : " + e);
            }
        }
        keepAliveIntent = null;
    }

    public static void clearKeepAliveComponentName() {
        keepAliveComponentName = null;
    }
}
