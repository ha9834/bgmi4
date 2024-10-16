package com.tencent.imsdk.android.webview.qq;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* loaded from: classes.dex */
public class FloatWebViewClient extends WebViewClient {
    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return WebViewCommonUtil.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }
}
