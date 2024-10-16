package com.tencent.imsdk.android.api.login;

import com.tencent.imsdk.android.api.common.IMSDKFriendInfo;
import com.tencent.imsdk.android.tools.json.JsonList;
import com.tencent.imsdk.android.tools.json.JsonProp;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKBindInfoResult extends IMSDKLoginResult {

    @JsonProp("ARelationInfo")
    @JsonList("com.tencent.imsdk.android.api.common.IMSDKFriendInfo")
    public List<IMSDKFriendInfo> bindInfoList;

    public IMSDKBindInfoResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKBindInfoResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKBindInfoResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKBindInfoResult(String str) throws JSONException {
        super(str);
    }
}
