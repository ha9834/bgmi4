package com.tencent.imsdk.android.api.notice;

import com.amazonaws.services.s3.internal.Constants;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.tools.json.JsonList;
import com.tencent.imsdk.android.tools.json.JsonProp;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKNoticeResult extends IMSDKResult {

    @JsonProp("noticelist")
    @JsonList("com.tencent.imsdk.android.api.notice.IMSDKNoticeInfo")
    public List<IMSDKNoticeInfo> noticesList;

    @JsonProp("noticeNum")
    public int noticesNum;

    public IMSDKNoticeResult(int i) {
        super(i);
    }

    public IMSDKNoticeResult(int i, int i2) {
        super(i, i2);
    }

    public IMSDKNoticeResult(int i, String str) {
        super(i, str);
    }

    public IMSDKNoticeResult(int i, int i2, String str) {
        super(i, i2, str);
    }

    public IMSDKNoticeResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKNoticeResult() {
    }

    public IMSDKNoticeResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMSDKNoticeResult(String str) throws JSONException {
        super(str);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", noticesNum=");
        sb.append(this.noticesNum);
        sb.append(", noticesList=");
        List<IMSDKNoticeInfo> list = this.noticesList;
        sb.append(list == null ? Constants.NULL_VERSION_ID : Arrays.deepToString(list.toArray()));
        return sb.toString();
    }
}
