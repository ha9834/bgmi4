package com.tencent.imsdk.android.base.interfaces;

import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.webview.IMSDKWebViewActionResult;

/* loaded from: classes.dex */
public interface IWebView {
    public static final int WEBVIEW_GET_STATUS_EVENT_CAN_GO_BACK = 16;
    public static final int WEBVIEW_GET_STATUS_EVENT_CAN_GO_FORWARD = 17;
    public static final int WEBVIEW_GET_STATUS_EVENT_IS_ACTIVATED = 9;
    public static final int WEBVIEW_GET_STATUS_EVENT_IS_VISIBLE = 21;
    public static final int WEBVIEW_OPT_EVENT_TYPE_BACK = 6;
    public static final int WEBVIEW_OPT_EVENT_TYPE_CALL_JS = 18;
    public static final int WEBVIEW_OPT_EVENT_TYPE_CLOSE = 5;
    public static final int WEBVIEW_OPT_EVENT_TYPE_FORWARD = 7;
    public static final int WEBVIEW_OPT_EVENT_TYPE_OPEN_URL = 1;
    public static final int WEBVIEW_OPT_EVENT_TYPE_RELOAD = 8;
    public static final int WEBVIEW_OPT_EVENT_TYPE_SET_BG_COLOR = 19;
    public static final int WEBVIEW_OPT_EVENT_TYPE_SET_ORIENTATION = 3;
    public static final int WEBVIEW_OPT_EVENT_TYPE_SET_POSITION = 4;
    public static final int WEBVIEW_OPT_EVENT_TYPE_SET_ZOOM = 2;
    public static final int WEBVIEW_OPT_EVENT_TYPE_SHOW_WEBVIEW = 20;

    boolean getStatus(int i, Object... objArr);

    void optCmd(int i, Object... objArr);

    void registerActionObserver(IMSDKResultListener<IMSDKWebViewActionResult> iMSDKResultListener);
}
