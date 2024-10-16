package com.tencent.grobot.lite.model.req;

import android.text.TextUtils;
import com.tencent.grobot.lite.common.TLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RecommendDetailReqInfo extends ReqInfo {
    public static final String TAG = "RecommendDetailReqInfo";
    public String order_by;
    public int page;
    public String resource_id;
    public int size;
    public String sub_tag_id;
    public String tag_id;
    public String type;

    @Override // com.tencent.grobot.lite.model.req.ReqInfo
    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.certificate)) {
                jSONObject.put("certificate", this.certificate);
            }
            if (!TextUtils.isEmpty(this.type)) {
                jSONObject.put("type", this.type);
            }
            if (!TextUtils.isEmpty(this.resource_id)) {
                jSONObject.put("resource_id", this.resource_id);
            }
            if (!TextUtils.isEmpty(this.order_by)) {
                jSONObject.put("order_by", this.order_by);
            }
            if (!TextUtils.isEmpty(this.tag_id)) {
                jSONObject.put("tag_id", this.tag_id);
            }
            if (!TextUtils.isEmpty(this.sub_tag_id)) {
                jSONObject.put("sub_tag_id", this.sub_tag_id);
            }
            jSONObject.put("page", this.page);
            jSONObject.put("size", this.size);
        } catch (JSONException unused) {
            TLog.d("RecommendDetailReqInfo", "getJsonObject failed");
        }
        return jSONObject;
    }
}
