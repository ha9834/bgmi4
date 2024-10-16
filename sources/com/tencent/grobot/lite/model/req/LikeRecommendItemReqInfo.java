package com.tencent.grobot.lite.model.req;

import android.text.TextUtils;
import com.tencent.grobot.lite.common.TLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LikeRecommendItemReqInfo extends ReqInfo {
    public static final String TAG = "RecommendDetailReqInfo";
    public boolean flag;
    public String resourceId;
    public String type;

    @Override // com.tencent.grobot.lite.model.req.ReqInfo
    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.certificate)) {
                jSONObject.put("certificate", this.certificate);
            }
            if (!TextUtils.isEmpty(this.resourceId)) {
                jSONObject.put("resource_id", this.resourceId);
            }
            if (!TextUtils.isEmpty(this.type)) {
                jSONObject.put("type", this.type);
            }
            jSONObject.put("flag", this.flag);
        } catch (JSONException unused) {
            TLog.d("RecommendDetailReqInfo", "getJsonObject failed");
        }
        return jSONObject;
    }
}
