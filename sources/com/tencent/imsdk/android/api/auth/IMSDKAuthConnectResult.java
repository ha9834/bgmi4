package com.tencent.imsdk.android.api.auth;

import com.amazonaws.services.s3.internal.Constants;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.common.IMSDKFriendInfo;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.tools.json.JsonList;
import com.tencent.imsdk.android.tools.json.JsonProp;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKAuthConnectResult extends IMSDKResult {

    @JsonProp("iChannel")
    public int channelId;

    @JsonProp("sConfirmCode")
    public String confirmCode;

    @JsonProp("iGender")
    public int gender;

    @JsonProp("iOpenid")
    public String openId;

    @JsonProp("sPictureUrl")
    public String pictureUrl;

    @JsonProp("ARelationInfo")
    @JsonList("com.tencent.imsdk.android.api.common.IMSDKFriendInfo")
    public List<IMSDKFriendInfo> snsInfoList;

    @JsonProp("sUserName")
    public String userName;

    public IMSDKAuthConnectResult(int i) {
        this(i, -1);
    }

    public IMSDKAuthConnectResult(int i, int i2) {
        this(i, i2, "");
    }

    public IMSDKAuthConnectResult(int i, String str) {
        this(i, str, -1, "");
    }

    public IMSDKAuthConnectResult(int i, int i2, String str) {
        this(i, IMSDKErrCode.getMessageByCode(i), i2, str);
    }

    public IMSDKAuthConnectResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKAuthConnectResult(String str) throws JSONException {
        super(str);
    }

    public IMSDKAuthConnectResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", openId='");
        sb.append(this.openId);
        sb.append('\'');
        sb.append(", confirmCode='");
        sb.append(this.confirmCode);
        sb.append('\'');
        sb.append(", channelId='");
        sb.append(this.channelId);
        sb.append('\'');
        sb.append(", userName='");
        sb.append(this.userName);
        sb.append('\'');
        sb.append(", pictureUrl='");
        sb.append(this.pictureUrl);
        sb.append('\'');
        sb.append(", gender='");
        sb.append(this.gender);
        sb.append('\'');
        sb.append(", snsInfoList = ");
        List<IMSDKFriendInfo> list = this.snsInfoList;
        sb.append(list == null ? Constants.NULL_VERSION_ID : Arrays.deepToString(list.toArray()));
        return sb.toString();
    }
}
