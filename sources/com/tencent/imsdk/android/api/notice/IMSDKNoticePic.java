package com.tencent.imsdk.android.api.notice;

import com.tencent.imsdk.android.tools.json.JsonProp;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKNoticePic extends JsonSerializable {

    @JsonProp("extraJson")
    public String extraJson;

    @JsonProp("noticeId")
    public int noticeId;

    @JsonProp("picHash")
    public String picHash;

    @JsonProp("picSize")
    public String picSize;

    @JsonProp("picTitle")
    public String picTitle;

    @JsonProp("picUrl")
    public String picUrl;

    @JsonProp("screenDir")
    public int screenDir;

    public IMSDKNoticePic() {
    }

    public IMSDKNoticePic(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKNoticePic(String str) throws JSONException {
        super(str);
    }

    public String toString() {
        return "IMSDKNoticePic{noticeId=" + this.noticeId + ", picUrl='" + this.picUrl + "', screenDir=" + this.screenDir + ", picHash='" + this.picHash + "', picTitle='" + this.picTitle + "', picSize='" + this.picSize + "', extraJson='" + this.extraJson + "'}";
    }
}
