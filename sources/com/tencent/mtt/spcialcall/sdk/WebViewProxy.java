package com.tencent.mtt.spcialcall.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mtt.engine.IWebView;
import com.tencent.mtt.spcialcall.JsUtils;
import com.tencent.mtt.spcialcall.WebViewProxyManager;
import com.tencent.mtt.spcialcall.WebViewSpManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WebViewProxy {
    private static final int POST_SUPPORT_BROWSER_VER = 450000;
    private static final int SKEY_SUPPORT_BROWSER_VER = 500000;
    private static final String TAG = "MttApi";
    private Activity activity;
    private long id;
    private HashMap<String, Object> mJsInterfaces;
    private WebViewClientProxy mWebViewClient;
    private boolean isX5 = false;
    private boolean mStarted = false;

    public WebViewProxy(Activity activity) {
        this.id = -1L;
        this.activity = activity;
        this.id = System.currentTimeMillis();
    }

    public long getId() {
        return this.id;
    }

    public void setIsX5(boolean z) {
        this.isX5 = z;
    }

    public void postUrl(String str, byte[] bArr) {
        if (!this.mStarted) {
            openInNewWebView(str, bArr);
            this.mStarted = true;
        } else {
            openInExistWebView(str);
        }
    }

    private void openInNewWebView(String str, byte[] bArr) {
        boolean z;
        MttApi.intent.putExtra(MttApi.WEBVIEW_ID, this.id);
        if (this.mJsInterfaces != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : this.mJsInterfaces.entrySet()) {
                sb.append(JsUtils.generateJs(entry.getKey(), entry.getValue()));
            }
            MttApi.intent.putExtra("js", sb.toString());
        }
        if (this.mJsInterfaces == null || WebViewProxyManager.getInstance().bindServiceIfNeed(this.activity)) {
            z = true;
        } else {
            Log.d(TAG, "Cannot bind remote call service in x5; will use system webview");
            z = false;
        }
        if (z && isMttSupportPost(bArr) && isSkeySupport() && MttApi.loadUrlInMbWnd(this.activity, str, bArr)) {
            this.isX5 = true;
        } else {
            MttApi.loadUrlInLiteMbWnd(this.activity, str, bArr);
            this.isX5 = false;
        }
    }

    private boolean isMttSupportPost(byte[] bArr) {
        return bArr == null || bArr.length == 0 || MttLoader.getBrowserInfo(this.activity).ver >= POST_SUPPORT_BROWSER_VER;
    }

    private boolean isSkeySupport() {
        Bundle extras = MttApi.intent.getExtras();
        return extras == null || TextUtils.isEmpty(extras.getString("skey")) || MttLoader.getBrowserInfo(this.activity).ver >= SKEY_SUPPORT_BROWSER_VER;
    }

    private void openInExistWebView(String str) {
        if (this.isX5) {
            WebViewProxyManager.getInstance().loadUrlRemote(this.id, str);
            return;
        }
        IWebView webView = WebViewSpManager.getWebView(this.id);
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void loadUrl(String str) {
        postUrl(str, null);
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.mJsInterfaces == null) {
            this.mJsInterfaces = new HashMap<>();
        }
        this.mJsInterfaces.put(str, obj);
    }

    public void setWebViewClient(String str, WebViewClientProxy webViewClientProxy) {
        MttApi.intent.putExtra("notifyUrlPrefix", str);
        this.mWebViewClient = webViewClientProxy;
    }

    public Object getJavascriptInterface(String str) {
        HashMap<String, Object> hashMap = this.mJsInterfaces;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public WebViewClientProxy getWebViewClient() {
        return this.mWebViewClient;
    }

    public void configFontSize(int i) {
        if (this.isX5) {
            return;
        }
        WebViewSpManager.getWebView(this.id).configFontSize(i);
    }
}
