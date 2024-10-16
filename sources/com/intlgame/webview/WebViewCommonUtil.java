package com.intlgame.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import com.google.android.gms.drive.DriveFile;
import com.intlgame.foundation.INTLLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class WebViewCommonUtil {
    private static final String INTL_WEBVIEW_DEFAULT_URL_KEY_FILTER = "gameid,encodeparam,channelid,nickname,token";
    private static final String INTL_WEBVIEW_URL_KEY_FILTER = "WEBVIEW_URL_KEY_FILTER";

    protected static boolean isLink(String str) {
        for (String str2 : new String[]{"http:", "https:", "file:", "ftp"}) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    protected static boolean isSystemScheme(String str) {
        for (String str2 : new String[]{WebView.SCHEME_MAILTO, "geo:", WebView.SCHEME_TEL, "smsto:"}) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"JavascriptInterface"})
    protected static void initWebViewSettings(final Activity activity, android.webkit.WebView webView) {
        try {
            webView.setDownloadListener(new DownloadListener() { // from class: com.intlgame.webview.WebViewCommonUtil.1
                @Override // android.webkit.DownloadListener
                @SuppressLint({"NewApi"})
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (str != null) {
                        try {
                            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (ActivityNotFoundException unused) {
                            INTLLog.e("default browser is uninstalled!");
                        }
                    }
                }
            });
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.addJavascriptInterface(activity, "INTL");
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
            CookieSyncManager.createInstance(activity);
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            INTLLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        if (isLink(str)) {
            return false;
        }
        INTLLog.i("load other scheme : " + str);
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
                INTLLog.e(e.getMessage());
            }
        }
        return true;
    }

    public static boolean isSystemFullScreenSupport(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return !context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static String getDecodeURL(String str) {
        INTLLog.i("getDecodeURL invoked, url = " + str);
        if (str == null || str.isEmpty()) {
            INTLLog.e("cannot decode illegal URL, URL is empty or null");
            return "";
        }
        if (!str.contains("?")) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        if (INTL_WEBVIEW_DEFAULT_URL_KEY_FILTER != 0 && !INTL_WEBVIEW_DEFAULT_URL_KEY_FILTER.isEmpty()) {
            for (String str2 : INTL_WEBVIEW_DEFAULT_URL_KEY_FILTER.split(",")) {
                arrayList.add(str2.trim());
            }
        } else {
            INTLLog.e("urlKeyFilter not set");
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String path = parse.getPath();
        HashSet<String> hashSet = new HashSet(parse.getQueryParameterNames());
        String fragment = parse.getFragment();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(scheme).authority(authority);
        if (path != null && (path.contains("&") || path.contains("="))) {
            builder.encodedPath(path);
        } else {
            builder.path(path);
        }
        hashSet.removeAll(arrayList);
        for (String str3 : hashSet) {
            builder.appendQueryParameter(str3, parse.getQueryParameter(str3));
        }
        builder.fragment(fragment);
        return builder.build().toString();
    }
}
