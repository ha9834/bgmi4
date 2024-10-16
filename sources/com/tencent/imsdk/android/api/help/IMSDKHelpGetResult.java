package com.tencent.imsdk.android.api.help;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKHelpGetResult extends IMSDKResult {

    @JsonProp("count")
    public int count;

    public IMSDKHelpGetResult(int i) {
        super(i);
    }

    public IMSDKHelpGetResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKHelpGetResult(int i, String str) {
        super(i, str);
    }

    public IMSDKHelpGetResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKHelpGetResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKHelpGetResult() {
    }

    public IMSDKHelpGetResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKHelpGetResult(String str) throws JSONException {
        super(str);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return super.toString() + ", count =" + this.count;
    }
}
