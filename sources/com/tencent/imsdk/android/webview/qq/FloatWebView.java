package com.tencent.imsdk.android.webview.qq;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* loaded from: classes.dex */
public class FloatWebView extends FrameLayout {
    private ImageButton mCloseButton;
    private WebView mWebView;

    public FloatWebView(Context context) {
        super(context);
        initView(context);
    }

    public FloatWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public FloatWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(0);
        View.inflate(context, ResourceUtil.getLayoutId(context, "com_tencent_imsdk_float_webview"), this);
        this.mWebView = (WebView) findViewById(ResourceUtil.getId(context, "float_webview_core"));
        this.mCloseButton = (ImageButton) findViewById(ResourceUtil.getId(context, "float_webview_close"));
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
    }

    public WebView getWebView(Activity activity) {
        return (WebView) findViewById(ResourceUtil.getId(activity, "float_webview_core"));
    }

    public ImageButton getCloseButton(Activity activity) {
        return (ImageButton) findViewById(ResourceUtil.getId(activity, "float_webview_close"));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setBackgroundColor(i);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setWebViewClient(webViewClient);
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setWebChromeClient(webChromeClient);
        }
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        WebView webView = this.mWebView;
        if (webView != null) {
            return webView.getX5WebViewExtension();
        }
        return null;
    }

    public View getView() {
        WebView webView = this.mWebView;
        if (webView != null) {
            return webView.getView();
        }
        return null;
    }

    public void loadUrl(String str) {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public boolean canGoBack() {
        WebView webView = this.mWebView;
        if (webView != null) {
            return webView.canGoBack();
        }
        return false;
    }

    public void goBack() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.goBack();
        }
    }

    public boolean canGoForward() {
        WebView webView = this.mWebView;
        if (webView != null) {
            return webView.canGoForward();
        }
        return false;
    }

    public void goForward() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.goForward();
        }
    }

    public void reload() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.reload();
        }
    }

    public void stopLoading() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.stopLoading();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.evaluateJavascript(str, valueCallback);
        }
    }

    public void destroy() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.destroy();
        }
    }
}
