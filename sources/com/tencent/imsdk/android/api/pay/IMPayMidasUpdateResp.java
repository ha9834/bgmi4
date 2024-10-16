package com.tencent.imsdk.android.api.pay;

import com.tencent.imsdk.android.api.IMSDKResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMPayMidasUpdateResp extends IMSDKResult {
    public String info;

    public IMPayMidasUpdateResp() {
    }

    public IMPayMidasUpdateResp(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMPayMidasUpdateResp(String str) throws JSONException {
        super(str);
    }
}
