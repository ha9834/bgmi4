package com.tencent.grobot.lite.model.req;

import com.tencent.grobot.lite.common.TLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RecommendNavigationSearchReqInfo extends ReqInfo {
    public static final String TAG = "RecommendNavigationSearchReqInfo";
    public String keyword = "";

    @Override // com.tencent.grobot.lite.model.req.ReqInfo
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            jsonObject.put("keyword", this.keyword);
        } catch (JSONException e) {
            TLog.d(TAG, "getJsonObject, ex=" + e);
        }
        return jsonObject;
    }
}
