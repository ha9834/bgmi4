package com.tencent.smtt.sdk;

import android.R;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class SystemWebChromeClient extends android.webkit.WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    private WebView f6440a;
    private WebChromeClient b;

    public void setupAutoFill(Message message) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.f6440a = webView;
        this.b = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = this.b.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    return BitmapFactory.decodeResource(this.f6440a.getResources(), R.drawable.ic_media_play);
                }
            } catch (Exception unused) {
            }
        }
        return defaultVideoPoster;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.b.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(final android.webkit.ValueCallback<String[]> valueCallback) {
        this.b.getVisitedHistory(new ValueCallback<String[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.1
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String[] strArr) {
                valueCallback.onReceiveValue(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(android.webkit.WebView webView) {
        this.f6440a.a(webView);
        this.b.onCloseWindow(this.f6440a);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(new a(consoleMessage));
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        this.b.onConsoleMessage(new a(str, str2, i));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(android.webkit.WebView webView, boolean z, boolean z2, final Message message) {
        WebView webView2 = this.f6440a;
        webView2.getClass();
        final WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView3 = webViewTransport.getWebView();
                if (webView3 != null) {
                    ((WebView.WebViewTransport) message.obj).setWebView(webView3.a());
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.b.onCreateWindow(this.f6440a, z, z2, obtain);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.b.onGeolocationPermissionsShowPrompt(str, new c(callback));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onHideCustomView() {
        this.b.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        this.f6440a.a(webView);
        return this.b.onJsAlert(this.f6440a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        this.f6440a.a(webView);
        return this.b.onJsBeforeUnload(this.f6440a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        this.f6440a.a(webView);
        return this.b.onJsConfirm(this.f6440a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.f6440a.a(webView);
        return this.b.onJsPrompt(this.f6440a, str, str2, str3, new d(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.b.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i) {
        this.f6440a.a(webView);
        this.b.onProgressChanged(this.f6440a, i);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        this.b.onReachedMaxAppCacheSize(j, j2, new f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(android.webkit.WebView webView, Bitmap bitmap) {
        this.f6440a.a(webView);
        this.b.onReceivedIcon(this.f6440a, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(android.webkit.WebView webView, String str) {
        this.f6440a.a(webView);
        this.b.onReceivedTitle(this.f6440a, str);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onReceivedTouchIconUrl(android.webkit.WebView webView, String str, boolean z) {
        this.f6440a.a(webView);
        this.b.onReceivedTouchIconUrl(this.f6440a, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(android.webkit.WebView webView) {
        this.f6440a.a(webView);
        this.b.onRequestFocus(this.f6440a);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, new b(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, i, new b(customViewCallback));
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final android.webkit.ValueCallback<Uri> valueCallback, String str, String str2) {
        this.b.openFileChooser(new ValueCallback<Uri>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(uri);
            }
        }, str, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, final android.webkit.ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        ValueCallback<Uri[]> valueCallback2 = new ValueCallback<Uri[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.4
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        WebChromeClient.FileChooserParams fileChooserParams2 = new WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.5
            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }
        };
        this.f6440a.a(webView);
        return this.b.onShowFileChooser(this.f6440a, valueCallback2, fileChooserParams2);
    }

    /* loaded from: classes2.dex */
    private class e implements com.tencent.smtt.export.external.interfaces.JsResult {

        /* renamed from: a, reason: collision with root package name */
        JsResult f6450a;

        e(JsResult jsResult) {
            this.f6450a = jsResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f6450a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f6450a.confirm();
        }
    }

    /* loaded from: classes2.dex */
    private class d implements com.tencent.smtt.export.external.interfaces.JsPromptResult {

        /* renamed from: a, reason: collision with root package name */
        JsPromptResult f6449a;

        d(JsPromptResult jsPromptResult) {
            this.f6449a = jsPromptResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f6449a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f6449a.confirm();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsPromptResult
        public void confirm(String str) {
            this.f6449a.confirm(str);
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements com.tencent.smtt.export.external.interfaces.ConsoleMessage {

        /* renamed from: a, reason: collision with root package name */
        private ConsoleMessage.MessageLevel f6446a;
        private String b;
        private String c;
        private int d;

        a(android.webkit.ConsoleMessage consoleMessage) {
            this.f6446a = ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.b = consoleMessage.message();
            this.c = consoleMessage.sourceId();
            this.d = consoleMessage.lineNumber();
        }

        a(String str, String str2, int i) {
            this.f6446a = ConsoleMessage.MessageLevel.LOG;
            this.b = str;
            this.c = str2;
            this.d = i;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public ConsoleMessage.MessageLevel messageLevel() {
            return this.f6446a;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String message() {
            return this.b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String sourceId() {
            return this.c;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public int lineNumber() {
            return this.d;
        }
    }

    /* loaded from: classes2.dex */
    class f implements WebStorage.QuotaUpdater {

        /* renamed from: a, reason: collision with root package name */
        WebStorage.QuotaUpdater f6451a;

        f(WebStorage.QuotaUpdater quotaUpdater) {
            this.f6451a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j) {
            this.f6451a.updateQuota(j);
        }
    }

    /* loaded from: classes2.dex */
    class b implements IX5WebChromeClient.CustomViewCallback {

        /* renamed from: a, reason: collision with root package name */
        WebChromeClient.CustomViewCallback f6447a;

        b(WebChromeClient.CustomViewCallback customViewCallback) {
            this.f6447a = customViewCallback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            this.f6447a.onCustomViewHidden();
        }
    }

    /* loaded from: classes2.dex */
    class c implements GeolocationPermissionsCallback {

        /* renamed from: a, reason: collision with root package name */
        GeolocationPermissions.Callback f6448a;

        c(GeolocationPermissions.Callback callback) {
            this.f6448a = callback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback
        public void invoke(String str, boolean z, boolean z2) {
            this.f6448a.invoke(str, z, z2);
        }
    }
}
