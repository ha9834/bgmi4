package com.intlgame.webview;

import com.intlgame.api.INTLBaseParams;
import com.intlgame.api.webview.INTLWebViewReqInfo;
import com.intlgame.core.webview.WebViewInterface;
import com.intlgame.foundation.EmptyUtils;
import com.intlgame.foundation.INTLLog;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class INTLWebView implements WebViewInterface {
    @Override // com.intlgame.core.webview.WebViewInterface
    public void openUrl(INTLWebViewReqInfo iNTLWebViewReqInfo, INTLBaseParams iNTLBaseParams, int i) {
        String str = iNTLBaseParams.seq_id_;
        INTLLog.i("[ " + str + " ] INTLWebView openUrl with url: " + iNTLWebViewReqInfo.url_.replace("%", "%%") + " wbInfo screen_orientation_: " + iNTLWebViewReqInfo.screen_orientation_ + " wbInfo system_browser_enable_: " + iNTLWebViewReqInfo.system_browser_enable_ + " wbInfo full_screen_enable_: " + iNTLWebViewReqInfo.full_screen_enable_ + " wbInfo encrypt_enable_: " + iNTLWebViewReqInfo.encrypt_enable_ + " wbInfo extraJson: " + iNTLWebViewReqInfo.extra_json_ + " baseParams method_id_: " + iNTLBaseParams.method_id_ + " baseParams seq_id_: " + iNTLBaseParams.seq_id_ + " baseParams channel: " + iNTLBaseParams.channel_ + " baseParams extraJson: " + iNTLBaseParams.extra_json_ + " observerId: " + i);
        if (EmptyUtils.isEmpty(iNTLWebViewReqInfo.extra_json_)) {
            iNTLWebViewReqInfo.extra_json_ = "{}";
        }
        try {
            JSONObject jSONObject = new JSONObject(iNTLWebViewReqInfo.extra_json_);
            jSONObject.put(WebViewInterface.KEY_OBSERVER_ID, i);
            jSONObject.put(WebViewInterface.KEY_SEQ_ID, str);
            jSONObject.put(WebViewInterface.KEY_METHOD_ID, iNTLBaseParams.method_id_);
            iNTLWebViewReqInfo.extra_json_ = jSONObject.toString();
        } catch (Exception e) {
            INTLLog.i(e.getMessage());
        }
        WebViewManager.getInstance().openUrl(iNTLWebViewReqInfo);
    }

    @Override // com.intlgame.core.webview.WebViewInterface
    public void callJS(String str) {
        INTLLog.i("INTLWebView jsonJsPara = " + str);
        WebViewManager.getInstance().callJS(str);
    }

    @Override // com.intlgame.core.webview.WebViewInterface
    public void onShareCallback(String str) {
        INTLLog.i("INTLWebView Share callback:" + str);
    }

    @Override // com.intlgame.core.webview.WebViewInterface
    public void close() {
        INTLLog.i("INTLWebView close");
    }
}
