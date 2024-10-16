package com.tencent.imsdk.android.api.notice;

import com.amazonaws.services.s3.internal.Constants;
import com.helpshift.util.ErrorReportProvider;
import com.tencent.imsdk.android.tools.json.JsonList;
import com.tencent.imsdk.android.tools.json.JsonProp;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKNoticeInfo extends JsonSerializable {

    @JsonProp(ErrorReportProvider.KEY_APP_ID)
    public String appId;

    @JsonProp("extraJson")
    public String extraJson;

    @JsonProp("noticeContent")
    public String noticeContent;

    @JsonProp("noticeContentType")
    public int noticeContentType;

    @JsonProp("noticeContentWebUrl")
    public String noticeContentWebUrl;

    @JsonProp("noticeEndTime")
    public long noticeEndTime;

    @JsonProp("noticeId")
    public int noticeId;

    @JsonProp("noticeLang")
    public String noticeLanguage;

    @JsonProp("noticePics")
    @JsonList("com.tencent.imsdk.android.api.notice.IMSDKNoticePic")
    public List<IMSDKNoticePic> noticePics;

    @JsonProp("noticeScene")
    public int noticeScene;

    @JsonProp("noticeStartTime")
    public long noticeStartTime;

    @JsonProp("noticeTitle")
    public String noticeTitle;

    @JsonProp("noticeUpdateTime")
    public long noticeUpdateTime;

    @JsonProp("noticeUrl")
    public String noticeUrl;

    @JsonProp("openId")
    public String openId;

    @JsonProp("screenName")
    public String screenName;

    @JsonProp("stateCode")
    public String stateCode;

    public IMSDKNoticeInfo() {
    }

    public IMSDKNoticeInfo(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKNoticeInfo(String str) throws JSONException {
        super(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IMSDKNoticeInfo{stateCode='");
        sb.append(this.stateCode);
        sb.append('\'');
        sb.append(", noticeId=");
        sb.append(this.noticeId);
        sb.append(", appId='");
        sb.append(this.appId);
        sb.append('\'');
        sb.append(", openId='");
        sb.append(this.openId);
        sb.append('\'');
        sb.append(", noticeUrl='");
        sb.append(this.noticeUrl);
        sb.append('\'');
        sb.append(", noticeScene=");
        sb.append(this.noticeScene);
        sb.append(", noticeStartTime=");
        sb.append(this.noticeStartTime);
        sb.append(", noticeEndTime=");
        sb.append(this.noticeEndTime);
        sb.append(", noticeUpdateTime=");
        sb.append(this.noticeUpdateTime);
        sb.append(", screenName='");
        sb.append(this.screenName);
        sb.append('\'');
        sb.append(", noticeLanguage='");
        sb.append(this.noticeLanguage);
        sb.append('\'');
        sb.append(", noticeContentType=");
        sb.append(this.noticeContentType);
        sb.append(", noticeTitle='");
        sb.append(this.noticeTitle);
        sb.append('\'');
        sb.append(", noticeContent='");
        sb.append(this.noticeContent);
        sb.append('\'');
        sb.append(", noticePics=");
        List<IMSDKNoticePic> list = this.noticePics;
        sb.append(list == null ? Constants.NULL_VERSION_ID : Arrays.deepToString(list.toArray()));
        sb.append(", noticeContentWebUrl='");
        sb.append(this.noticeContentWebUrl);
        sb.append('\'');
        sb.append(", extraJson='");
        sb.append(this.extraJson);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
