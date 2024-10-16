package com.vk.api.sdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.drive.DriveFile;
import com.tencent.grobot.lite.GameParameters;
import com.tencent.midas.http.midashttp.IAPMidasEncodeKeyType;
import com.vk.api.sdk.a;
import com.vk.api.sdk.auth.d;
import com.vk.api.sdk.k;
import com.vk.api.sdk.utils.m;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.w;
import kotlin.i;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes3.dex */
public class VKWebViewAuthActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6912a = new a(null);
    private static k.b e;
    private WebView b;
    private ProgressBar c;
    private d d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.b.vk_webview_auth_dialog);
        View findViewById = findViewById(a.C0220a.webView);
        h.a((Object) findViewById, "findViewById(R.id.webView)");
        this.b = (WebView) findViewById;
        View findViewById2 = findViewById(a.C0220a.progress);
        h.a((Object) findViewById2, "findViewById(R.id.progress)");
        this.c = (ProgressBar) findViewById2;
        d a2 = d.f6860a.a(getIntent().getBundleExtra("vk_auth_params"));
        if (a2 == null) {
            if (!e()) {
                finish();
            }
        } else {
            this.d = a2;
        }
        c();
        d();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void c() {
        WebView webView = this.b;
        if (webView == null) {
            h.b("webView");
            throw null;
        }
        webView.setWebViewClient(new b(this));
        webView.setVerticalScrollBarEnabled(false);
        webView.setVisibility(4);
        webView.setOverScrollMode(2);
        WebView webView2 = this.b;
        if (webView2 == null) {
            h.b("webView");
            throw null;
        }
        webView2.getSettings().setJavaScriptEnabled(true);
    }

    protected Map<String, String> a() {
        Pair[] pairArr = new Pair[7];
        d dVar = this.d;
        if (dVar == null) {
            h.b(NativeProtocol.WEB_DIALOG_PARAMS);
            throw null;
        }
        pairArr[0] = i.a("client_id", String.valueOf(dVar.a()));
        d dVar2 = this.d;
        if (dVar2 == null) {
            h.b(NativeProtocol.WEB_DIALOG_PARAMS);
            throw null;
        }
        pairArr[1] = i.a("scope", dVar2.e());
        d dVar3 = this.d;
        if (dVar3 == null) {
            h.b(NativeProtocol.WEB_DIALOG_PARAMS);
            throw null;
        }
        pairArr[2] = i.a(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, dVar3.b());
        pairArr[3] = i.a(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "token");
        pairArr[4] = i.a(ServerProtocol.DIALOG_PARAM_DISPLAY, GameParameters.SOURCE_MOBILE);
        pairArr[5] = i.a("v", com.vk.api.sdk.b.d());
        pairArr[6] = i.a("revoke", "1");
        return w.a(pairArr);
    }

    private final void d() {
        String uri;
        try {
            if (e()) {
                uri = getIntent().getStringExtra("vk_validation_url");
            } else {
                Uri.Builder buildUpon = Uri.parse("https://oauth.vk.com/authorize").buildUpon();
                for (Map.Entry<String, String> entry : a().entrySet()) {
                    buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                }
                uri = buildUpon.build().toString();
            }
            WebView webView = this.b;
            if (webView == null) {
                h.b("webView");
                throw null;
            }
            webView.loadUrl(uri);
        } catch (Exception unused) {
            setResult(0);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e() {
        return getIntent().getStringExtra("vk_validation_url") != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        if (e()) {
            return getIntent().getStringExtra("vk_validation_url");
        }
        d dVar = this.d;
        if (dVar != null) {
            return dVar.b();
        }
        h.b(NativeProtocol.WEB_DIALOG_PARAMS);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ProgressBar progressBar = this.c;
        if (progressBar == null) {
            h.b("progress");
            throw null;
        }
        progressBar.setVisibility(8);
        WebView webView = this.b;
        if (webView != null) {
            webView.setVisibility(0);
        } else {
            h.b("webView");
            throw null;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        WebView webView = this.b;
        if (webView == null) {
            h.b("webView");
            throw null;
        }
        webView.destroy();
        m.f6932a.b();
        super.onDestroy();
    }

    /* loaded from: classes3.dex */
    public final class b extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VKWebViewAuthActivity f6913a;
        private boolean b;

        public b(VKWebViewAuthActivity vKWebViewAuthActivity) {
            h.b(vKWebViewAuthActivity, "this$0");
            this.f6913a = vKWebViewAuthActivity;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return a(String.valueOf(webResourceRequest == null ? null : webResourceRequest.getUrl()));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(str);
        }

        private final boolean a(String str) {
            int i = 0;
            if (str == null) {
                return false;
            }
            if (!this.f6913a.e()) {
                String f = this.f6913a.f();
                h.a((Object) f, "redirectUrl");
                if (!l.a(str, f, false, 2, (Object) null)) {
                    return false;
                }
                Intent intent = new Intent("com.vk.auth-token");
                String substring = str.substring(l.a((CharSequence) str, "#", 0, false, 6, (Object) null) + 1);
                h.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                intent.putExtra("extra-token-data", substring);
                Map<String, String> a2 = com.vk.api.sdk.utils.l.a(substring);
                if (a2 == null || (!a2.containsKey("error") && !a2.containsKey("cancel"))) {
                    i = -1;
                }
                this.f6913a.setResult(i, intent);
                this.f6913a.h();
                return true;
            }
            Uri parse = Uri.parse(l.a(str, "#", "?", false, 4, (Object) null));
            if (parse.getQueryParameter("success") != null) {
                VKWebViewAuthActivity vKWebViewAuthActivity = this.f6913a;
                h.a((Object) parse, ShareConstants.MEDIA_URI);
                vKWebViewAuthActivity.a(parse);
            } else if (parse.getQueryParameter("cancel") != null) {
                this.f6913a.h();
            }
            return false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            a(str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.b) {
                return;
            }
            this.f6913a.g();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            int i = -1;
            if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                i = webResourceError.getErrorCode();
            }
            a(i);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            a(i);
        }

        private final void a(int i) {
            this.b = true;
            Intent intent = new Intent();
            intent.putExtra("vw_login_error", i);
            this.f6913a.setResult(0, intent);
            this.f6913a.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        m.f6932a.b();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Uri uri) {
        k.b a2;
        a aVar = f6912a;
        if (uri.getQueryParameter("access_token") != null) {
            String queryParameter = uri.getQueryParameter("access_token");
            String queryParameter2 = uri.getQueryParameter(IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_SECRET);
            String queryParameter3 = uri.getQueryParameter("user_id");
            a2 = new k.b(queryParameter2, queryParameter, queryParameter3 == null ? null : Integer.valueOf(Integer.parseInt(queryParameter3)));
        } else {
            a2 = k.b.f6887a.a();
        }
        e = a2;
        h();
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }

        public final k.b a() {
            return VKWebViewAuthActivity.e;
        }

        public final void a(k.b bVar) {
            VKWebViewAuthActivity.e = bVar;
        }

        public final void a(Activity activity, d dVar, int i) {
            h.b(activity, "activity");
            h.b(dVar, NativeProtocol.WEB_DIALOG_PARAMS);
            Intent putExtra = new Intent(activity, (Class<?>) VKWebViewAuthActivity.class).putExtra("vk_auth_params", dVar.c());
            h.a((Object) putExtra, "Intent(activity, VKWebViewAuthActivity::class.java)\n                .putExtra(VK_EXTRA_AUTH_PARAMS, params.toBundle())");
            activity.startActivityForResult(putExtra, i);
        }

        public final void a(Context context, String str) {
            h.b(context, "context");
            h.b(str, "validationUrl");
            Intent putExtra = new Intent(context, (Class<?>) VKWebViewAuthActivity.class).putExtra("vk_validation_url", str);
            h.a((Object) putExtra, "Intent(context, VKWebViewAuthActivity::class.java)\n                .putExtra(VK_EXTRA_VALIDATION_URL, validationUrl)");
            if (com.vk.api.sdk.a.a.a(context) == null) {
                putExtra.addFlags(DriveFile.MODE_READ_ONLY);
            }
            context.startActivity(putExtra);
        }
    }
}
