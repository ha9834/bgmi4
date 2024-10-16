package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
final class md {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    @GuardedBy("InvokeJavascriptWorkaround.class")
    private static Boolean f2336a;

    private md() {
    }

    @TargetApi(19)
    private static boolean a(WebView webView) {
        boolean booleanValue;
        synchronized (md.class) {
            if (f2336a == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    f2336a = true;
                } catch (IllegalStateException unused) {
                    f2336a = false;
                }
            }
            booleanValue = f2336a.booleanValue();
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    public static void a(WebView webView, String str) {
        if (PlatformVersion.isAtLeastKitKat() && a(webView)) {
            webView.evaluateJavascript(str, null);
        } else {
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
        }
    }
}
