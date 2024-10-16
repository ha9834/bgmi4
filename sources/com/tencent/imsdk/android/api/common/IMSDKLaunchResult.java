package com.tencent.imsdk.android.api.common;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import com.tencent.imsdk.android.tools.json.JsonString;

/* loaded from: classes.dex */
public class IMSDKLaunchResult extends IMSDKResult {

    @JsonProp("launchData")
    @JsonString(def = "")
    public String launchData;

    @JsonProp("launchUri")
    @JsonString(def = "")
    public String launchUri;

    public IMSDKLaunchResult(int i) {
        super(i);
    }

    public IMSDKLaunchResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKLaunchResult(int i, int i2, String str) {
        super(i, i2, str);
    }
}
