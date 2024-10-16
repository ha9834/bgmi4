package com.tencent.imsdk.android.api.common;

import com.tencent.imsdk.android.tools.json.JsonProp;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKFriendInfo extends JsonSerializable {

    @JsonProp("iChannel")
    public int channelId;

    @JsonProp("sChannelId")
    public String channelUserId;

    @JsonProp("sEmail")
    public String email;

    @JsonProp("iGender")
    public int gender;

    @JsonProp("iOpenid")
    public String openId;

    @JsonProp("sMobile")
    public String phone;

    @JsonProp("sPictureUrl")
    public String pictureUrl;

    @JsonProp("sUserName")
    public String userName;

    public IMSDKFriendInfo() {
    }

    public IMSDKFriendInfo(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKFriendInfo(String str) throws JSONException {
        super(str);
    }

    public String toString() {
        return "openId='" + this.openId + "', channelId=" + this.channelId + ", channelUserId='" + this.channelUserId + "', userName='" + this.userName + "', gender=" + this.gender + ", pictureUrl='" + this.pictureUrl + "', email='" + this.email + "', phone='" + this.phone + '\'';
    }
}
