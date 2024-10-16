package com.tencent.imsdk.android.api.common;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import com.tencent.imsdk.android.tools.json.JsonString;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKUrlResult extends IMSDKResult {

    @JsonProp("shortUrl")
    @JsonString(def = "")
    public String shortUrl;

    public IMSDKUrlResult(int i) {
        super(i);
    }

    public IMSDKUrlResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKUrlResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKUrlResult() {
    }

    public IMSDKUrlResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKUrlResult(String str) throws JSONException {
        super(str);
    }
}
