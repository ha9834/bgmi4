package com.tencent.grobot.lite.model.req;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ClearRedPointReqInfo extends ReqInfo {
    @Override // com.tencent.grobot.lite.model.req.ReqInfo
    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("certificate", this.certificate);
            jSONObject.put("read_point_type", "intervention_msg");
            jSONObject.put("read_point_value", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
