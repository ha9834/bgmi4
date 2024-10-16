package com.tencent.imsdk.android.api.help;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKHelpShowResult extends IMSDKResult {

    @JsonProp("state")
    public int state;

    public IMSDKHelpShowResult(int i) {
        super(i);
    }

    public IMSDKHelpShowResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKHelpShowResult(int i, String str) {
        super(i, str);
    }

    public IMSDKHelpShowResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKHelpShowResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKHelpShowResult() {
    }

    public IMSDKHelpShowResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKHelpShowResult(String str) throws JSONException {
        super(str);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return super.toString() + ", state =" + this.state;
    }
}
