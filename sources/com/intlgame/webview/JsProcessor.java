package com.intlgame.webview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.helpshift.model.AppInfoModel;
import com.intlgame.foundation.EmptyUtils;
import com.intlgame.foundation.INTLLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsProcessor {
    public static final String INTL_KEY_PARMAS = "ParamKey";
    public static final String JS_METHOD_WEBVIEW_CLOSE = "closeWebView";
    public static final String JS_METHOD_WEBVIEW_CREDITCARD_CHECKOUT = "CreditCardCheckout";
    public static final String JS_METHOD_WEBVIEW_GET_GUEST_ID = "getGuestId";
    public static final String JS_METHOD_WEBVIEW_INTL_BROWSER = "OpenUrlInINTLBrowser";
    public static final String JS_METHOD_WEBVIEW_INTL_NAME_AUTH = "OnWebRealNameAuthNotify";
    public static final String JS_METHOD_WEBVIEW_NATIVE = "jsCallNative";
    public static final String JS_METHOD_WEBVIEW_SCREEN = "setFullScreen";
    public static final String JS_METHOD_WEBVIEW_SCREEN_ORIENTATION = "setScreenOrientation";
    public static final String JS_METHOD_WEBVIEW_SEND = "sendMsgWebView";
    public static final String JS_METHOD_WEBVIEW_SEND_RESULT = "jsSendResult";
    public static final String JS_METHOD_WEBVIEW_SHARE = "shareWebView";
    private static final int MAX_JS_MSG_SIZE = 3145728;
    public static final int MSG_JS_OPT_WEBVIEW_BROWSER = 105;
    public static final int MSG_JS_OPT_WEBVIEW_CLOSE = 100;
    public static final int MSG_JS_OPT_WEBVIEW_CREDITCARD_CHECKOUT = 108;
    public static final int MSG_JS_OPT_WEBVIEW_FULLSCREEN = 104;
    public static final int MSG_JS_OPT_WEBVIEW_GET_GUEST_ID = 110;
    public static final int MSG_JS_OPT_WEBVIEW_NATIVE = 101;
    public static final int MSG_JS_OPT_WEBVIEW_NOT_AVAILABLE = 109;
    public static final int MSG_JS_OPT_WEBVIEW_REAL_NAME_NOTIFY = 106;
    public static final int MSG_JS_OPT_WEBVIEW_SCREEN_ORIENTATION = 107;
    public static final int MSG_JS_OPT_WEBVIEW_SEND = 103;
    public static final int MSG_JS_OPT_WEBVIEW_SEND_RESULT = 111;
    public static final int MSG_JS_OPT_WEBVIEW_SHARE = 102;
    public static final String TAG_JS_METHOD = "INTLMethod";
    private static JsProcessor gInstance;
    private Handler mActivityHandler = null;

    private JsProcessor() {
    }

    public static JsProcessor getInstance() {
        if (gInstance == null) {
            gInstance = new JsProcessor();
        }
        return gInstance;
    }

    public void init(Handler handler) {
        this.mActivityHandler = handler;
    }

    public boolean canResolved(String str) {
        if (!EmptyUtils.isNonEmpty(str)) {
            INTLLog.i("jsonMessage is empty");
            return false;
        }
        if (str.length() > MAX_JS_MSG_SIZE) {
            INTLLog.i("js content size should < 3M");
            return false;
        }
        INTLLog.i("jsonMessage = " + str);
        try {
            return new JSONObject(str).has(TAG_JS_METHOD);
        } catch (JSONException e) {
            INTLLog.e("parse jsonMessage error : " + e.getMessage());
            return false;
        }
    }

    public void parseMessage(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            dispatchMessage(parseMethodName(jSONObject.has(TAG_JS_METHOD) ? jSONObject.getString(TAG_JS_METHOD) : ""), str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int parseMethodName(String str) {
        if (EmptyUtils.isNonEmpty(str)) {
            if (str.equalsIgnoreCase(JS_METHOD_WEBVIEW_CLOSE)) {
                return 100;
            }
            if (str.equals(JS_METHOD_WEBVIEW_SHARE)) {
                return 102;
            }
            if (str.equals(JS_METHOD_WEBVIEW_SEND)) {
                return 103;
            }
            if (str.equals(JS_METHOD_WEBVIEW_SCREEN)) {
                return 104;
            }
            if (str.equals(JS_METHOD_WEBVIEW_NATIVE)) {
                return 101;
            }
            if (str.equalsIgnoreCase(JS_METHOD_WEBVIEW_INTL_BROWSER)) {
                return 105;
            }
            if (str.equalsIgnoreCase(JS_METHOD_WEBVIEW_INTL_NAME_AUTH)) {
                return 106;
            }
            if (str.equalsIgnoreCase(JS_METHOD_WEBVIEW_SCREEN_ORIENTATION)) {
                return 107;
            }
            if (str.equalsIgnoreCase(JS_METHOD_WEBVIEW_CREDITCARD_CHECKOUT)) {
                return 108;
            }
            if (str.equalsIgnoreCase(JS_METHOD_WEBVIEW_SEND_RESULT)) {
                return 111;
            }
            if (str.equals(JS_METHOD_WEBVIEW_GET_GUEST_ID)) {
                return 110;
            }
        }
        return 0;
    }

    private void dispatchMessage(int i, String str, String str2) {
        INTLLog.i("msgType = " + i);
        int i2 = 0;
        boolean z = false;
        switch (i) {
            case 100:
            case 110:
                sendMsgToWebViewActivity(i, null);
                return;
            case 101:
            case 102:
            case 103:
            case 108:
                Bundle bundle = new Bundle();
                bundle.putString("jsonData", str);
                sendMsgToWebViewActivity(i, bundle);
                return;
            case 104:
                Bundle bundle2 = new Bundle();
                try {
                    z = new JSONObject(str).getBoolean("isFullScreen");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bundle2.putBoolean("isFullScreen", z);
                sendMsgToWebViewActivity(104, bundle2);
                return;
            case 105:
            case 106:
                try {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("jsonData", new JSONObject(str).getJSONObject(INTL_KEY_PARMAS).toString());
                    sendMsgToWebViewActivity(i, bundle3);
                    return;
                } catch (Exception e2) {
                    INTLLog.i(e2.getMessage());
                    return;
                }
            case 107:
                Bundle bundle4 = new Bundle();
                try {
                    i2 = Integer.parseInt(new JSONObject(str).getString(AppInfoModel.SCREEN_ORIENTATION_KEY));
                } catch (JSONException e3) {
                    INTLLog.e(e3.getMessage());
                }
                bundle4.putInt(AppInfoModel.SCREEN_ORIENTATION_KEY, i2);
                sendMsgToWebViewActivity(i, bundle4);
                return;
            case 109:
            default:
                return;
            case 111:
                Bundle bundle5 = new Bundle();
                bundle5.putString("jsonData", str);
                bundle5.putString("jsUrl", str2);
                sendMsgToWebViewActivity(i, bundle5);
                return;
        }
    }

    private void sendMsgToWebViewActivity(int i, Bundle bundle) {
        Handler handler = this.mActivityHandler;
        if (handler != null) {
            if (handler.hasMessages(i)) {
                this.mActivityHandler.removeMessages(i);
            }
            Message obtainMessage = this.mActivityHandler.obtainMessage(i);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }
}
