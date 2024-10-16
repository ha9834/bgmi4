package com.intlgame.api.webview;

/* loaded from: classes2.dex */
public class INTLWebView {
    public static native void callJS(String str);

    public static native String getEncryptUrl(String str);

    public static native void openUrl(String str, int i, boolean z, boolean z2, boolean z3, String str2);

    public static native void setWebViewObserver(INTLWebViewObserver iNTLWebViewObserver);
}
