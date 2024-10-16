package com.tencent.smtt.sdk;

/* loaded from: classes2.dex */
public final class URLUtil {
    public static String guessUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().m(str);
        }
        return android.webkit.URLUtil.guessUrl(str);
    }

    public static String composeSearchUrl(String str, String str2, String str3) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().a(str, str2, str3);
        }
        return android.webkit.URLUtil.composeSearchUrl(str, str2, str3);
    }

    public static byte[] decode(byte[] bArr) throws IllegalArgumentException {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().a(bArr);
        }
        return android.webkit.URLUtil.decode(bArr);
    }

    public static boolean isAssetUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().n(str);
        }
        return android.webkit.URLUtil.isAssetUrl(str);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().o(str);
        }
        return android.webkit.URLUtil.isCookielessProxyUrl(str);
    }

    public static boolean isFileUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().p(str);
        }
        return android.webkit.URLUtil.isFileUrl(str);
    }

    public static boolean isAboutUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().q(str);
        }
        return android.webkit.URLUtil.isAboutUrl(str);
    }

    public static boolean isDataUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().r(str);
        }
        return android.webkit.URLUtil.isDataUrl(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().s(str);
        }
        return android.webkit.URLUtil.isJavaScriptUrl(str);
    }

    public static boolean isHttpUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().t(str);
        }
        return android.webkit.URLUtil.isHttpUrl(str);
    }

    public static boolean isHttpsUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().u(str);
        }
        return android.webkit.URLUtil.isHttpsUrl(str);
    }

    public static boolean isNetworkUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().v(str);
        }
        return android.webkit.URLUtil.isNetworkUrl(str);
    }

    public static boolean isContentUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().w(str);
        }
        return android.webkit.URLUtil.isContentUrl(str);
    }

    public static boolean isValidUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().x(str);
        }
        return android.webkit.URLUtil.isValidUrl(str);
    }

    public static String stripAnchor(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().y(str);
        }
        return android.webkit.URLUtil.stripAnchor(str);
    }

    public static final String guessFileName(String str, String str2, String str3) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().b(str, str2, str3);
        }
        return android.webkit.URLUtil.guessFileName(str, str2, str3);
    }
}
