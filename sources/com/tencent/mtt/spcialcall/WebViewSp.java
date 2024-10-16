package com.tencent.mtt.spcialcall;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ZoomButtonsController;
import com.helpshift.util.AttachmentConstants;
import com.tencent.mtt.common.utils.UrlUtility;
import com.tencent.mtt.engine.AppEngine;
import com.tencent.mtt.engine.IWebView;
import com.tencent.mtt.spcialcall.js.SdkJsBridge;
import com.tencent.mtt.spcialcall.sdk.MttApi;
import com.tencent.mtt.spcialcall.sdk.RecommendParams;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class WebViewSp extends WebViewSpBase implements DownloadListener, IWebView {
    protected static final WebSettings.TextSize[] FONT_SIZES = {WebSettings.TextSize.SMALLER, WebSettings.TextSize.NORMAL, WebSettings.TextSize.LARGER, WebSettings.TextSize.LARGEST};
    private static final String UA_PREFIX = "MTT_SDK/5.1/";
    long mId;
    String mJs;
    SdkJsBridge mJsBridge;
    RecommendParams mRecomParams;
    String mUrl;
    private WebView mWebViewInternal;

    public WebViewSp(Context context, IWebViewClientSp iWebViewClientSp) {
        super(context, iWebViewClientSp);
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase
    public void initDownload() {
        this.mWebViewInternal.setDownloadListener(this);
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase
    public void initWebView() {
        if (this.mWebViewInternal == null) {
            this.mWebViewInternal = new WebView(AppEngine.getInstance().getContext());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebViewInternal.removeJavascriptInterface("searchBoxJavaBridge_");
        }
        this.mWebViewInternal.setFocusableInTouchMode(true);
        addView(this.mWebViewInternal, new FrameLayout.LayoutParams(-1, -1));
        initRecomParams();
    }

    public void setWebViewId(long j) {
        this.mId = j;
    }

    public void initRecomParams() {
        this.mRecomParams = new RecommendParams();
        this.mRecomParams.put("from", new StringBuilder(String.valueOf(MttApi.getFromType())).toString());
        this.mRecomParams.put(RecommendParams.KEY_UIN, MttApi.getStringExtra(RecommendParams.KEY_UIN));
    }

    public void initJs(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mJs = null;
            return;
        }
        this.mJs = "javascript:var mttsp_exec=function(service, action, args){var argsJson=args?JSON.stringify(args):'';return prompt(argsJson, 'mttsp:['+[service, action]+']');};" + str;
    }

    public SdkJsBridge getJsBridge() {
        if (this.mJsBridge == null) {
            this.mJsBridge = new SdkJsBridge(this);
        }
        return this.mJsBridge;
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase
    protected void initWebViewClient() {
        this.mWebViewInternal.setWebViewClient(new WebViewClient() { // from class: com.tencent.mtt.spcialcall.WebViewSp.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (WebViewSp.this.mWebViewClient.shouldOverrideUrlLoading(WebViewSp.this, str)) {
                    return true;
                }
                if (UrlUtility.urlSupportedByX5CoreSp(str)) {
                    WebViewSp.this.mRecomParams.put(RecommendParams.KEY_REFFER, webView.getUrl());
                    return false;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    AppEngine.getInstance().getContext().startActivity(intent);
                } catch (Exception unused) {
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                WebViewSp webViewSp = WebViewSp.this;
                webViewSp.mUrl = str;
                if (webViewSp.mJs != null) {
                    webView.loadUrl(WebViewSp.this.mJs);
                }
                super.onPageStarted(webView, str, bitmap);
                WebViewSp.this.mWebViewClient.onPageStarted(WebViewSp.this, str, null);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (WebViewSp.this.mJs != null) {
                    webView.loadUrl(WebViewSp.this.mJs);
                }
                MttApi.insertRecommend(webView, WebViewSp.this.mRecomParams);
                WebViewSp.this.mWebViewClient.onPageFinished(WebViewSp.this, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                WebViewSp.this.mWebViewClient.onReceivedError(WebViewSp.this, i, str, str2);
            }
        });
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase
    protected void initWebChromClient() {
        this.mWebViewInternal.setWebChromeClient(new WebChromeClient() { // from class: com.tencent.mtt.spcialcall.WebViewSp.2
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (WebViewSp.this.mRecomParams != null) {
                    WebViewSp.this.mRecomParams.put("title", str);
                }
                WebViewSp.this.getWebViewClient().onReceivedTitle(WebViewSp.this, str);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (str3 != null) {
                    if (str3.startsWith("mttsp:")) {
                        String str4 = "";
                        try {
                            JSONArray jSONArray = new JSONArray(str3.substring(6));
                            str4 = WebViewProxyManager.getInstance().onJsCall(WebViewSp.this.mId, jSONArray.getString(0), jSONArray.getString(1), str2);
                        } catch (JSONException unused) {
                        }
                        jsPromptResult.confirm(str4);
                        return true;
                    }
                    if (str3.startsWith("mtt_sdk:")) {
                        String str5 = "";
                        try {
                            JSONArray jSONArray2 = new JSONArray(str3.substring(8));
                            str5 = WebViewSp.this.getJsBridge().nativeExec(jSONArray2.getString(0), jSONArray2.getString(1), jSONArray2.optString(2), str2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        jsPromptResult.confirm(str5);
                        return true;
                    }
                }
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                new AlertDialog.Builder(AppEngine.getInstance().getContext()).setTitle("Alert").setMessage(str2).setPositiveButton("confirm", new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.spcialcall.WebViewSp.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.spcialcall.WebViewSp.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.cancel();
                    }
                }).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                ((SpecialCallActivity) WebViewSp.this.getContext()).showCustomView(view, customViewCallback);
            }

            @TargetApi(7)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                openFileChooser(valueCallback);
            }

            @TargetApi(7)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                openFileChooser(valueCallback);
            }

            @TargetApi(7)
            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                SpecialCallActivity specialCallActivity = (SpecialCallActivity) WebViewSp.this.getContext();
                specialCallActivity.uploadFile = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(AttachmentConstants.ALLOW_ALL_MIME);
                specialCallActivity.startActivityForResult(Intent.createChooser(intent, "请选择要上传的文件"), 1014);
            }
        });
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase
    protected void initWebSetting() {
        setCookies();
        WebSettings settings = this.mWebViewInternal.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLoadsImagesAutomatically(true);
        settings.setSavePassword(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(false);
        settings.setSupportMultipleWindows(false);
        if (Build.VERSION.SDK_INT >= 11) {
            settings.setDisplayZoomControls(false);
        } else {
            setZoomControlGone(this.mWebViewInternal);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setDatabasePath(String.valueOf(AppEngine.getInstance().getContext().getFilesDir().getPath()) + "/app_database");
        settings.setGeolocationDatabasePath(String.valueOf(AppEngine.getInstance().getContext().getFilesDir().getPath()) + "/app_geolocationdatabase");
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        Long l = Long.MAX_VALUE;
        settings.setAppCacheMaxSize(l.longValue());
        settings.setAppCachePath(String.valueOf(AppEngine.getInstance().getContext().getFilesDir().getPath()) + "/app_cache");
        Bundle extraParams = ExtraInfo.getExtraParams();
        StringBuilder sb = new StringBuilder();
        sb.append(UA_PREFIX);
        sb.append(settings.getUserAgentString());
        if (extraParams != null && extraParams.containsKey("ua")) {
            sb.append('/');
            sb.append(extraParams.getString("ua"));
        }
        settings.setUserAgentString(sb.toString());
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view) { // from class: com.tencent.mtt.spcialcall.WebViewSp.3
                @Override // android.widget.ZoomButtonsController
                public void setVisible(boolean z) {
                }
            };
            zoomButtonsController.getZoomControls().setVisibility(8);
            declaredField.set(view, zoomButtonsController);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
        }
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public boolean canGoBack() {
        return this.mWebViewInternal.canGoBack();
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public boolean canGoForward() {
        return this.mWebViewInternal.canGoForward();
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public void back(boolean z) {
        this.mWebViewInternal.goBack();
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public void forward() {
        this.mWebViewInternal.goForward();
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public String getTitle() {
        return this.mWebViewInternal.getTitle();
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public void loadUrl(final String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new Runnable() { // from class: com.tencent.mtt.spcialcall.WebViewSp.4
                @Override // java.lang.Runnable
                public void run() {
                    WebViewSp.this.mWebViewInternal.loadUrl(str);
                }
            });
        } else {
            this.mWebViewInternal.loadUrl(str);
        }
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void postUrl(String str, byte[] bArr) {
        this.mWebViewInternal.postUrl(str, bArr);
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public void reload() {
        this.mWebViewInternal.reload();
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public void stopLoading() {
        this.mWebViewInternal.stopLoading();
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public void deactive() {
        super.deactive();
        callHiddenWebViewMethod(this.mWebViewInternal, "onPause");
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public void active() {
        super.active();
        callHiddenWebViewMethod(this.mWebViewInternal, "onResume");
    }

    @Override // com.tencent.mtt.spcialcall.WebViewSpBase, com.tencent.mtt.engine.IWebView
    public void destroy() {
        super.destroy();
        this.mWebViewInternal.destroy();
    }

    private void callHiddenWebViewMethod(WebView webView, String str) {
        if (webView != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(webView, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
    }

    @Override // com.tencent.mtt.engine.IWebView
    public Picture snapshotWholePage(int i, int i2, IWebView.RatioRespect ratioRespect, int i3) {
        return this.mWebViewInternal.capturePicture();
    }

    public void setCookies() {
        Bundle extraParams = ExtraInfo.getExtraParams();
        if (extraParams == null) {
            return;
        }
        String string = extraParams.getString(RecommendParams.KEY_UIN);
        String string2 = extraParams.getString("skey");
        String string3 = extraParams.getString("url");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return;
        }
        CookieSyncManager.createInstance(getContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String host = Uri.parse(string3).getHost();
        String[] split = host.split("\\.");
        if (split.length >= 2) {
            host = String.valueOf(split[split.length - 2]) + "." + split[split.length - 1];
        }
        if (string.length() < 10) {
            StringBuilder sb = new StringBuilder();
            for (int length = string.length(); length < 10; length++) {
                sb.append("0");
            }
            sb.append(string);
            string = sb.toString();
        }
        cookieManager.setCookie(string3, String.format("uin=o%1$s; domain=%2$s; path=/", string, host));
        cookieManager.setCookie(string3, String.format("skey=%1$s; domain=%2$s; path=/", string2, host));
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void configFontSize(int i) {
        this.mWebViewInternal.getSettings().setTextSize(FONT_SIZES[i]);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.mWebViewClient.onDownload(str, str2, str3, str4, j, this.mWebViewInternal.getUrl());
    }
}
