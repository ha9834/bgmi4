package com.tencent.grobot.lite.model.req;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CommonReportReqInfo extends ReqInfo {
    public JSONArray metricLogs;

    @Override // com.tencent.grobot.lite.model.req.ReqInfo
    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("certificate", this.certificate);
            jSONObject.put("metric_logs", this.metricLogs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
