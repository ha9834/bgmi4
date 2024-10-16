package com.tencent.imsdk.android.api.webview;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKWebViewTicketResult extends IMSDKResult {

    @JsonProp("sTicket")
    public String ticket;

    public IMSDKWebViewTicketResult(int i) {
        this(i, -1);
    }

    public IMSDKWebViewTicketResult(int i, int i2) {
        this(i, i2, "");
    }

    public IMSDKWebViewTicketResult(int i, String str) {
        this(i, str, -1, "");
    }

    public IMSDKWebViewTicketResult(int i, int i2, String str) {
        this(i, IMSDKErrCode.getMessageByCode(i), i2, str);
    }

    public IMSDKWebViewTicketResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKWebViewTicketResult(String str) throws JSONException {
        super(str);
    }

    public IMSDKWebViewTicketResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return super.toString() + ", ticket=" + this.ticket;
    }
}
