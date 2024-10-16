package com.intlgame.api.webview;

import com.intlgame.api.INTLResult;
import com.intlgame.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class INTLWebViewRet extends INTLResult {

    @JsonProp("msg_json_data_")
    public String msg_json_data_;

    @JsonProp("msg_type_")
    public int msg_type_;

    @JsonProp("networktype")
    public int networkType;

    public INTLWebViewRet() {
    }

    public INTLWebViewRet(int i) {
        this.ret_code_ = i;
    }

    public INTLWebViewRet(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public INTLWebViewRet(String str) throws JSONException {
        super(str);
    }

    @Override // com.intlgame.api.INTLResult
    public String toString() {
        return super.toString() + ", msgType = " + this.msg_type_ + ", msgJsonData = '" + this.msg_json_data_ + '\'';
    }
}
