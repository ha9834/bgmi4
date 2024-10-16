package com.helpshift.support.webkit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class CustomWebViewClient extends WebViewClient {
    public static final String TAG = "CustomWebViewClient";
    private Context context;
    private final CustomWebViewClientListeners customWebViewClientListeners;

    /* loaded from: classes2.dex */
    public interface CustomWebViewClientListeners {
        void onPageFinished();

        void onPageStarted();
    }

    public CustomWebViewClient(Context context, CustomWebViewClientListeners customWebViewClientListeners) {
        this.customWebViewClientListeners = customWebViewClientListeners;
        this.context = context;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT < 24 || !handleUrlClick(webView, webResourceRequest.getUrl().toString())) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 24 || !handleUrlClick(webView, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }

    private boolean handleUrlClick(WebView webView, String str) {
        Context context = webView.getContext();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri parse = Uri.parse(trim);
        intent.setData(parse);
        try {
            pushFAQDeeplinkClickEvent(trim, parse.getScheme());
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            HSLogger.d(TAG, "Unable to resolve activity", e);
            return false;
        }
    }

    private void pushFAQDeeplinkClickEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsEventKey.PROTOCOL, str2);
        hashMap.put(AnalyticsEventKey.URL, str);
        HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.LINK_VIA_FAQ, hashMap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.customWebViewClientListeners.onPageStarted();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.customWebViewClientListeners.onPageFinished();
    }

    private WebResourceResponse interceptRequest(String str) {
        URL url;
        File externalCacheDir = this.context.getExternalCacheDir();
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            HSLogger.d(TAG, "MalformedURLException", e);
            url = null;
        }
        if (url != null) {
            File file = new File(externalCacheDir, str.replace("/", EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR));
            if (file.exists()) {
                try {
                    return new WebResourceResponse("", "", new FileInputStream(file));
                } catch (FileNotFoundException e2) {
                    HSLogger.w(TAG, "FileNotFoundException", e2);
                }
            } else if (AndroidFileUtil.isSupportedMimeType(AndroidFileUtil.getMimeType(url))) {
                AndroidFileUtil.saveFile(url, file);
            }
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse interceptRequest;
        return (Build.VERSION.SDK_INT < 21 || (interceptRequest = interceptRequest(webResourceRequest.getUrl().toString())) == null) ? super.shouldInterceptRequest(webView, webResourceRequest) : interceptRequest;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse interceptRequest;
        return (Build.VERSION.SDK_INT >= 21 || (interceptRequest = interceptRequest(str)) == null) ? super.shouldInterceptRequest(webView, str) : interceptRequest;
    }
}
