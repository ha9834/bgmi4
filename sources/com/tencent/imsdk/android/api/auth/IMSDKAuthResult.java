package com.tencent.imsdk.android.api.auth;

import com.amazonaws.services.s3.internal.Constants;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.common.IMSDKFriendInfo;
import com.tencent.imsdk.android.tools.json.JsonList;
import com.tencent.imsdk.android.tools.json.JsonProp;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKAuthResult extends IMSDKResult {

    @JsonProp("iChannel")
    public int channelId;

    @JsonProp("sChannelId")
    public String deviceId;

    @JsonProp("iGameId")
    public int gameId;

    @JsonProp("sInnerToken")
    public String innerToken;

    @JsonProp("firstLoginTag")
    public int isFirstLogin;

    @JsonProp("iOpenid")
    public String openId;

    @JsonProp("ARelationInfo")
    @JsonList("com.tencent.imsdk.android.api.common.IMSDKFriendInfo")
    public List<IMSDKFriendInfo> snsInfoList;

    @JsonProp("iExpireTime")
    public long tokenExpireTime;

    public IMSDKAuthResult(int i, int i2) {
        this(i, i2, "");
    }

    public IMSDKAuthResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKAuthResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKAuthResult(String str) throws JSONException {
        super(str);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", openId='");
        sb.append(this.openId);
        sb.append('\'');
        sb.append(", innerToken='");
        sb.append(this.innerToken);
        sb.append('\'');
        sb.append(", channelId=");
        sb.append(this.channelId);
        sb.append(", gameId=");
        sb.append(this.gameId);
        sb.append(", tokenExpireTime=");
        sb.append(this.tokenExpireTime);
        sb.append(", isFirstLogin='");
        sb.append(this.isFirstLogin);
        sb.append('\'');
        sb.append(", snsInfoList = ");
        List<IMSDKFriendInfo> list = this.snsInfoList;
        sb.append(list == null ? Constants.NULL_VERSION_ID : Arrays.deepToString(list.toArray()));
        return sb.toString();
    }
}
