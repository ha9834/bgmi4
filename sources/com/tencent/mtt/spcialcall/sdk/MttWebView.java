package com.tencent.mtt.spcialcall.sdk;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.mtt.spcialcall.WebViewClientWrapper;

/* loaded from: classes.dex */
public class MttWebView extends WebView {
    private WebViewClientWrapper mWebViewClient;

    public MttWebView(Context context) {
        super(context);
        init();
    }

    public MttWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mWebViewClient = new WebViewClientWrapper();
        super.setWebViewClient(this.mWebViewClient);
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient != null) {
            this.mWebViewClient.setWebViewClient(webViewClient);
        }
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener downloadListener) {
        this.mWebViewClient.setDownloadListener(downloadListener);
        super.setDownloadListener(downloadListener);
    }

    public void setInjectRecommend(boolean z) {
        this.mWebViewClient.setInjectRecommend(z);
    }

    public void setFromType(int i) {
        this.mWebViewClient.setFromType(i);
    }

    public void setUin(String str) {
        this.mWebViewClient.setUin(str);
    }

    public void setPublicAccountUin(String str) {
        this.mWebViewClient.setPublicAccountUin(str);
    }
}
