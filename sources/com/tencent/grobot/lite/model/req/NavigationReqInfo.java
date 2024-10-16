package com.tencent.grobot.lite.model.req;

import android.text.TextUtils;
import com.tencent.grobot.lite.common.TLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class NavigationReqInfo extends ReqInfo {
    private static final String TAG = "NavigationReqInfo";
    public String tagId = null;
    public String subTagId = null;
    public String orderBy = null;
    public int page = 1;
    public int size = 6;

    @Override // com.tencent.grobot.lite.model.req.ReqInfo
    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.certificate)) {
                jSONObject.put("certificate", this.certificate);
            }
            if (!TextUtils.isEmpty(this.tagId)) {
                jSONObject.put("tag_id", this.tagId);
            }
            if (!TextUtils.isEmpty(this.subTagId)) {
                jSONObject.put("sub_tag_id", this.subTagId);
            }
            if (!TextUtils.isEmpty(this.orderBy)) {
                jSONObject.put("order_by", this.orderBy);
            }
            jSONObject.put("page", this.page);
            jSONObject.put("size", this.size);
        } catch (JSONException e) {
            TLog.d(TAG, "getJsonObject failed, ex=" + e);
        }
        return jSONObject;
    }
}
