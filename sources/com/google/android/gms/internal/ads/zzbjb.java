package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbjb extends ma implements zzbje {

    /* renamed from: a, reason: collision with root package name */
    private final zzbiz f2882a;

    @GuardedBy("this")
    private boolean b;

    @GuardedBy("this")
    private boolean c;

    public zzbjb(Context context, zzbiz zzbizVar) {
        super(context);
        zzk.zzlk().zzuz();
        this.f2882a = zzbizVar;
        super.setWebViewClient(zzbizVar);
    }

    @GuardedBy("this")
    protected void a(boolean z) {
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
    }

    public final synchronized boolean isDestroyed() {
        return this.b;
    }

    @Override // android.webkit.WebView
    public synchronized void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f2882a.a(this);
        a(false);
        zzawz.zzds("Initiating WebView self destruct sequence in 3...");
        zzawz.zzds("Loading blank page in WebView, 2...");
        try {
            super.loadUrl("about:blank");
        } catch (UnsatisfiedLinkError e) {
            zzk.zzlk().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbje
    public final synchronized void zza(zzbja zzbjaVar) {
        zzawz.zzds("Blank page loaded, 1...");
        zzaao();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public synchronized void zzaao() {
        zzawz.zzds("Destroying WebView!");
        b();
        zzbbm.zzeae.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.mc

            /* renamed from: a, reason: collision with root package name */
            private final zzbjb f2335a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2335a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2335a.a();
            }
        });
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    a(true);
                }
                b();
            }
        } finally {
            super.finalize();
        }
    }

    private final synchronized void b() {
        if (!this.c) {
            this.c = true;
            zzk.zzlk().zzva();
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.google.android.gms.internal.ads.ma, android.webkit.WebView
    public synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            super.loadUrl(str);
        } else {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public void onPause() {
        if (isDestroyed()) {
            return;
        }
        super.onPause();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public void onResume() {
        if (isDestroyed()) {
            return;
        }
        super.onResume();
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        super.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.ma, android.webkit.WebView
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // com.google.android.gms.internal.ads.ma, com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public /* bridge */ /* synthetic */ void zzco(String str) {
        super.zzco(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        super.destroy();
    }
}
