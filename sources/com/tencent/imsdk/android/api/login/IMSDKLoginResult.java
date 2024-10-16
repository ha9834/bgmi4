package com.tencent.imsdk.android.api.login;

import com.amazonaws.services.s3.internal.Constants;
import com.intlgame.webview.WebViewManager;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonList;
import com.tencent.imsdk.android.tools.json.JsonProp;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKLoginResult extends IMSDKResult {

    @JsonProp(WebViewManager.KEY_JS_CHANNEL)
    public String channel;

    @JsonProp("iChannel")
    public int channelId;

    @JsonProp("channelPermissions")
    @JsonList("java.lang.String")
    public List<String> channelPermissions;

    @JsonProp("sExtToken")
    public String channelToken;

    @JsonProp("iExtTokenExpireTime")
    public long channelTokenExpire;

    @JsonProp("sChannelId")
    public String channelUserId;

    @JsonProp("iGameId")
    public int gameId;

    @JsonProp("iGuid")
    public String guid;

    @JsonProp("sBirthdate")
    public String guidUserBirthday;

    @JsonProp("sUserName")
    public String guidUserNick;

    @JsonProp("sPictureUrl")
    public String guidUserPortrait;

    @JsonProp("iGender")
    public int guidUserSex;

    @JsonProp("sInnerToken")
    public String innerToken;

    @JsonProp("iExpireTime")
    public long innerTokenExpire;

    @JsonProp("firstLoginTag")
    public int isFirstLogin;

    @JsonProp("iOpenid")
    public String openId;

    public IMSDKLoginResult(int i, int i2) {
        this(i, i2, "");
    }

    public IMSDKLoginResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKLoginResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKLoginResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKLoginResult(String str) throws JSONException {
        super(str);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("channel='");
        sb.append(this.channel);
        sb.append('\'');
        sb.append(", channelId=");
        sb.append(this.channelId);
        sb.append(", gameId=");
        sb.append(this.gameId);
        sb.append(", guid='");
        sb.append(this.guid);
        sb.append('\'');
        sb.append(", openId='");
        sb.append(this.openId);
        sb.append('\'');
        sb.append(", innerToken='");
        sb.append(this.innerToken);
        sb.append('\'');
        sb.append(", innerTokenExpire=");
        sb.append(this.innerTokenExpire);
        sb.append(", guidUserNick='");
        sb.append(this.guidUserNick);
        sb.append('\'');
        sb.append(", guidUserBirthday='");
        sb.append(this.guidUserBirthday);
        sb.append('\'');
        sb.append(", guidUserSex=");
        sb.append(this.guidUserSex);
        sb.append(", guidUserPortrait='");
        sb.append(this.guidUserPortrait);
        sb.append('\'');
        sb.append(", channelUserId='");
        sb.append(this.channelUserId);
        sb.append('\'');
        sb.append(", channelToken='");
        sb.append(this.channelToken);
        sb.append('\'');
        sb.append(", channelTokenExpire=");
        sb.append(this.channelTokenExpire);
        sb.append(", channelPermissions = ");
        List<String> list = this.channelPermissions;
        sb.append(list == null ? Constants.NULL_VERSION_ID : Arrays.deepToString(list.toArray()));
        return sb.toString();
    }
}
