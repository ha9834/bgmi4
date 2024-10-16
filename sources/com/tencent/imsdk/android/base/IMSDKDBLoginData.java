package com.tencent.imsdk.android.base;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKDBLoginData extends IMSDKResult {

    @JsonProp("iChannel")
    public int channelId;

    @JsonProp("sInnerToken")
    public String innerToken;

    @JsonProp("iOpenid")
    public String openId;

    public IMSDKDBLoginData() {
    }

    public IMSDKDBLoginData(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKDBLoginData(String str) throws JSONException {
        super(str);
    }
}
