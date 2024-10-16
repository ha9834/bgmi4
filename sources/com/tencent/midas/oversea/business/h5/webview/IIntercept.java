package com.tencent.midas.oversea.business.h5.webview;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public interface IIntercept {
    public static final int QUERY_CACHE = 0;
    public static final int REPLACE_URL = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface InterceptLevel {
    }

    String handleUrl(WebView webView, String str);

    int level();

    WebResourceResponse queryCache(String str);
}
