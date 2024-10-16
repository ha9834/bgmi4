package com.tencent.mtt.spcialcall;

import com.tencent.mtt.engine.IWebView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WebViewSpManager {
    private static Map<Long, IWebView> sWebViewMap = new HashMap();

    public static void addWebView(long j, IWebView iWebView) {
        sWebViewMap.put(Long.valueOf(j), iWebView);
    }

    public static IWebView getWebView(long j) {
        return sWebViewMap.get(Long.valueOf(j));
    }

    public static void removeWebView(long j) {
        sWebViewMap.remove(Long.valueOf(j));
    }
}
