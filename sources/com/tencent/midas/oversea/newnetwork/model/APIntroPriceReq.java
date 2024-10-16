package com.tencent.midas.oversea.newnetwork.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.intlgame.webview.WebViewManager;
import com.tencent.connect.common.Constants;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class APIntroPriceReq extends APMidasHttpRequestBase {
    public static final String TAG = "APIntroPriceReq";
    private List<String> _pList = new ArrayList();
    private String _channel = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void initUrl() {
        if ("release".equals(GlobalData.singleton().env)) {
            setMidasHttpURL("https", MConstants.INTRO_PRICE_CGI);
        } else {
            setMidasHttpURL("https", MConstants.INTRO_PRICE_CGI);
        }
    }

    public APIntroPriceReq setQueryProductList(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this._pList.addAll(list);
        }
        return this;
    }

    public APIntroPriceReq setChannel(String str) {
        this._channel = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void constructParam() {
        addHttpParameters("cmd", "query_user_eligibility");
        addHttpParameters("query_type", "all");
        addHttpParameters(WebViewManager.KEY_JS_CHANNEL, this._channel);
        addHttpParameters("offer_id", GlobalData.singleton().offerID);
        addHttpParameters("openid", GlobalData.singleton().openID);
        addHttpParameters("openid", GlobalData.singleton().openID);
        addHttpParameters("openkey", GlobalData.singleton().openKey);
        addHttpParameters(Constants.PARAM_PLATFORM_ID, GlobalData.singleton().pf);
        addHttpParameters("pfkey", GlobalData.singleton().pfKey);
        addHttpParameters(SDKAnalyticsEvents.PARAMETER_SESSION_ID, GlobalData.singleton().sessionID);
        addHttpParameters("session_type", GlobalData.singleton().sessionType);
        addHttpParameters("encrypt_msg", "0");
        addHttpParameters("msg_len", "0");
        List<String> list = this._pList;
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this._pList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        addHttpParameters(APDataReportManager.SDK_FIELD_PRODUCTID, sb.toString());
    }

    public APIntroPriceReq setUp() {
        initUrl();
        constructParam();
        return this;
    }
}
