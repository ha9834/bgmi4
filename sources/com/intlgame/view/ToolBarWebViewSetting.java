package com.intlgame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.intlgame.api.compliance.INTLCompliance;
import com.intlgame.foundation.EmptyUtils;
import com.intlgame.foundation.INTLLog;
import com.intlgame.webview.WebViewManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ToolBarWebViewSetting {
    private static Boolean getJsonBoolean(String str, String str2) {
        if (EmptyUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str2)) {
                return Boolean.valueOf(jSONObject.getBoolean(str2));
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean getBooleanConfig(String str, String str2, boolean z) {
        Boolean jsonBoolean = getJsonBoolean(str2, str);
        return jsonBoolean != null ? jsonBoolean.booleanValue() : z;
    }

    public static boolean isX5Enable(String str) {
        return !getBooleanConfig(WebViewManager.CONFIG_KEY_X5_CLOSE, str, true);
    }

    public static boolean isX5UploadEnable(String str) {
        return getBooleanConfig(WebViewManager.CONFIG_KEY_X5_UPLOAD, str, false);
    }

    public static boolean isPortraitBarEnable(String str) {
        return getBooleanConfig(WebViewManager.CONFIG_KEY_PORTRAIT_HIDEBAR_ENABLE, str, false);
    }

    public static boolean isLandscapeBarEnable(String str) {
        return getBooleanConfig(WebViewManager.CONFIG_KEY_LANDSCAPE_HIDEBAR_ENABLE, str, false);
    }

    public static boolean isFullscreenEnable(String str) {
        return getBooleanConfig(WebViewManager.CONFIG_KEY_FULLSCREEN_ENABLE, str, false);
    }

    public static boolean isToolBarEnable(String str) {
        return getBooleanConfig("WEBVIEW_TOOL_BAR_ENABLE", str, true);
    }

    public static void initWebViewSetting(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(false);
        settings.setDefaultTextEncodingName("UTF-8");
        if (Build.VERSION.SDK_INT >= 11) {
            settings.setDisplayZoomControls(false);
        }
        if (Build.VERSION.SDK_INT > 16) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setCacheMode(-1);
        settings.setAppCachePath(webView.getContext().getDir("webviewxcache", 0).getPath());
        settings.setDatabasePath(webView.getContext().getDir("webviewxcachedatabases", 0).getPath());
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setUserAgentString(" INTLBrowser/1.12.01 (Android; " + INTLCompliance.getConfigString(WebViewManager.INTL_GAME_ID) + ")");
        CookieSyncManager.createInstance(webView.getContext());
        CookieSyncManager.getInstance().sync();
    }

    public static void downloadUrlImage(Context context, String str) {
        INTLLog.i("Save photo from urlStr:" + str);
        if (EmptyUtils.isEmpty(str) || context == null) {
        }
    }

    public static void saveToAlbum(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        INTLLog.i("Save photo to path:" + Uri.fromFile(file).getPath());
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    INTLLog.e(e.getMessage());
                    return;
                }
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            INTLLog.i("Save photo success");
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException unused2) {
            fileOutputStream2 = fileOutputStream;
            INTLLog.e("Save photo failed! fileName:" + file);
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    INTLLog.e(e2.getMessage());
                }
            }
            throw th;
        }
    }
}
