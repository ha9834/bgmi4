package com.tencent.imsdk.android.api.auth;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.common.IMSDKFriendInfo;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.tools.json.JsonList;
import com.tencent.imsdk.android.tools.json.JsonProp;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKAuthMigrateResult extends IMSDKResult {

    @JsonProp("sMigrateCode")
    public String migrateCode;

    @JsonProp("ARelationInfo")
    @JsonList("com.tencent.imsdk.android.api.common.IMSDKFriendInfo")
    public List<IMSDKFriendInfo> snsInfoList;

    @JsonProp("validTime")
    public int validTime;

    public IMSDKAuthMigrateResult(int i) {
        this(i, -1);
    }

    public IMSDKAuthMigrateResult(int i, int i2) {
        this(i, i2, "");
    }

    public IMSDKAuthMigrateResult(int i, String str) {
        this(i, str, -1, "");
    }

    public IMSDKAuthMigrateResult(int i, int i2, String str) {
        this(i, IMSDKErrCode.getMessageByCode(i), i2, str);
    }

    public IMSDKAuthMigrateResult(int i, String str, int i2, String str2) {
        super(i, str, i2, str2);
    }

    public IMSDKAuthMigrateResult(String str) throws JSONException {
        super(str);
    }

    public IMSDKAuthMigrateResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResult
    public String toString() {
        return "migrateCode='" + this.migrateCode + "', validTime=" + this.validTime + ", snsInfoList=" + this.snsInfoList;
    }
}
