package com.tencent.midas.oversea.api;

import com.tencent.midas.oversea.comm.APDataReportManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CocosResponse {
    public String resultCode = "";
    public String resultInerCode = "";
    public String billno = "";
    public String payChannel = "";
    public String resultMsg = "";
    public String appExtends = "";

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CocosPayHelper.RES_CODE, this.resultCode);
            jSONObject.put("resultInerCode", this.resultInerCode);
            jSONObject.put(APDataReportManager.SDK_FIELD_BILLNO, this.billno);
            jSONObject.put("payChannel", this.payChannel);
            jSONObject.put(CocosPayHelper.RES_MSG, this.resultMsg);
            jSONObject.put("appExtends", this.appExtends);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
