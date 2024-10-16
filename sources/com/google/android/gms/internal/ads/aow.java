package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aow implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzuo f2019a;
    final /* synthetic */ WebView b;
    final /* synthetic */ boolean c;
    final /* synthetic */ zzuu d;
    private ValueCallback<String> e = new aox(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public aow(zzuu zzuuVar, zzuo zzuoVar, WebView webView, boolean z) {
        this.d = zzuuVar;
        this.f2019a = zzuoVar;
        this.b = webView;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.getSettings().getJavaScriptEnabled()) {
            try {
                this.b.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.e);
            } catch (Throwable unused) {
                this.e.onReceiveValue("");
            }
        }
    }
}
