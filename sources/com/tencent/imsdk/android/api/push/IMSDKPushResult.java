package com.tencent.imsdk.android.api.push;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKPushResult extends IMSDKResult {

    @JsonProp(FirebaseAnalytics.Param.CONTENT)
    public String content;

    @JsonProp("flag")
    public int flag;

    @JsonProp("token")
    public String token;

    public IMSDKPushResult(int i) {
        super(i);
    }

    public IMSDKPushResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKPushResult(int i, String str) {
        super(i, str);
    }

    public IMSDKPushResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKPushResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKPushResult() {
    }

    public IMSDKPushResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKPushResult(String str) throws JSONException {
        super(str);
    }
}
