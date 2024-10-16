package com.tencent.smtt.sdk;

import android.content.Context;

/* loaded from: classes2.dex */
public class WebViewDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static WebViewDatabase f6498a;
    private Context b;

    protected WebViewDatabase(Context context) {
        this.b = context;
    }

    public static WebViewDatabase getInstance(Context context) {
        return a(context);
    }

    private static synchronized WebViewDatabase a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (f6498a == null) {
                f6498a = new WebViewDatabase(context);
            }
            webViewDatabase = f6498a;
        }
        return webViewDatabase;
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().b(this.b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
    }

    @Deprecated
    public void clearUsernamePassword() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().c(this.b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
        }
    }

    public boolean hasHttpAuthUsernamePassword() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().d(this.b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
    }

    public void clearHttpAuthUsernamePassword() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().e(this.b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
        }
    }

    public boolean hasFormData() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().f(this.b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
    }

    public void clearFormData() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().g(this.b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
        }
    }
}
