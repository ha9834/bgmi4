package com.ihoc.mgpa.g;

import com.tencent.midas.oversea.api.CocosPayHelper;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public String f5578a = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
    public String b = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("gamekey");
            JSONObject jSONObject2 = jSONObject.getJSONObject("gamecfg");
            for (int i = 0; i < jSONArray.length(); i++) {
                sb.append(jSONObject2.getString(jSONArray.getString(i)));
            }
            this.f5578a = sb.toString();
            this.b = jSONObject2.toString();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA_optimizeConfig", "optimizeConfig: config's json data parse failed.");
            return false;
        }
    }
}
