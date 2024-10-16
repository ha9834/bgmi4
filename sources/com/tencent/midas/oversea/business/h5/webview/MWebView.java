package com.tencent.midas.oversea.business.h5.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazonaws.services.s3.internal.Constants;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APSPTools;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.MTimer;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import java.util.Map;

/* loaded from: classes.dex */
public class MWebView extends WebView {
    private static final String SP_CACHE_SAVE_TIME = "cachetime";
    public static final String TAG = "MWebView";
    private String APP_CACHE_PATH;
    private Handler _mainHandler;
    private WebChromeClientListener _wccListener;
    private WebViewClientListener _wvcListener;
    private IIntercept intercept;
    private int isCache;
    private boolean isFirstLoad;
    private boolean isIntercept;
    private WebChromeClient mWebChromeClient;
    private WebViewClient mWebViewClient;

    /* loaded from: classes.dex */
    public interface WebChromeClientListener {
        void onJsAlert(String str, String str2, JsResult jsResult);

        void onProgressChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface WebViewClientListener {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str);

        void onRequestError(String str);
    }

    public MWebView(Context context) {
        super(context);
        this.isIntercept = false;
        this.intercept = null;
        this._wccListener = null;
        this._wvcListener = null;
        this._mainHandler = new Handler(Looper.getMainLooper());
        this.isFirstLoad = true;
        this.isCache = 0;
        this.mWebChromeClient = new WebChromeClient() { // from class: com.tencent.midas.oversea.business.h5.webview.MWebView.4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (MWebView.this.isFirstLoad && i == 100) {
                    MTimer.stop(MTimer.SDK_WEBVIEW_PAGE_LOAD);
                    MTimer.stop(MTimer.SDK_WEBVIEW_LOAD);
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_WEBVIEW_END, "time=" + MTimer.duration(MTimer.SDK_WEBVIEW_LOAD) + "&processtime=" + MTimer.duration(MTimer.SDK_WEBVIEW_PROCESS_LOAD) + "&pagetime=" + MTimer.duration(MTimer.SDK_WEBVIEW_PAGE_LOAD) + "&isvisable=" + MTimer.duration(MTimer.SDK_WEBVIEW_DOM_LOAD) + "&isCache=" + MWebView.this.isCache);
                    MWebView.this.webviewReport();
                    MWebView.this.isFirstLoad = false;
                }
                if (MWebView.this._wccListener != null) {
                    MWebView.this._wccListener.onProgressChanged(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (MWebView.this._wccListener != null) {
                    MWebView.this._wccListener.onJsAlert(str, str2, jsResult);
                }
                jsResult.cancel();
                return true;
            }
        };
        this.mWebViewClient = new WebViewClient() { // from class: com.tencent.midas.oversea.business.h5.webview.MWebView.5
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                APLog.d(MWebView.TAG, "onPageStarted url: " + str);
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageCommitVisible(WebView webView, String str) {
                super.onPageCommitVisible(webView, str);
                APLog.d(MWebView.TAG, "onPageCommitVisible url: " + str);
                if (MWebView.this.isFirstLoad) {
                    MTimer.stop(MTimer.SDK_WEBVIEW_DOM_LOAD);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                APLog.d(MWebView.TAG, "onPageFinished url: " + str);
                super.onPageFinished(webView, str);
                if (MWebView.this.isFirstLoad) {
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_WEBVIEW_LOAD, "");
                    MWebView.this.webviewReport();
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                APLog.i(MWebView.TAG, "shouldOverrideUrlLoading url: " + str);
                if (MWebView.this.isIntercept && MWebView.this.intercept != null && 1 == MWebView.this.intercept.level()) {
                    MWebView.this.intercept.handleUrl(webView, str);
                    return true;
                }
                webView.loadUrl(str);
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                APLog.e(MWebView.TAG, "onReceivedError description: " + str);
                super.onReceivedError(webView, i, str, str2);
                if (MWebView.this.isFirstLoad) {
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_WEBVIEW_ERROR, "");
                    MWebView.this.webviewReport();
                }
                if (MWebView.this._wvcListener != null) {
                    MWebView.this._wvcListener.onRequestError(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                SslCertificate certificate = sslError.getCertificate();
                String url = webView.getUrl();
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedSslError:");
                sb.append(sslError.getPrimaryError());
                sb.append(", cert=");
                sb.append(certificate == null ? Constants.NULL_VERSION_ID : certificate.toString());
                sb.append(", pageUrl=");
                sb.append(url);
                APLog.e(MWebView.TAG, sb.toString());
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                if (MWebView.this._wvcListener != null) {
                    MWebView.this._wvcListener.onRequestError("request error,https ssl error.");
                }
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                Log.d(MWebView.TAG, "shouldInterceptRequest: " + webResourceRequest.getUrl());
                WebResourceResponse queryCache = (MWebView.this.isIntercept && MWebView.this.intercept != null && MWebView.this.intercept.level() == 0) ? MWebView.this.intercept.queryCache(webResourceRequest.getUrl().toString()) : null;
                return queryCache != null ? queryCache : super.shouldInterceptRequest(webView, webResourceRequest);
            }
        };
        init(context);
    }

    public MWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isIntercept = false;
        this.intercept = null;
        this._wccListener = null;
        this._wvcListener = null;
        this._mainHandler = new Handler(Looper.getMainLooper());
        this.isFirstLoad = true;
        this.isCache = 0;
        this.mWebChromeClient = new WebChromeClient() { // from class: com.tencent.midas.oversea.business.h5.webview.MWebView.4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (MWebView.this.isFirstLoad && i == 100) {
                    MTimer.stop(MTimer.SDK_WEBVIEW_PAGE_LOAD);
                    MTimer.stop(MTimer.SDK_WEBVIEW_LOAD);
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_WEBVIEW_END, "time=" + MTimer.duration(MTimer.SDK_WEBVIEW_LOAD) + "&processtime=" + MTimer.duration(MTimer.SDK_WEBVIEW_PROCESS_LOAD) + "&pagetime=" + MTimer.duration(MTimer.SDK_WEBVIEW_PAGE_LOAD) + "&isvisable=" + MTimer.duration(MTimer.SDK_WEBVIEW_DOM_LOAD) + "&isCache=" + MWebView.this.isCache);
                    MWebView.this.webviewReport();
                    MWebView.this.isFirstLoad = false;
                }
                if (MWebView.this._wccListener != null) {
                    MWebView.this._wccListener.onProgressChanged(i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (MWebView.this._wccListener != null) {
                    MWebView.this._wccListener.onJsAlert(str, str2, jsResult);
                }
                jsResult.cancel();
                return true;
            }
        };
        this.mWebViewClient = new WebViewClient() { // from class: com.tencent.midas.oversea.business.h5.webview.MWebView.5
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                APLog.d(MWebView.TAG, "onPageStarted url: " + str);
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageCommitVisible(WebView webView, String str) {
                super.onPageCommitVisible(webView, str);
                APLog.d(MWebView.TAG, "onPageCommitVisible url: " + str);
                if (MWebView.this.isFirstLoad) {
                    MTimer.stop(MTimer.SDK_WEBVIEW_DOM_LOAD);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                APLog.d(MWebView.TAG, "onPageFinished url: " + str);
                super.onPageFinished(webView, str);
                if (MWebView.this.isFirstLoad) {
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_WEBVIEW_LOAD, "");
                    MWebView.this.webviewReport();
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                APLog.i(MWebView.TAG, "shouldOverrideUrlLoading url: " + str);
                if (MWebView.this.isIntercept && MWebView.this.intercept != null && 1 == MWebView.this.intercept.level()) {
                    MWebView.this.intercept.handleUrl(webView, str);
                    return true;
                }
                webView.loadUrl(str);
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                APLog.e(MWebView.TAG, "onReceivedError description: " + str);
                super.onReceivedError(webView, i, str, str2);
                if (MWebView.this.isFirstLoad) {
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_WEBVIEW_ERROR, "");
                    MWebView.this.webviewReport();
                }
                if (MWebView.this._wvcListener != null) {
                    MWebView.this._wvcListener.onRequestError(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                SslCertificate certificate = sslError.getCertificate();
                String url = webView.getUrl();
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedSslError:");
                sb.append(sslError.getPrimaryError());
                sb.append(", cert=");
                sb.append(certificate == null ? Constants.NULL_VERSION_ID : certificate.toString());
                sb.append(", pageUrl=");
                sb.append(url);
                APLog.e(MWebView.TAG, sb.toString());
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                if (MWebView.this._wvcListener != null) {
                    MWebView.this._wvcListener.onRequestError("request error,https ssl error.");
                }
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                Log.d(MWebView.TAG, "shouldInterceptRequest: " + webResourceRequest.getUrl());
                WebResourceResponse queryCache = (MWebView.this.isIntercept && MWebView.this.intercept != null && MWebView.this.intercept.level() == 0) ? MWebView.this.intercept.queryCache(webResourceRequest.getUrl().toString()) : null;
                return queryCache != null ? queryCache : super.shouldInterceptRequest(webView, webResourceRequest);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.isFirstLoad = true;
        WebSettings settings = getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setTextZoom(100);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        this.APP_CACHE_PATH = context.getFilesDir().getAbsolutePath() + "/MWebCache";
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAppCachePath(this.APP_CACHE_PATH);
        settings.setDomStorageEnabled(true);
        if (isUseCache(getContext())) {
            this.isCache = 1;
            settings.setCacheMode(1);
        } else {
            this.isCache = 0;
            settings.setCacheMode(-1);
            setCacheTime(getContext());
        }
        settings.setAllowFileAccess(true);
        settings.setSavePassword(false);
        settings.setLoadsImagesAutomatically(true);
        setWebViewClient(this.mWebViewClient);
        setWebChromeClient(this.mWebChromeClient);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
        }
        if (APTools.isApkInDebug(getContext()) && Build.VERSION.SDK_INT >= 19) {
            APLog.d(TAG, "!!!WebContentsDebuggingEnabled == true  in debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
        }
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
            }
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCacheTime(Context context) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        APSPTools.putInt(context, SP_CACHE_SAVE_TIME, currentTimeMillis);
        APLog.d(TAG, "setCacheTime:" + currentTimeMillis);
    }

    private boolean isUseCache(Context context) {
        int i = APSPTools.getInt(context, SP_CACHE_SAVE_TIME);
        APLog.d(TAG, "isUseCache CacheTime lastTime:" + i);
        return i != 0 && ((int) (System.currentTimeMillis() / 1000)) - i <= 3600;
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str) {
        runOnMainThread(new Runnable() { // from class: com.tencent.midas.oversea.business.h5.webview.MWebView.1
            @Override // java.lang.Runnable
            public void run() {
                MWebView.super.loadUrl(str);
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str, final Map<String, String> map) {
        runOnMainThread(new Runnable() { // from class: com.tencent.midas.oversea.business.h5.webview.MWebView.2
            @Override // java.lang.Runnable
            public void run() {
                MWebView.super.loadUrl(str, map);
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        runOnMainThread(new Runnable() { // from class: com.tencent.midas.oversea.business.h5.webview.MWebView.3
            @Override // java.lang.Runnable
            public void run() {
                MWebView.super.reload();
            }
        });
    }

    public void setInterceptFlag(boolean z) {
        this.isIntercept = z;
    }

    public void setIntercept(IIntercept iIntercept) {
        this.isIntercept = true;
        this.intercept = iIntercept;
    }

    private void runOnMainThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this._mainHandler.post(runnable);
        }
    }

    public void setWebChromeClientListener(WebChromeClientListener webChromeClientListener) {
        this._wccListener = webChromeClientListener;
    }

    public void setWebViewClientListener(WebViewClientListener webViewClientListener) {
        this._wvcListener = webViewClientListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void webviewReport() {
        NetworkManager.singleton().dataReport(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.business.h5.webview.MWebView.6
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
            }
        });
    }
}
