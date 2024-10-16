package com.epicgames.ue4;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazonaws.services.s3.util.Mimetypes;
import java.io.ByteArrayInputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WebViewControl {
    private String NextContent;
    private String NextURL;
    private boolean bClosed;
    private boolean bShown;
    public int curH;
    public int curW;
    public int curX;
    public int curY;
    private long nativePtr;
    private WebViewPositionLayout positionLayout;
    public WebView webView;

    public WebViewControl(long j, final boolean z, final boolean z2) {
        this.nativePtr = j;
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.1
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 19 && z) {
                    WebView.setWebContentsDebuggingEnabled(true);
                }
                WebViewControl.this.webView = new WebView(GameActivity._activity);
                WebViewControl.this.webView.setWebViewClient(new ViewClient());
                WebViewControl.this.webView.setWebChromeClient(new ChromeClient());
                WebViewControl.this.webView.getSettings().setJavaScriptEnabled(true);
                WebViewControl.this.webView.getSettings().setLightTouchEnabled(true);
                WebViewControl.this.webView.setFocusableInTouchMode(true);
                if (z2) {
                    WebViewControl.this.webView.setBackgroundColor(0);
                }
                WebViewControl.this.positionLayout = new WebViewPositionLayout(GameActivity._activity, this);
                WebViewControl.this.positionLayout.addView(WebViewControl.this.webView);
                WebViewControl.this.bShown = false;
                WebViewControl.this.NextURL = null;
                WebViewControl.this.NextContent = null;
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.curH = 0;
                webViewControl.curW = 0;
                webViewControl.curY = 0;
                webViewControl.curX = 0;
            }
        });
    }

    public void ExecuteJavascript(final String str) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.2
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewControl.this.webView != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        WebViewControl.this.webView.evaluateJavascript(str, null);
                        return;
                    }
                    WebViewControl.this.webView.loadUrl("javascript:" + str);
                }
            }
        });
    }

    public void LoadURL(final String str) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.3
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.NextURL = str;
                WebViewControl.this.NextContent = null;
            }
        });
    }

    public void LoadString(final String str, final String str2) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.4
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.NextURL = str2;
                WebViewControl.this.NextContent = str;
            }
        });
    }

    public void StopLoad() {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.5
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.stopLoading();
            }
        });
    }

    public void Reload() {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.6
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.reload();
            }
        });
    }

    public void GoBackOrForward(final int i) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.7
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.goBackOrForward(i);
            }
        });
    }

    public boolean CanGoBackOrForward(int i) {
        return this.webView.canGoBackOrForward(i);
    }

    public void Update(final int i, final int i2, final int i3, final int i4) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.8
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewControl.this.bClosed) {
                    return;
                }
                if (!WebViewControl.this.bShown) {
                    WebViewControl.this.bShown = true;
                    GameActivity._activity.addContentView(WebViewControl.this.positionLayout, new ViewGroup.LayoutParams(-1, -1));
                    WebViewControl.this.webView.requestFocus();
                } else if (WebViewControl.this.webView != null) {
                    if (WebViewControl.this.NextContent != null) {
                        WebViewControl.this.webView.loadDataWithBaseURL(WebViewControl.this.NextURL, WebViewControl.this.NextContent, Mimetypes.MIMETYPE_HTML, "UTF-8", null);
                        WebViewControl.this.NextURL = null;
                        WebViewControl.this.NextContent = null;
                    } else if (WebViewControl.this.NextURL != null) {
                        WebViewControl.this.webView.loadUrl(WebViewControl.this.NextURL);
                        WebViewControl.this.NextURL = null;
                    }
                }
                if (i == WebViewControl.this.curX && i2 == WebViewControl.this.curY && i3 == WebViewControl.this.curW && i4 == WebViewControl.this.curH) {
                    return;
                }
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.curX = i;
                webViewControl.curY = i2;
                webViewControl.curW = i3;
                webViewControl.curH = i4;
                webViewControl.positionLayout.requestLayout();
            }
        });
    }

    public void Close() {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.9
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewControl.this.bShown) {
                    ViewGroup viewGroup = (ViewGroup) WebViewControl.this.webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(WebViewControl.this.webView);
                    }
                    ViewGroup viewGroup2 = (ViewGroup) WebViewControl.this.positionLayout.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(WebViewControl.this.positionLayout);
                    }
                    WebViewControl.this.bShown = false;
                }
                WebViewControl.this.bClosed = true;
            }
        });
    }

    /* loaded from: classes.dex */
    private class ViewClient extends WebViewClient {
        private native byte[] shouldInterceptRequestImpl(String str);

        public native void onPageLoad(String str, boolean z, int i, int i2);

        @Override // android.webkit.WebViewClient
        public native void onReceivedError(WebView webView, int i, String str, String str2);

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideUrlLoading(WebView webView, String str);

        private ViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            byte[] shouldInterceptRequestImpl = shouldInterceptRequestImpl(str);
            if (shouldInterceptRequestImpl != null) {
                return new WebResourceResponse(Mimetypes.MIMETYPE_HTML, "utf8", new ByteArrayInputStream(shouldInterceptRequestImpl));
            }
            return null;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            onPageLoad(str, true, copyBackForwardList.getSize(), copyBackForwardList.getCurrentIndex());
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            onPageLoad(str, false, copyBackForwardList.getSize(), copyBackForwardList.getCurrentIndex());
        }

        public long GetNativePtr() {
            return WebViewControl.this.nativePtr;
        }
    }

    /* loaded from: classes.dex */
    private class ChromeClient extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public native boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);

        @Override // android.webkit.WebChromeClient
        public native void onReceivedTitle(WebView webView, String str);

        private ChromeClient() {
        }

        public long GetNativePtr() {
            return WebViewControl.this.nativePtr;
        }
    }

    public long GetNativePtr() {
        return this.nativePtr;
    }
}
