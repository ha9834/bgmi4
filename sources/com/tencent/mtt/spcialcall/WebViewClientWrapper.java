package com.tencent.mtt.spcialcall;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.DownloadListener;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.mtt.spcialcall.sdk.MttApi;
import com.tencent.mtt.spcialcall.sdk.RecommendParams;

/* loaded from: classes.dex */
public class WebViewClientWrapper extends WebViewClient {
    private WebViewClient mClient;
    private DownloadListener mDownloadListener;
    private boolean mInjectRecomend;
    private RecommendParams mRecomendParams = new RecommendParams();

    public void setWebViewClient(WebViewClient webViewClient) {
        this.mClient = webViewClient;
    }

    public void setInjectRecommend(boolean z) {
        this.mInjectRecomend = z;
    }

    public void setFromType(int i) {
        this.mRecomendParams.put("from", new StringBuilder(String.valueOf(i)).toString());
    }

    public void setUin(String str) {
        this.mRecomendParams.put(RecommendParams.KEY_UIN, str);
    }

    public void setPublicAccountUin(String str) {
        this.mRecomendParams.put(RecommendParams.KEY_PUB_UIN, str);
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("http://mdc.html5.qq.com/d/directdown.jsp") && this.mDownloadListener != null) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebViewClient(new WebViewClient());
            webView2.setDownloadListener(this.mDownloadListener);
            webView2.loadUrl(str);
            return true;
        }
        WebViewClient webViewClient = this.mClient;
        boolean shouldOverrideUrlLoading = webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, str) : false;
        if (!shouldOverrideUrlLoading) {
            this.mRecomendParams.put(RecommendParams.KEY_REFFER, webView.getUrl());
        }
        return shouldOverrideUrlLoading;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
        if (this.mInjectRecomend) {
            MttApi.insertRecommend(webView, this.mRecomendParams);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f, f2);
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient = this.mClient;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }
}
