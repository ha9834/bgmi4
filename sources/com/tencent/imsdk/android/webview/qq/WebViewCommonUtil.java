package com.tencent.imsdk.android.webview.qq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.drive.DriveFile;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.webview.qq.notch.IMSDKNotch;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.uqm.crashsight.CrashSight;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class WebViewCommonUtil {
    protected static final String IMSDK_WEBVIEW_LINK_SCHEMES = "IMSDK_WEBVIEW_LINK_SCHEMES";
    protected static final String IMSDK_WEBVIEW_SYSTEM_SCHEMES = "IMSDK_WEBVIEW_SYSTEM_SCHEMES";
    private static final String IMSDK_WEBVIEW_X5_UPLOAD = "IMSDK_WEBVIEW_QQ_X5_UPLOAD";

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isLink(String str) {
        try {
            JSONArray jSONArray = new JSONArray(IMSDKConfig.getOrMetaData(IMSDK_WEBVIEW_LINK_SCHEMES, IMSDK_WEBVIEW_LINK_SCHEMES, "[]"));
            jSONArray.put("http:").put("https:").put("file:").put("ftp:").put("about:");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str.startsWith(jSONArray.getString(i))) {
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            IMLogger.e(e.getMessage(), new Object[0]);
            return false;
        }
    }

    protected static boolean isSystemScheme(String str) {
        try {
            JSONArray jSONArray = new JSONArray(IMSDKConfig.getOrMetaData(IMSDK_WEBVIEW_SYSTEM_SCHEMES, IMSDK_WEBVIEW_SYSTEM_SCHEMES, "[]"));
            jSONArray.put(WebView.SCHEME_MAILTO).put("geo:").put(WebView.SCHEME_TEL).put("smsto:");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str.startsWith(jSONArray.getString(i))) {
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            IMLogger.e(e.getMessage(), new Object[0]);
            return false;
        }
    }

    protected static boolean getX5UploadFlag() {
        boolean orMetaData = IMSDKConfig.getOrMetaData(IMSDK_WEBVIEW_X5_UPLOAD, IMSDK_WEBVIEW_X5_UPLOAD, false);
        IMLogger.d("getX5UploadFlag isX5Upload = " + orMetaData);
        return orMetaData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getX5WorkFlag() {
        boolean orMetaData = IMSDKConfig.getOrMetaData(IR.meta.IMSDK_WEBVIEW_X5_WORK, IR.meta.IMSDK_WEBVIEW_X5_WORK, false);
        IMLogger.d("getX5WorkFlag isX5Work = " + orMetaData);
        return orMetaData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void initX5Environment(Context context, boolean z) {
        if (!getX5UploadFlag()) {
            HashMap hashMap = new HashMap();
            hashMap.put(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD, CrashSight.SDK_IS_DEV);
            QbSdk.initTbsSettings(hashMap);
            IMLogger.d("KEY_SET_SENDREQUEST_AND_UPLOAD = false");
        }
        if (!z) {
            QbSdk.forceSysWebView();
            IMLogger.d("initWebView with system core!");
        } else {
            IMLogger.d("initWebView with X5 core!");
        }
        QbSdk.initX5Environment(context, new QbSdk.PreInitCallback() { // from class: com.tencent.imsdk.android.webview.qq.WebViewCommonUtil.1
            @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
            public void onCoreInitFinished() {
                IMLogger.d("Qbsdk onCoreInitFinished");
            }

            @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
            public void onViewInitFinished(boolean z2) {
                IMLogger.d("Qbsdk onViewInitFinished : " + z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void initWebViewSettings(final Activity activity, WebView webView) {
        try {
            webView.setDownloadListener(new DownloadListener() { // from class: com.tencent.imsdk.android.webview.qq.WebViewCommonUtil.2
                @Override // com.tencent.smtt.sdk.DownloadListener
                @SuppressLint({"NewApi"})
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (str != null) {
                        try {
                            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (ActivityNotFoundException unused) {
                            IMLogger.e("default browser is uninstalled!", new Object[0]);
                        }
                    }
                }
            });
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.addJavascriptInterface(activity, IR.def.IMSDK_KEYWORD);
            webView.addJavascriptInterface(new IMSDKNotch(), "IMSDKNotch");
            if (Build.VERSION.SDK_INT >= 21) {
                IMLogger.d("setAcceptThirdPartyCookies = true");
                CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            }
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setSupportMultipleWindows(false);
            settings.setTextZoom(100);
            if (Build.VERSION.SDK_INT >= 11) {
                settings.setDisplayZoomControls(false);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(2);
            }
            settings.setLoadWithOverviewMode(true);
            settings.setAppCacheEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setAppCacheMaxSize(Long.MAX_VALUE);
            settings.setAppCachePath(activity.getDir("appcache", 0).getPath());
            settings.setDatabasePath(activity.getDir("databases", 0).getPath());
            settings.setGeolocationDatabasePath(activity.getDir("geolocation", 0).getPath());
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (webView.getX5WebViewExtension() != null) {
                IMLogger.d("CoreVersion getX5WebViewExtension QQBrowserVersion : " + webView.getX5WebViewExtension().getQQBrowserVersion());
            } else {
                IMLogger.d("CoreVersion getX5WebViewExtension null");
            }
            CookieSyncManager.createInstance(activity);
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (isLink(str)) {
            return false;
        }
        IMLogger.d("load other scheme : " + str);
        if (isSystemScheme(str)) {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } else {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.setFlags(DriveFile.MODE_READ_WRITE);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                if (Build.VERSION.SDK_INT >= 15) {
                    parseUri.setSelector(null);
                }
                webView.getContext().startActivity(parseUri);
            } catch (Exception e) {
                IMLogger.e(e.getMessage(), new Object[0]);
                return false;
            }
        }
        return true;
    }
}
