package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"NewApi", "Override"})
/* loaded from: classes2.dex */
public class SystemWebViewClient extends android.webkit.WebViewClient {
    private static String c;

    /* renamed from: a, reason: collision with root package name */
    private WebViewClient f6452a;
    private WebView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.b = webView;
        this.f6452a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, String str) {
        this.b.a(webView);
        this.f6452a.onLoadResource(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(webView);
        return this.f6452a.shouldOverrideUrlLoading(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
        boolean z;
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.b.showDebugView(uri)) {
            return true;
        }
        this.b.a(webView);
        if (Build.VERSION.SDK_INT >= 24) {
            Object a2 = com.tencent.smtt.utils.c.a(webResourceRequest, "isRedirect");
            if (a2 instanceof Boolean) {
                z = ((Boolean) a2).booleanValue();
                return this.f6452a.shouldOverrideUrlLoading(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            }
        }
        z = false;
        return this.f6452a.shouldOverrideUrlLoading(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
        com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest;
        if (Build.VERSION.SDK_INT >= 11 && (shouldInterceptRequest = this.f6452a.shouldInterceptRequest(this.b, str)) != null) {
            return new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r10, android.webkit.WebResourceRequest r11) {
        /*
            r9 = this;
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 0
            r1 = 21
            if (r10 >= r1) goto L8
            return r0
        L8:
            if (r11 != 0) goto Lb
            return r0
        Lb:
            r10 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L24
            java.lang.String r1 = "isRedirect"
            java.lang.Object r1 = com.tencent.smtt.utils.c.a(r11, r1)
            boolean r2 = r1 instanceof java.lang.Boolean
            if (r2 == 0) goto L24
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
            r5 = r10
            goto L25
        L24:
            r5 = 0
        L25:
            com.tencent.smtt.sdk.SystemWebViewClient$e r10 = new com.tencent.smtt.sdk.SystemWebViewClient$e
            android.net.Uri r1 = r11.getUrl()
            java.lang.String r3 = r1.toString()
            boolean r4 = r11.isForMainFrame()
            boolean r6 = r11.hasGesture()
            java.lang.String r7 = r11.getMethod()
            java.util.Map r8 = r11.getRequestHeaders()
            r1 = r10
            r2 = r9
            r1.<init>(r3, r4, r5, r6, r7, r8)
            com.tencent.smtt.sdk.WebViewClient r11 = r9.f6452a
            com.tencent.smtt.sdk.WebView r1 = r9.b
            com.tencent.smtt.export.external.interfaces.WebResourceResponse r10 = r11.shouldInterceptRequest(r1, r10)
            if (r10 != 0) goto L4f
            return r0
        L4f:
            android.webkit.WebResourceResponse r11 = new android.webkit.WebResourceResponse
            java.lang.String r0 = r10.getMimeType()
            java.lang.String r1 = r10.getEncoding()
            java.io.InputStream r2 = r10.getData()
            r11.<init>(r0, r1, r2)
            java.util.Map r0 = r10.getResponseHeaders()
            r11.setResponseHeaders(r0)
            int r0 = r10.getStatusCode()
            java.lang.String r10 = r10.getReasonPhrase()
            int r1 = r11.getStatusCode()
            if (r0 != r1) goto L81
            if (r10 == 0) goto L84
            java.lang.String r1 = r11.getReasonPhrase()
            boolean r1 = r10.equals(r1)
            if (r1 != 0) goto L84
        L81:
            r11.setStatusCodeAndReasonPhrase(r0, r10)
        L84:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.SystemWebViewClient.shouldInterceptRequest(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
    }

    /* loaded from: classes2.dex */
    private class e implements com.tencent.smtt.export.external.interfaces.WebResourceRequest {
        private String b;
        private boolean c;
        private boolean d;
        private boolean e;
        private String f;
        private Map<String, String> g;

        public e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.b = str;
            this.c = z;
            this.d = z2;
            this.e = z3;
            this.f = str2;
            this.g = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return Uri.parse(this.b);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.c;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.g;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        return this.f6452a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(android.webkit.WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.f6452a.onFormResubmission(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, String str) {
        com.tencent.smtt.utils.d a2;
        TbsLog.v("TbsPerfTest", "PageLoadFinished!");
        if (c == null && (a2 = com.tencent.smtt.utils.d.a()) != null) {
            a2.a(true);
            c = Boolean.toString(true);
        }
        this.b.a(webView);
        this.b.f6488a++;
        this.f6452a.onPageFinished(this.b, str);
        TbsLog.d("sdkreport", "SystemWebViewclient.onPageFinished--Pv=" + this.b.f6488a);
        if ("com.qzone".equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.c();
        if (this.b.getContext() == null || TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
        this.b.a(webView);
        this.f6452a.onPageStarted(this.b, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i, String str, String str2) {
        this.b.a(webView);
        this.f6452a.onReceivedError(this.b, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        this.b.a(webView);
        this.f6452a.onReceivedError(this.b, webResourceRequest != null ? new f(webResourceRequest) : null, webResourceError != null ? new com.tencent.smtt.export.external.interfaces.WebResourceError() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.1
            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public CharSequence getDescription() {
                return webResourceError.getDescription();
            }

            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public int getErrorCode() {
                return webResourceError.getErrorCode();
            }
        } : null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.b.a(webView);
        this.f6452a.onReceivedHttpError(this.b, new f(webResourceRequest), new g(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(android.webkit.WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b.a(webView);
        this.f6452a.onReceivedHttpAuthRequest(this.b, new b(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
        this.b.a(webView);
        this.f6452a.doUpdateVisitedHistory(this.b, str, z);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(12)
    public void onReceivedLoginRequest(android.webkit.WebView webView, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.f6452a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(8)
    public void onReceivedSslError(android.webkit.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (Build.VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.f6452a.onReceivedSslError(this.b, new c(sslErrorHandler), new d(sslError));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(android.webkit.WebView webView, ClientCertRequest clientCertRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.f6452a.onReceivedClientCertRequest(this.b, new a(clientCertRequest));
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends com.tencent.smtt.export.external.interfaces.ClientCertRequest {

        /* renamed from: a, reason: collision with root package name */
        private ClientCertRequest f6454a;

        public a(ClientCertRequest clientCertRequest) {
            this.f6454a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.f6454a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            return this.f6454a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            return this.f6454a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.f6454a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            return this.f6454a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.f6454a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.f6454a.proceed(privateKey, x509CertificateArr);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(android.webkit.WebView webView, float f2, float f3) {
        this.b.a(webView);
        this.f6452a.onScaleChanged(this.b, f2, f3);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(android.webkit.WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.f6452a.onTooManyRedirects(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        this.f6452a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    /* loaded from: classes2.dex */
    private static class b implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler {

        /* renamed from: a, reason: collision with root package name */
        private HttpAuthHandler f6455a;

        b(HttpAuthHandler httpAuthHandler) {
            this.f6455a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.f6455a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.f6455a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.f6455a.useHttpAuthUsernamePassword();
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements com.tencent.smtt.export.external.interfaces.SslErrorHandler {

        /* renamed from: a, reason: collision with root package name */
        SslErrorHandler f6456a;

        c(SslErrorHandler sslErrorHandler) {
            this.f6456a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.f6456a.proceed();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.f6456a.cancel();
        }
    }

    /* loaded from: classes2.dex */
    private static class d implements com.tencent.smtt.export.external.interfaces.SslError {

        /* renamed from: a, reason: collision with root package name */
        SslError f6457a;

        d(SslError sslError) {
            this.f6457a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            return this.f6457a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i) {
            return this.f6457a.addError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i) {
            return this.f6457a.hasError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.f6457a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            return this.f6457a.getUrl();
        }
    }

    /* loaded from: classes2.dex */
    private static class f implements com.tencent.smtt.export.external.interfaces.WebResourceRequest {

        /* renamed from: a, reason: collision with root package name */
        WebResourceRequest f6459a;

        f(WebResourceRequest webResourceRequest) {
            this.f6459a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f6459a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f6459a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return this.f6459a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f6459a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f6459a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object a2 = com.tencent.smtt.utils.c.a(this.f6459a, "isRedirect");
                if (a2 instanceof Boolean) {
                    return ((Boolean) a2).booleanValue();
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    private static class g extends com.tencent.smtt.export.external.interfaces.WebResourceResponse {

        /* renamed from: a, reason: collision with root package name */
        WebResourceResponse f6460a;

        public g(WebResourceResponse webResourceResponse) {
            this.f6460a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            return this.f6460a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            return this.f6460a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            return this.f6460a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            return this.f6460a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            return this.f6460a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.f6460a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            this.f6460a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            this.f6460a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            this.f6460a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            this.f6460a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.f6460a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(android.webkit.WebView webView, String str) {
        this.b.a(webView);
        this.f6452a.onPageCommitVisible(this.b, str);
    }
}
