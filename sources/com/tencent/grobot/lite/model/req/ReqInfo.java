package com.tencent.grobot.lite.model.req;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ReqInfo {
    public String certificate = "";

    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("certificate", this.certificate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
