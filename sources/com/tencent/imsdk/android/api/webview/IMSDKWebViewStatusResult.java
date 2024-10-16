package com.tencent.imsdk.android.api.webview;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKWebViewStatusResult extends IMSDKResult {

    @JsonProp("canGoBack")
    public boolean canGoBack;

    @JsonProp("canGoForward")
    public boolean canGoForward;

    @JsonProp("isOpen")
    public boolean isOpen;

    @JsonProp("isVisible")
    public boolean isVisible;

    public IMSDKWebViewStatusResult(int i) {
        this(i, -1);
    }

    public IMSDKWebViewStatusResult(int i, int i2) {
        this(i, i2, "");
    }

    public IMSDKWebViewStatusResult(int i, String str) {
        this(i, str, -1, "");
    }

    public IMSDKWebViewStatusResult(int i, int i2, String str) {
        this(i, IMSDKErrCode.getMessageByCode(i), i2, str);
    }

    public IMSDKWebViewStatusResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKWebViewStatusResult(String str) throws JSONException {
        super(str);
    }

    public IMSDKWebViewStatusResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return super.toString() + ", isOpen=" + this.isOpen + ", canGoBack=" + this.canGoBack + ", canGoForward=" + this.canGoForward + ", isVisible=" + this.isVisible;
    }
}
