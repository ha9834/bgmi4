package com.intlgame.core.webview;

import com.intlgame.api.INTLBaseParams;
import com.intlgame.api.webview.INTLWebViewReqInfo;

/* loaded from: classes2.dex */
public interface WebViewInterface {
    public static final String KEY_METHOD_ID = "INTL_KEY_METHOD_ID";
    public static final String KEY_OBSERVER_ID = "INTL_KEY_OBSERVER_ID";
    public static final String KEY_SEQ_ID = "INTL_KEY_SEQ_ID";

    void callJS(String str);

    void close();

    void onShareCallback(String str);

    void openUrl(INTLWebViewReqInfo iNTLWebViewReqInfo, INTLBaseParams iNTLBaseParams, int i);
}
