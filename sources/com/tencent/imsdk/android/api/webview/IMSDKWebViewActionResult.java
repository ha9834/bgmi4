package com.tencent.imsdk.android.api.webview;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKWebViewActionResult extends IMSDKResult {

    @JsonProp("stateCode")
    public int stateCode;

    public IMSDKWebViewActionResult(int i) {
        this(i, -1);
    }

    public IMSDKWebViewActionResult(int i, int i2) {
        this(i, i2, "");
    }

    public IMSDKWebViewActionResult(int i, String str) {
        this(i, str, -1, "");
    }

    public IMSDKWebViewActionResult(int i, int i2, String str) {
        this(i, IMSDKErrCode.getMessageByCode(i), i2, str);
    }

    public IMSDKWebViewActionResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKWebViewActionResult(String str) throws JSONException {
        super(str);
    }

    public IMSDKWebViewActionResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return super.toString() + ", stateCode=" + this.stateCode;
    }
}
