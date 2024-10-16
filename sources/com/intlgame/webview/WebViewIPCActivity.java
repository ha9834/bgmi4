package com.intlgame.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.intlgame.INTLApp;
import com.intlgame.api.INTLResult;
import com.intlgame.api.webview.INTLWebViewRet;
import com.intlgame.common.WebViewUtil;
import com.intlgame.core.INTLMethodID;
import com.intlgame.core.webview.WebViewInterface;
import com.intlgame.foundation.INTLLog;
import com.intlgame.tools.IT;
import com.tencent.hawk.db.DBInfoMeta;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class WebViewIPCActivity extends Activity {
    private int msgType = 0;
    private int observerId = -1;
    private int methodId = -1;
    private String seqId = "";
    private String fromUrl = "";
    private String extraJson = "";

    private void processWebViewShare(int i, String str) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        INTLApp.getInstance().init(getApplicationContext());
        INTLLog.i("onCreate invoked");
        Intent intent = getIntent();
        if (intent == null) {
            INTLLog.i("Intent to WebViewIpcActivity is null");
            finish();
            return;
        }
        this.msgType = intent.getIntExtra(WebViewManager.IPC_WEBVIEW_MSG_TYPE, 0);
        this.extraJson = intent.getStringExtra(WebViewManager.EXTRA_KEY_EXTRA_JSON);
        this.observerId = IT.getJsonInt(this.extraJson, WebViewInterface.KEY_OBSERVER_ID);
        this.methodId = IT.getJsonInt(this.extraJson, WebViewInterface.KEY_METHOD_ID);
        this.seqId = IT.getJsonString(this.extraJson, WebViewInterface.KEY_SEQ_ID);
        String stringExtra = intent.getStringExtra(WebViewManager.IPC_WEBVIEW_MSG);
        this.fromUrl = intent.getStringExtra("jsUrl");
        handlerIPCMsg(this.msgType, stringExtra);
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        INTLLog.i("onActivityResult invoked");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        INTLLog.i("onDestroy invoked");
    }

    private void pluginRetCallback(int i, INTLResult iNTLResult, String str) {
        try {
            IT.onPluginRetCallback(i, iNTLResult, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void handlerIPCMsg(int i, String str) {
        INTLLog.i("msgType = " + i + ", ipcJsonMsg = " + str);
        if (i == 21) {
            INTLWebViewRet iNTLWebViewRet = new INTLWebViewRet();
            iNTLWebViewRet.msg_type_ = 100;
            iNTLWebViewRet.ret_code_ = 0;
            iNTLWebViewRet.ret_msg_ = "close webview";
            int i2 = this.methodId;
            if (i2 == -1) {
                i2 = 301;
            }
            iNTLWebViewRet.method_id_ = i2;
            iNTLWebViewRet.extra_json_ = this.extraJson;
            pluginRetCallback(this.observerId, iNTLWebViewRet, this.seqId);
            WebViewUtil.stopKeepAliveService();
            return;
        }
        if (i == 108) {
            INTLLog.i("CREDITCARD_CHECKOUT notify:" + str);
            try {
                if (Boolean.valueOf(new JSONObject(str).getBoolean(DBInfoMeta.KEY_Status)).booleanValue()) {
                    pluginRetCallback(902, new INTLResult(0), IT.createSequenceId());
                } else {
                    pluginRetCallback(902, new INTLResult(-1), IT.createSequenceId());
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        switch (i) {
            case 23:
                return;
            case 24:
                INTLWebViewRet iNTLWebViewRet2 = new INTLWebViewRet();
                iNTLWebViewRet2.msg_type_ = 109;
                iNTLWebViewRet2.ret_code_ = 1501;
                iNTLWebViewRet2.ret_msg_ = str;
                iNTLWebViewRet2.method_id_ = 301;
                pluginRetCallback(this.observerId, iNTLWebViewRet2, this.seqId);
                WebViewUtil.stopKeepAliveService();
                return;
            default:
                switch (i) {
                    case 101:
                        INTLWebViewRet iNTLWebViewRet3 = new INTLWebViewRet();
                        iNTLWebViewRet3.msg_type_ = 101;
                        iNTLWebViewRet3.msg_json_data_ = str;
                        iNTLWebViewRet3.ret_code_ = 0;
                        iNTLWebViewRet3.ret_msg_ = "js call webview nativie";
                        iNTLWebViewRet3.method_id_ = INTLMethodID.INTL_METHOD_ID_WEBVIEW_JS_CALL;
                        pluginRetCallback(this.observerId, iNTLWebViewRet3, this.seqId);
                        return;
                    case 102:
                    case 103:
                        processWebViewShare(i, str);
                        return;
                    default:
                        return;
                }
        }
    }

    private INTLResult fromH5AuthResult(String str) {
        int jsonInt = IT.getJsonInt(str, "flag");
        if (jsonInt == 0) {
            return new INTLResult(0);
        }
        return new INTLResult(20, jsonInt, IT.getJsonString(str, SocialConstants.PARAM_APP_DESC));
    }
}
