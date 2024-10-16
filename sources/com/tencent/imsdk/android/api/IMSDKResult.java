package com.tencent.imsdk.android.api;

import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.tools.json.JsonProp;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import com.tencent.imsdk.android.tools.json.JsonString;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKResult extends JsonSerializable {

    @JsonProp("imsdkRetCode")
    public int imsdkRetCode;

    @JsonProp("imsdkRetMsg")
    @JsonString(def = "")
    public String imsdkRetMsg;

    @JsonProp("retExtraJson")
    public String retExtraJson;

    @JsonProp("code")
    public int thirdRetCode;

    @JsonProp(SocialConstants.PARAM_APP_DESC)
    public String thirdRetMsg;

    public IMSDKResult(int i) {
        this(i, -1, "");
    }

    public IMSDKResult(int i, int i2) {
        this(i, i2, IMSDKErrCode.getMessageByCode(i2));
    }

    public IMSDKResult(int i, String str) {
        this(i, str, -1, "");
    }

    public IMSDKResult(int i, int i2, String str) {
        this(i, null, i2, str);
    }

    public IMSDKResult(int i, String str, int i2, String str2) {
        this.imsdkRetCode = i;
        this.imsdkRetMsg = IMSDKErrCode.getMessageByCode(i);
        this.thirdRetCode = i2;
        this.thirdRetMsg = str2;
    }

    public IMSDKResult() {
    }

    public IMSDKResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.imsdkRetMsg = IMSDKErrCode.getMessageByCode(this.imsdkRetCode);
    }

    public IMSDKResult(String str) throws JSONException {
        super(str);
        this.imsdkRetMsg = IMSDKErrCode.getMessageByCode(this.imsdkRetCode);
    }

    public String toString() {
        return "imsdkRetCode=" + this.imsdkRetCode + ", imsdkRetMsg='" + this.imsdkRetMsg + "', thirdRetCode=" + this.thirdRetCode + ", thirdRetMsg='" + this.thirdRetMsg + "', retExtraJson='" + this.retExtraJson + '\'';
    }
}
