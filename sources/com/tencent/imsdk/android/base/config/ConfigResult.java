package com.tencent.imsdk.android.base.config;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ConfigResult extends IMSDKResult {

    @JsonProp("cfg")
    public JSONObject configData;

    @JsonProp("iGameId")
    public int gameId;

    @JsonProp("iPlatform")
    public int platformId;

    @JsonProp("iAllTag")
    public int updateAllTag;

    @JsonProp("sSign")
    public String validKey;

    public ConfigResult() {
    }

    public ConfigResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public ConfigResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public ConfigResult(String str) throws JSONException {
        super(str);
    }
}
