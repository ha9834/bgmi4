package com.tencent.imsdk.android.api.relation;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.common.IMSDKFriendInfo;
import com.tencent.imsdk.android.tools.json.JsonList;
import com.tencent.imsdk.android.tools.json.JsonProp;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKFriendListResult extends IMSDKResult {

    @JsonProp("data")
    @JsonList("com.tencent.imsdk.android.api.common.IMSDKFriendInfo")
    public List<IMSDKFriendInfo> sameGameFriendList;

    public IMSDKFriendListResult() {
    }

    public IMSDKFriendListResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKFriendListResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKFriendListResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKFriendListResult(String str) throws JSONException {
        super(str);
    }
}
