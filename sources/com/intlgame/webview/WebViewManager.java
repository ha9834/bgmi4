package com.intlgame.webview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.intlgame.INTLApp;
import com.intlgame.api.INTLResult;
import com.intlgame.api.compliance.INTLCompliance;
import com.intlgame.api.webview.INTLWebViewReqInfo;
import com.intlgame.common.WebViewUtil;
import com.intlgame.foundation.EmptyUtils;
import com.intlgame.foundation.INTLLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class WebViewManager {
    public static final String CONFIG_KEY_BACK_DISABLE = "CONFIG_KEY_BACK_DISABLE";
    public static final String CONFIG_KEY_FULLSCREEN_ENABLE = "WEBVIEW_FULLSCREEN_ENABLE";
    public static final String CONFIG_KEY_LANDSCAPE_HIDEBAR_ENABLE = "WEBVIEW_LANDSCAPE_HIDEBAR_ENABLE";
    public static final String CONFIG_KEY_PORTRAIT_HIDEBAR_ENABLE = "WEBVIEW_PORTRAIT_HIDEBAR_ENABLE";
    public static final String CONFIG_KEY_SHARE_CHANNEL = "WEBVIEW_SHARE_CHANNEL";
    public static final String CONFIG_KEY_X5_CLOSE = "WEBVIEW_X5_CLOSE_ANDROID";
    public static final String CONFIG_KEY_X5_UPLOAD = "WEBVIEW_X5_UPLOAD_ANDROID";
    public static final String EXTRA_ENCRYPT_ENABLE = "encrypt_enable";
    public static final String EXTRA_GAME_ID = "game_id";
    public static final String EXTRA_GUEST_ID = "guest_id";
    public static final String EXTRA_KEY_CALLJS_CONFIG = "webview_calljs";
    public static final String EXTRA_KEY_EXTRA_JSON = "webview_key_extra_json";
    public static final int EXTRA_KEY_FROM_JS = 1;
    public static final String EXTRA_KEY_FROM_KEY = "from_key";
    public static final int EXTRA_KEY_FROM_NATIVE = 2;
    public static final String EXTRA_KEY_SCREEN = "webview_screen";
    public static final String EXTRA_KEY_URL = "webview_url";
    public static final String EXTRA_KEY_WEBVIEW_CONFIG = "webview_config";
    public static final String EXTRA_VERSION_NAME = "version_name";
    public static final String INTL_GAME_ID = "GAME_ID";
    public static final String IPC_WEBVIEW_MSG = "ipc_webview_msg";
    public static final String IPC_WEBVIEW_MSG_TYPE = "ipc_webview_msg_type";
    protected static final String KEY_JAVA_TO_JS_MSG = "java_to_js_msg";
    public static final String KEY_JS_CHANNEL = "channel";
    protected static final String KEY_JS_CREDITCARdCHECKOUT_STATUS = "Status";
    protected static final String KEY_JS_DATA = "jsonData";
    protected static final String KEY_JS_FULLSCREEN = "isFullScreen";
    public static final String KEY_JS_IMGDATA = "imgData";
    protected static final String KEY_JS_SCREEN_ORIENTATION = "screenOrientation";
    public static final String KEY_JS_TOAST = "isToastShow";
    protected static final String KEY_JS_URL = "jsUrl";
    protected static final int MSG_A2S_JS_RETURN = 23;
    protected static final int MSG_A2S_RECEIVE_MESSENGER = 22;
    protected static final int MSG_A2S_WEBVIEW_CLOSED = 21;
    public static final int MSG_A2S_WEBVIEW_NOT_AVAILABLE = 24;
    protected static final int MSG_S2A_JAVA_CALL_JS = 30;
    public static final String PLUGIN_NAME = "INTLWebView";
    public static final int SCREEN_DIRECTION_LANDSCAPE = 3;
    public static final int SCREEN_DIRECTION_PORTRAIT = 2;
    public static final int SCREEN_DIRECTION_SENSOR = 1;
    private static WebViewManager sInstance;

    private WebViewManager() {
        INTLLog.i("init");
    }

    public static WebViewManager getInstance() {
        if (sInstance == null) {
            sInstance = new WebViewManager();
            WebViewUtil.initialize(null);
        }
        return sInstance;
    }

    public void openUrl(INTLWebViewReqInfo iNTLWebViewReqInfo) {
        INTLLog.i("openUrl with url: " + iNTLWebViewReqInfo.url_.replace("%", "%%") + " screen_orientation_: " + iNTLWebViewReqInfo.screen_orientation_ + " system_browser_enable_: " + iNTLWebViewReqInfo.system_browser_enable_ + " full_screen_enable_: " + iNTLWebViewReqInfo.full_screen_enable_ + " encrypt_enable_: " + iNTLWebViewReqInfo.encrypt_enable_ + " extra_json_: " + iNTLWebViewReqInfo.extra_json_);
        if (iNTLWebViewReqInfo.system_browser_enable_) {
            return;
        }
        if (INTLApp.getInstance().getAppContext() == null) {
            INTLLog.e("Must execute USDKPlatform.initialize() first !!!");
            return;
        }
        Intent intent = new Intent(INTLApp.getInstance().getAppContext(), (Class<?>) WebViewActivity.class);
        intent.putExtra("webview_url", iNTLWebViewReqInfo.url_);
        intent.putExtra(EXTRA_KEY_SCREEN, iNTLWebViewReqInfo.screen_orientation_);
        intent.putExtra(EXTRA_KEY_EXTRA_JSON, iNTLWebViewReqInfo.extra_json_);
        intent.putExtra(EXTRA_KEY_WEBVIEW_CONFIG, getWebViewConfig(iNTLWebViewReqInfo));
        String str = " INTLBrowser/1.12.01 mGameId/" + INTLCompliance.getConfigString(INTL_GAME_ID);
        intent.putExtra(EXTRA_GAME_ID, INTLCompliance.getConfigString(INTL_GAME_ID));
        intent.putExtra(EXTRA_VERSION_NAME, "1.12.01");
        intent.putExtra(EXTRA_ENCRYPT_ENABLE, iNTLWebViewReqInfo.encrypt_enable_ ? 1 : 0);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        try {
            INTLApp.getInstance().getAppContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            INTLLog.i("can't start WebViewActivity，Make sure you have register \"WebViewActivity\"");
        }
        WebViewUtil.startKeepAliveService();
    }

    public void callJS(String str) {
        if (!EmptyUtils.isNonEmpty(str)) {
            INTLLog.e("jsonJsPara is null, return");
            return;
        }
        INTLLog.i("jsonJsPara = " + str);
    }

    public void onShareCallback(String str) {
        try {
            new INTLResult(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        INTLLog.i("onResult webViewResult = " + str);
    }

    private String getWebViewConfig(INTLWebViewReqInfo iNTLWebViewReqInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CONFIG_KEY_X5_CLOSE, false);
            jSONObject.put(CONFIG_KEY_X5_UPLOAD, true);
            jSONObject.put(CONFIG_KEY_PORTRAIT_HIDEBAR_ENABLE, false);
            jSONObject.put(CONFIG_KEY_LANDSCAPE_HIDEBAR_ENABLE, false);
            jSONObject.put(CONFIG_KEY_FULLSCREEN_ENABLE, false);
            jSONObject.put(CONFIG_KEY_SHARE_CHANNEL, "");
            jSONObject.put(CONFIG_KEY_BACK_DISABLE, false);
            if (iNTLWebViewReqInfo.full_screen_enable_) {
                jSONObject.put(CONFIG_KEY_FULLSCREEN_ENABLE, true);
            }
            if (!EmptyUtils.isEmpty(iNTLWebViewReqInfo.extra_json_)) {
                JSONObject jSONObject2 = new JSONObject(iNTLWebViewReqInfo.extra_json_);
                if (jSONObject2.has(CONFIG_KEY_BACK_DISABLE)) {
                    jSONObject.put(CONFIG_KEY_BACK_DISABLE, jSONObject2.getBoolean(CONFIG_KEY_BACK_DISABLE));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
